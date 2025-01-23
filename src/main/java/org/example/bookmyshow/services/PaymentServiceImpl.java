//package org.example.bookmyshow.services;
////package org.example.bookmyshow.models.Order;
//
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//public class PaymentServiceImpl implements PaymentService{
//    public <RazorpayClient> String intiatePayment(double amount) {
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
//    public void verifyPayment(String paymentId, String orderId, String signature) {
//        // Verification logic (using Razorpay SDK or your logic)
////        Razopay razopay = new Razopay();
//
//    }
//
//}
//
//
////
////import com.razorpay.Order;
////import com.razorpay.RazorpayException;
////import com.razorpay.Signature;
////import com.razorpay.Razorpay;
////import java.util.Map;
////
////public class PaymentService {
////
////    private static final String RAZORPAY_KEY_SECRET = "your_razorpay_secret"; // Your Razorpay Secret Key
////
////    public void verifyPayment(String paymentId, String orderId, String signature) {
////        try {
////            // Razorpay client instance
////            Razorpay razorpay = new Razorpay();
////
////            // Prepare data
////            String generatedSignature = Signature.verifyPayment(paymentId, orderId, RAZORPAY_KEY_SECRET);
////
////            // Verify if the signature matches
////            if (signature.equals(generatedSignature)) {
////                System.out.println("Payment verified successfully");
////                // Handle payment success logic here (e.g., update order status)
////            } else {
////                System.out.println("Payment verification failed");
////                // Handle verification failure logic here
////            }
////        } catch (RazorpayException e) {
////            System.err.println("Error during payment verification: " + e.getMessage());
////            // Handle exception (e.g., log the error)
////        }
////    }
////}
//
