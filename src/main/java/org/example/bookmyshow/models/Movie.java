package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Movie extends BaseModel{

    private String name;
    @Enumerated(value = EnumType.ORDINAL)
    private Genre genre;
    @Enumerated(value = EnumType.ORDINAL) //use when we use enum
    @ElementCollection   //use when we have list of enum's
    private List<Feature> featureList;
    private int duration;
}
