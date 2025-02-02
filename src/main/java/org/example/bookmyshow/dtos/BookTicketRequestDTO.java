package org.example.bookmyshow.dtos;

import lombok.Data;
import org.example.bookmyshow.models.ShowSeat;
import org.example.bookmyshow.models.Ticket;

import java.util.List;

@Data
public class BookTicketRequestDTO {

    private List<Integer> showSeatsId;
    private int userId;

    public List<Integer> getShowSeatsId() {
        return showSeatsId;
    }

    public void setShowSeatsId(List<Integer> showSeatsId) {
        this.showSeatsId = showSeatsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
