package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.BookTicketRequestDTO;
import org.example.bookmyshow.dtos.BookTicketResponseDTO;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.services.TicketService;
import org.example.bookmyshow.services.TicketServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    public BookTicketResponseDTO bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) {
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
