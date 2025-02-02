package org.example.bookmyshow.controllers;

import com.stripe.exception.StripeException;
import org.example.bookmyshow.dtos.BookTicketRequestDTO;
import org.example.bookmyshow.dtos.BookTicketResponseDTO;
import org.example.bookmyshow.exception.InvalidUserException;
import org.example.bookmyshow.exception.SomeOrAllSeatsAreUnavailable;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tickets")
public class TicketController {
//    User selects seats and confirms the booking.
//    System blocks the seats and generates a ticket in "PENDING" state.
//    User initiates payment via Stripe.
//    Upon successful payment, the ticket status changes to "CONFIRMED".
//    If the payment fails, the seats are released.

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws InvalidUserException, SomeOrAllSeatsAreUnavailable, StripeException {
        try{
            Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getUserId(),bookTicketRequestDTO.getShowSeatsId());
            BookTicketResponseDTO bookTicketDTO = mapToResponseDTO(ticket);

//            bookTicketDTO.setTicketId(ticket.getId());
//            bookTicketDTO.setMovie(ticket.getMovie());
//            bookTicketDTO.setShow(ticket.getShow());
//            bookTicketDTO.setBookedSeats(ticket.getShowSeats());
//            bookTicketDTO.setStatus(ticket.getStatus());
//            bookTicketDTO.setUser(ticket.getUser());
//            bookTicketDTO.setTotalamount(ticket.getTotalamount());
//            bookTicketDTO.setPayments(ticket.getPayments());
            return bookTicketDTO;
        }catch (Exception e) {
            return null;
        }
    }
    /**
     * Helper method to map Ticket to ResponseTicketDTO
     */
    private BookTicketResponseDTO mapToResponseDTO(Ticket ticket) {
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();

        responseDTO.setTicketId(ticket.getId());
        responseDTO.setMovie(ticket.getMovie());
        responseDTO.setShow(ticket.getShow());
        responseDTO.setBookedSeats(ticket.getShowSeats());
        responseDTO.setUser(ticket.getUser());
        responseDTO.setStatus(ticket.getStatus());
        responseDTO.setTotalamount(ticket.getTotalamount());
        responseDTO.setPayments(ticket.getPayments());

        return responseDTO;
    }
}
