package org.example.bookmyshow;

import org.example.bookmyshow.models.Seat;
import org.example.bookmyshow.models.SeatType;
import org.example.bookmyshow.services.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {


    @Autowired
    private SeatService seatService;

    @Test
    void contextLoads() {
    }

    @Test
    public void addDummySeats(){
        Seat s1 = getSeat(0,0,SeatType.PLATINUM, "s1");
        Seat s2 = getSeat(0,1,SeatType.PLATINUM, "s2");
        Seat s3 = getSeat(0,2,SeatType.PLATINUM,"s3");
        Seat s4 = getSeat(0,3,SeatType.GOLD,"s4");
        Seat s5 = getSeat(0,4,SeatType.GOLD,"s5");
        Seat s6 = getSeat(0,5,SeatType.SILVER,"s6");

        seatService.addSeat(s1);
        seatService.addSeat(s2);
        seatService.addSeat(s3);
        seatService.addSeat(s4);
        seatService.addSeat(s5);
        seatService.addSeat(s6);
    }


    private Seat getSeat(int row, int col, SeatType seatType, String name){
        Seat s = new Seat();
        s.setRowNum(row);
        s.setColNum(col);
        s.setSeatType(seatType);
        s.setName(name);
        return s;
    }


}
