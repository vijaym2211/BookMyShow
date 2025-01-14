package org.example.bookmyshow.services;

import org.example.bookmyshow.exception.PasswordIsWrong;
import org.example.bookmyshow.exception.UserNotSignUpException;
import org.example.bookmyshow.models.User;

public interface UserService{

    public User signupUser(String username, String email, String password) throws Exception;
    public User LoginUser(String email, String password) throws UserNotSignUpException, PasswordIsWrong;
}
