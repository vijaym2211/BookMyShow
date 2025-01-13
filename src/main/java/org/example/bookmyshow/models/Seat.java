package org.example.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{

    private String name;
//    @ManyToOne
//    @JoinColumn(name = "seat_type_id")
    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
    private int rowNum;
    private int colNum;
}