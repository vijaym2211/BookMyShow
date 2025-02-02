package org.example.bookmyshow.services;

import com.stripe.exception.StripeException;
import org.example.bookmyshow.exception.InvalidUserException;
import org.example.bookmyshow.exception.SomeOrAllSeatsAreUnavailable;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;
    private SeatTypeShowRepository seatTypeShowRepository;

    @Autowired
    public TicketServiceImpl(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                             TicketRepository ticketRepository, SeatTypeShowRepository seatTypeShowRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.seatTypeShowRepository = seatTypeShowRepository;  // Add this line
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(int userId, List<Integer> showSeatId) throws InvalidUserException, SomeOrAllSeatsAreUnavailable, StripeException {

        /*
        1. Check if the userId is valid, i.e. user is present in DB, if not throw exception
        2. Check if the showSeatIds are valid, else throw an exception
        3. Start the transaction
        4. Check if all the seats are available
        5. If yes, then set all the seat statuses to "BLOCKED" and user to the userId
        6. Generate the ticket
        7. store the ticket in db
        8. Return the ticket
         */

        // Check if the userId is valid
        User user = userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("User not Found"));

        // Fetch available seats
        List<ShowSeat> availableSeats = showSeatRepository.findAllByIdInAndSeatStatus(showSeatId, SeatStatus.AVAILABLE);

        Set<Integer> availableSeatsIds = availableSeats.stream().map(ShowSeat::getId).collect(Collectors.toSet());
//        List<Integer> unAvailableSeatsIds = availableSeatsIds.stream().filter(seatId -> !availableSeatsIds.contains(seatId)).collect(Collectors.toList());
        List<Integer> unAvailableSeatsIds = showSeatId.stream()
                .filter(seatId -> !availableSeatsIds.contains(seatId))
                .collect(Collectors.toList());
        if (!unAvailableSeatsIds.isEmpty()) {
            throw new SomeOrAllSeatsAreUnavailable("Some/All seats are booked. Unavailable seat IDs: " + unAvailableSeatsIds);
        }

//        availableSeats.forEach(showSeat -> {
//            showSeat.setBookedBy(user);
//            showSeat.setSeatStatus(SeatStatus.BLOCKED);
//        });

        // Fetch the price per seat from SeatTypeShow
        double totalAmount = 0;
        for (ShowSeat showSeat : availableSeats) {
            SeatTypeShow seatTypeShow = seatTypeShowRepository.findByShowAndSeatType(showSeat.getShow(), showSeat.getSeat().getSeatType());
            if (seatTypeShow != null) {
                totalAmount += seatTypeShow.getPrice();
            }
        }


        for (ShowSeat showSeat : availableSeats) {
            showSeat.setBookedBy(user);
            showSeat.setSeatStatus(SeatStatus.BOOKED);
        }

        showSeatRepository.saveAll(availableSeats);

        //Create Ticket
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShowSeats(availableSeats);
        Show show = availableSeats.get(0).getShow();
        ticket.setShow(show);
        ticket.setMovie(show.getMovie());
        ticket.setStatus(TicketStatus.PENDING);

        ticket.setTotalamount(totalAmount); // Use the total amount calculated

        return ticketRepository.save(ticket);


    }

}
