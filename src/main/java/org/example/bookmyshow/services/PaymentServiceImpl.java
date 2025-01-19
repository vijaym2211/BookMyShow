//package org.example.bookmyshow.services;
////package org.example.bookmyshow.models.Order;
//
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//public class PaymentServiceImpl implements PaymentService{
//    public String intiatePayment(double amount) {
//        try{
//            RazorpayClient razopay = new RazorpayClient("api_key", "api_secret");
//            JSONObject options = new JSONObject();
//            options.put("amount", amount * 10000);
//            options.put("currency", "INR");
//            options.put("receipt", "txt_" + UUID.randomUUID());
//            Order order = razopay.orders.create(options);
//
//        } catch (RazorpayException e) {
//            throw new RuntimeException("Payment initiation failed", e);
//        }
//    }
//
//}
