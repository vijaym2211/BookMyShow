package org.example.bookmyshow.controllers;

import com.stripe.exception.StripeException;
import org.example.bookmyshow.services.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class PaymentController {

    private final PaymentServiceImpl paymentService;
    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Map<String, String> createPaymentIntent(@RequestParam int ticketId, @RequestParam double amount) throws StripeException {
        String clientSecret = paymentService.createPaymentIntent(ticketId, amount);
        return Map.of("clientSecret", clientSecret);
    }

    @PostMapping("/complete")
    public String completePayment(@RequestParam String paymentIntentId) throws StripeException {
        paymentService.completePayment(paymentIntentId);
        return "Payment successful";
    }
}
