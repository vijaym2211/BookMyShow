package org.example.bookmyshow.services;

import com.stripe.exception.StripeException;
import org.example.bookmyshow.dtos.PaymentRequestDTO;
import org.example.bookmyshow.models.Payment;
import org.example.bookmyshow.models.Ticket;

public interface PaymentService {

    public String createPaymentIntent(int ticketId, double amount) throws StripeException;
    public void completePayment(String paymentIntentId) throws StripeException;
}
