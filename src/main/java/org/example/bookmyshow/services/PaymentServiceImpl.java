package org.example.bookmyshow.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.example.bookmyshow.models.Payment;
import org.example.bookmyshow.models.PaymentStatus;
import org.example.bookmyshow.models.Ticket;
import org.example.bookmyshow.models.TicketStatus;
import org.example.bookmyshow.repositories.PaymentRepository;
import org.example.bookmyshow.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final TicketRepository ticketRepository;

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public PaymentServiceImpl(PaymentRepository paymentRepository, TicketRepository ticketRepository) {
        this.paymentRepository = paymentRepository;
        this.ticketRepository = ticketRepository;
    }

    public String createPaymentIntent(int ticketId, double amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) (amount * 100))  // Stripe accepts amount in cents
                        .setCurrency("inr")
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);

        // Save Payment in DB
        Payment payment = new Payment();
        payment.setTransactionId(intent.getId());
        payment.setTransactionAmount(amount);
        payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());

        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        payment.setTicket(ticket);

        paymentRepository.save(payment);

        return intent.getClientSecret();
    }

    public void completePayment(String paymentIntentId) throws StripeException {
        Stripe.apiKey = stripeSecretKey;
        PaymentIntent intent = PaymentIntent.retrieve(paymentIntentId);
        intent.capture();

        // Update payment status in DB
        Payment payment = paymentRepository.findByTransactionId(paymentIntentId);
        if (payment != null) {
            payment.setStatus(PaymentStatus.SUCCESS);
            paymentRepository.save(payment);

            // Mark ticket as confirmed
            Ticket ticket = payment.getTicket();
            ticket.setStatus(TicketStatus.CONFIRMED);
            ticketRepository.save(ticket);
        }
    }
}