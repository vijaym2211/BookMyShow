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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
