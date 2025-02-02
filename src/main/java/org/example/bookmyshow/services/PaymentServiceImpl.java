package org.example.bookmyshow.services;
//package org.example.bookmyshow.models.Order;

import com.razorpay.Order;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

public class PaymentServiceImpl implements PaymentService {

}


















//
//@Service
//public class PaymentServiceImpl implements PaymentService{
//    public String intiatePayment(double amount) {
//        try{
//            RazorpayClient razopay = new RazorpayClient("api_key", "api_secret");
//
//            JSONObject paymentLinkRequest = new JSONObject();
//            paymentLinkRequest.put("amount",1000);
//            paymentLinkRequest.put("currency","INR");
////            paymentLinkRequest.put("accept_partial",true);
////            paymentLinkRequest.put("first_min_partial_amount",100);
////            paymentLinkRequest.put("expire_by",1691097057);
//            paymentLinkRequest.put("reference_id","TS1989");
//            paymentLinkRequest.put("description","Payment for policy no #23456");
////            JSONObject customer = new JSONObject();
////            customer.put("name","+919000090000");
////            customer.put("contact","Gaurav Kumar");
////            customer.put("email","gaurav.kumar@example.com");
////            paymentLinkRequest.put("customer",customer);
////            JSONObject notify = new JSONObject();
////            notify.put("sms",true);
////            notify.put("email",true);
////            paymentLinkRequest.put("notify",notify);
////            paymentLinkRequest.put("reminder_enable",true);
////            JSONObject notes = new JSONObject();
////            notes.put("policy_name","Jeevan Bima");
////            paymentLinkRequest.put("notes",notes);
//            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
//            paymentLinkRequest.put("callback_method","get");
//
//            PaymentLink payment = razopay.paymentLink.create(paymentLinkRequest);
//            String paymentLink = payment.get("short_url");
//            return paymentLink;
//
//        } catch (RazorpayException e) {
//            throw new RuntimeException("Payment initiation failed", e);
//        }
//    }
//
//    public void verifyPayment(String paymentId, String orderId, String signature) {
//        // Verification logic (using Razorpay SDK or your logic)
////        Razopay razopay = new Razopay();
//
//    }
//
//}


//
//import com.razorpay.Order;
//import com.razorpay.RazorpayException;
//import com.razorpay.Signature;
//import com.razorpay.Razorpay;
//import java.util.Map;
//
//public class PaymentService {
//
//    private static final String RAZORPAY_KEY_SECRET = "your_razorpay_secret"; // Your Razorpay Secret Key
//
//    public void verifyPayment(String paymentId, String orderId, String signature) {
//        try {
//            // Razorpay client instance
//            Razorpay razorpay = new Razorpay();
//
//            // Prepare data
//            String generatedSignature = Signature.verifyPayment(paymentId, orderId, RAZORPAY_KEY_SECRET);
//
//            // Verify if the signature matches
//            if (signature.equals(generatedSignature)) {
//                System.out.println("Payment verified successfully");
//                // Handle payment success logic here (e.g., update order status)
//            } else {
//                System.out.println("Payment verification failed");
//                // Handle verification failure logic here
//            }
//        } catch (RazorpayException e) {
//            System.err.println("Error during payment verification: " + e.getMessage());
//            // Handle exception (e.g., log the error)
//        }
//    }
//}

