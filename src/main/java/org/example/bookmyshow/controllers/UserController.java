package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.exception.PasswordIsWrong;
import org.example.bookmyshow.exception.UserNotSignUpException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.example.bookmyshow.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.LoginExceptionResolver;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;
//    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
//        this.userServiceImpl =  userServiceImpl;
    }



    public SignupResponseDto Signup(SignupRequestDto requestDto) {
        SignupResponseDto responseDto = new SignupResponseDto();

//        userServiceImpl.LoginUser(null,null);

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
    public LoginResponseDto Login(LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        try{
            User user = this.userService.LoginUser(loginRequestDto.getEmail(), loginRequestDto.getPassword());
            loginResponseDto.setUserId(user.getId());
            loginResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            loginResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return loginResponseDto;
    }
}
