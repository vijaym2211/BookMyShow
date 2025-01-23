package org.example.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Data;

//@Data
@Entity
public class Seat extends BaseModel{

    private String name;
//    @ManyToOne
//    @JoinColumn(name = "seat_type_id")
    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
    private int rowNum;
    private int colNum;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }
}