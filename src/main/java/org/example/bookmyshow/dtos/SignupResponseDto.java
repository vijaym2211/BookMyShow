package org.example.bookmyshow.dtos;


import lombok.Data;


public class SignupResponseDto {
    private ResponseStatus getResponseStatus;
    private int userId;

    public ResponseStatus getGetResponseStatus() {
        return getResponseStatus;
    }

    public void setGetResponseStatus(ResponseStatus getResponseStatus) {
        this.getResponseStatus = getResponseStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
