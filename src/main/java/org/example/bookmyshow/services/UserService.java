package org.example.bookmyshow.services;

import org.example.bookmyshow.models.User;

public interface UserService{

    public User signupUser(String username, String email, String password) throws Exception;
}
