package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
//    List<Movie> saveAll(List<Movie> movies);
}
