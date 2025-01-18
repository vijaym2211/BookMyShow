package org.example.bookmyshow.services;

import org.example.bookmyshow.exception.PasswordIsWrong;
import org.example.bookmyshow.exception.UserAlreadyPresentException;
import org.example.bookmyshow.exception.UserNotSignUpException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User signupUser(String username, String email, String password) throws UserAlreadyPresentException{

        if(userRepository.findByEmail(email) != null) {
            throw new UserAlreadyPresentException("User is already present in DB");
        }


        String encodedPassword = bCryptPasswordEncoder.encode(password);

        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setName(username);

        return userRepository.save(user);
    }

    public User LoginUser(String email, String password) throws UserNotSignUpException, PasswordIsWrong {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UserNotSignUpException("Please SignUp User Not available");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return user;
        }
//        if(encodedPassword.equals(user.getPassword())) {
//            return user;
//        }
        throw new PasswordIsWrong("Please enter correct password");
    }
}
