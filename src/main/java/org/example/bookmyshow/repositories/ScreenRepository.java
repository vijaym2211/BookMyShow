package org.example.bookmyshow.repositories;

import org.example.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {

//    Screen saveAll(List<Screen> screens);
}
