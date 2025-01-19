package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.*;

import java.util.List;

@Data
public class BookTicketResponseDTO {

    private int ticketId;
    private Movie movie;
    private Show show;
    private List<ShowSeat> bookedSeats;
    private User user;
    private TicketStatus status;
    private double totalamount;
    private List<Payment> payments;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<ShowSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
