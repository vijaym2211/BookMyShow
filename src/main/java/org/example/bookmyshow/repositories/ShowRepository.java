package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {

//    List<Show> saveAll(List<Show> shows);
}
