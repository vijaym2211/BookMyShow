//package org.example.bookmyshow.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//public class Ticket extends BaseModel{
//    @ManyToOne
//    private Show show;
//    @OneToMany
//    private List<Seat> seat;
//    @ManyToOne
//    private User user;
//    private double totalamount;
//
//    @Enumerated(EnumType.STRING)
//    private BookingStatus status;
//
//    @OneToMany
//    private List<Payment> payments;
//
//
//}
