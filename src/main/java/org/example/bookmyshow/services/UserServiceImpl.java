package org.example.bookmyshow.services;

import org.example.bookmyshow.exception.UserAlreadyPresentException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User signupUser(String username, String email, String password) throws UserAlreadyPresentException{

        if(userRepository.findByEmail(email) != null) {
            throw new UserAlreadyPresentException("User is already present in DB");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setName(username);

        return userRepository.save(user);
    }
}
