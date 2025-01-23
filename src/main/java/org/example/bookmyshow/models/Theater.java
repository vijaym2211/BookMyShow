package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Data
@Entity
public class Theater extends BaseModel{
    private String name;
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Screen> screens;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false) // Create a foreign key in Theater table
    private City city; // Reference to the City object


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}