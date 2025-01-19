package org.example.bookmyshow.services;
import org.example.bookmyshow.exception.InvalidUserException;
import org.example.bookmyshow.exception.SomeOrAllSeatsAreUnavailable;
import org.example.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket bookTicket(int userId, List<Integer> showSeatId) throws InvalidUserException, SomeOrAllSeatsAreUnavailable;
}
