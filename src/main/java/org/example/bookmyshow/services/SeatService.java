package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat addSeat(Seat seat){
        return seatRepository.save(seat);
    }

}
