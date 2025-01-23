package org.example.bookmyshow.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class City extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theater> theatres;


//    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Theater> theaters = new ArrayList<>();
//
//    public void addTheater(Theater theater) {
//        theaters.add(theater);
//        theater.setCity(this); // Set the reverse association
//    }
//


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theater> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theater> theatres) {
        this.theatres = theatres;
    }
}
