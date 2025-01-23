package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

//    List<Show> saveAll(List<Show> shows);
}
