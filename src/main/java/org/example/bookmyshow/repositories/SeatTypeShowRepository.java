package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.models.SeatTypeShow;
import org.example.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatTypeShowRepository extends JpaRepository<SeatTypeShow, Long> {
    SeatTypeShow findByShowAndSeatType(Show show, SeatType seatType);
}
