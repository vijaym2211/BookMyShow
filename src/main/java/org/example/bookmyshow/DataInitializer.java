//package org.example.bookmyshow;
//
//
//import com.github.javafaker.Faker;
//import org.example.bookmyshow.models.*;
//import org.example.bookmyshow.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final CityRepository cityRepository;
//    private final TheaterRepository theaterRepository;
//
//    public DataInitializer(CityRepository cityRepository, TheaterRepository theaterRepository) {
//        this.cityRepository = cityRepository;
//        this.theaterRepository = theaterRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        createCitiesAndTheaters();
//    }
//
//    private void createCitiesAndTheaters() {
//        // Create and save cities
//        City city1 = new City("Mumbai");
//        City city2 = new City("Delhi");
//        cityRepository.saveAll(Arrays.asList(city1, city2));
//
//        // Create theaters for each city
//        Theater theater1 = new Theater("PVR Cinemas", city1);
//        Theater theater2 = new Theater("Inox", city1);
//        Theater theater3 = new Theater("Cinepolis", city2);
//
//        // Save theaters explicitly before associating them with other entities
//        theaterRepository.saveAll(Arrays.asList(theater1, theater2, theater3));
//
//        // Associate theaters with their respective cities
//        city1.setTheaters(Arrays.asList(theater1, theater2));
//        city2.setTheaters(Arrays.asList(theater3));
//
//        // Save cities with updated associations
//        cityRepository.saveAll(Arrays.asList(city1, city2));
//    }
//}