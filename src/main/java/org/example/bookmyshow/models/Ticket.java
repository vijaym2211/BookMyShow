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
//
//    @ManyToOne
//    private Movie movie;
//    @ManyToOne
//    private Show show;
//    @OneToMany
//    private List<ShowSeat> showSeats;
//    @ManyToOne
//    private User user;
//    private TicketStatus status;
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
