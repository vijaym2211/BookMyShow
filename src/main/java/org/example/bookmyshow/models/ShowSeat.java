package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private User bookedBy;
    @Enumerated(value = EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
