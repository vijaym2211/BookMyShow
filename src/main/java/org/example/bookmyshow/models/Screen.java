package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
@Entity
public class Screen extends BaseModel{
    private String name;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    @Enumerated(value = EnumType.ORDINAL) //use when we use enum
    @ElementCollection   //use when we have list of enum's
    private List<Feature> features;

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
