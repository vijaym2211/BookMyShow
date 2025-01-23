package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;

//    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL) // Establishing the relationship
//    private List<ShowSeat> showSeats;
//
//    public List<ShowSeat> getShowSeats() {
//        return showSeats;
//    }
//
//    public void setShowSeats(List<ShowSeat> showSeats) {
//        this.showSeats = showSeats;
//    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
