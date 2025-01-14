package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class LoginResponseDto {
    private ResponseStatus status;
    private int userId;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
