package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.*;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3307")  // Fixed CORS URL with full protocol

@RestController // Indicates this class is a RESTful controller
@RequestMapping("/api/users") // Base URL for all user-related endpoints
public class UserController {

    private UserService userService;
//    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
//        this.userServiceImpl =  userServiceImpl;
    }


    @PostMapping("/signup")
    public SignupResponseDto Signup(@RequestBody SignupRequestDto requestDto) {
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

    @PostMapping("/login")
    public LoginResponseDto Login(@RequestBody LoginRequestDto loginRequestDto){
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
