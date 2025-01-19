//package org.example.bookmyshow.models;
//
//import jakarta.persistence.Entity;
//import lombok.Data;
//import org.json.JSONObject;
//
////@Data
//@Entity
//public class Order extends BaseModel{
//    private int amount;
//    private String currency;
//    private String receipt;
//    private boolean paymentCaptured;
//    private String status;
//    private JSONObject notes;
//
//    public Order(String id, int amount, String currency, String receipt, boolean paymentCaptured, String status, JSONObject notes) {
//        this.id = Integer.parseInt(id);
//        this.amount = amount;
//        this.currency = currency;
//        this.receipt = receipt;
//        this.paymentCaptured = paymentCaptured;
//        this.status = status;
//        this.notes = notes;
//    }
//
//
//    // Method to display order details (optional)
//    @Override
//    public String toString() {
//        return "Order [id=" + id + ", amount=" + amount + ", currency=" + currency + ", receipt=" + receipt +
//                ", paymentCaptured=" + paymentCaptured + ", status=" + status + ", notes=" + notes + "]";
//    }
//
//
//    public JSONObject getNotes() {
//        return notes;
//    }
//
//    public void setNotes(JSONObject notes) {
//        this.notes = notes;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public boolean isPaymentCaptured() {
//        return paymentCaptured;
//    }
//
//    public void setPaymentCaptured(boolean paymentCaptured) {
//        this.paymentCaptured = paymentCaptured;
//    }
//
//    public String getReceipt() {
//        return receipt;
//    }
//
//    public void setReceipt(String receipt) {
//        this.receipt = receipt;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//}
