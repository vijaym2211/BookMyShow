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
    private Theatre theatre;

    @OneToMany
    private List<Seat> seats;
    @Enumerated(value = EnumType.ORDINAL) //use when we use enum
    @ElementCollection   //use when we have list of enum's
    private List<Feature> features;

}
