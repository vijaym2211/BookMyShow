package org.example.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
//    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @ManyToOne
//    @JoinColumn(name = "screen_id", nullable = false)
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
