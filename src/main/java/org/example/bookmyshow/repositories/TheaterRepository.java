package org.example.bookmyshow.repositories;
import org.example.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
//    List<Theater> saveAll(List<Theater> theaters);
}
