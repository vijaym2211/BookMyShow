package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket save(Ticket ticket);
}
