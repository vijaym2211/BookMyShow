package org.example.bookmyshow.exception;

public class UserAlreadyPresentException extends Exception{

    public UserAlreadyPresentException(String message){
        super(message);
    }
}
