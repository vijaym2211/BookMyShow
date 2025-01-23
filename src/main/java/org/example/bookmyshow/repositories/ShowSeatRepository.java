package org.example.bookmyshow.repositories;

import jakarta.persistence.LockModeType;
import org.example.bookmyshow.models.SeatStatus;
import org.example.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findAllByIdInAndSeatStatus(List<Integer> ids, SeatStatus status);
    
//    List<ShowSeat> saveAll(List<ShowSeat> seats);

}
