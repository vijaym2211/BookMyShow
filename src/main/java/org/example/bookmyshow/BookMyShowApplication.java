package org.example.bookmyshow;

import org.example.bookmyshow.controllers.UserController;
import org.example.bookmyshow.dtos.LoginRequestDto;
import org.example.bookmyshow.dtos.LoginResponseDto;
import org.example.bookmyshow.dtos.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //use for create date and update date
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        SignupRequestDto requestDto = new SignupRequestDto();
//
//        requestDto.setName("John Doe");
//        requestDto.setEmail("abcd@gmail.com");
//        requestDto.setPassword("123456");
//
//        userController.Signup(requestDto);

        LoginRequestDto loginRequestDto = new LoginRequestDto();

        loginRequestDto.setEmail("abcd12@gmail.com");
        loginRequestDto.setPassword("123456");

        LoginResponseDto loginResponseDto= userController.Login(loginRequestDto);
        System.out.println(loginResponseDto.getUserId());
        System.out.println(loginResponseDto.getStatus());
    }
}
