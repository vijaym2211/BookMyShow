package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.SignupRequestDto;
import org.example.bookmyshow.dtos.SignupResponseDto;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto Signup(SignupRequestDto requestDto){
        SignupResponseDto responseDto = new SignupResponseDto();

        try{
            User user = this.userService.signupUser(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
            responseDto.setUserId(user.getId());
            responseDto.setGetResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setGetResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
