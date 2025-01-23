package org.example.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.bookmyshow.models.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

//    List<City> saveAll(List<City> cities);

}

