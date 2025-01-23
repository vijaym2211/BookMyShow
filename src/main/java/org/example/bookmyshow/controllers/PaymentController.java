//package org.example.bookmyshow.controllers;
//
//import org.example.bookmyshow.dtos.PaymentVerificationDTO;
//import org.example.bookmyshow.services.PaymentServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//@Controller
//public class PaymentController {
//
//    @Autowired
//    private PaymentServiceImpl paymentService;
//
//    @PostMapping("/payment")
//    public ResponseEntity<String> initiatePayment(@RequestBody double amount) {
//        String orderId = this.paymentService.intiatePayment(amount);
//        return ResponseEntity.ok(orderId);
//    }
//
//    @PostMapping("/verify")
//    public ResponseEntity<String> verifyPayment(@RequestBody PaymentVerificationDTO paymentVerificationDTO) {
//        try {
//            paymentService.verifyPayment(paymentVerificationDTO.getPaymentId(),
//                    paymentVerificationDTO.getOrderId(),
//                    paymentVerificationDTO.getSignature()
//            );
//            return ResponseEntity.ok("Paymenet verifed sucessfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment verification failed");
//        }
//    }
//}
