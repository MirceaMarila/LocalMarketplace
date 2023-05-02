package com.example.LocalMarketplace.service;

import com.example.LocalMarketplace.exceptions.BadRequest;
import com.example.LocalMarketplace.exceptions.NotFoundException;
import com.example.LocalMarketplace.model.User;
import com.example.LocalMarketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveNewUser(User user){

        User existingUser = userRepository.findUserByEmail(user.getEmail());
        if (existingUser != null)
            throw new BadRequest("A user with this email already exists!");

        return userRepository.save(user);
    }

    public User loginUser(String email, String password){

        User existingUserEmail = userRepository.findUserByEmail(email);
        User existingUserPassword = userRepository.findUserByPassword(password);

        if(existingUserEmail == null)
            throw new NotFoundException("User with email " + email + " does not exist!");

        if(existingUserPassword == null)
            throw new NotFoundException("User with password " + password + " does not exist!");

        if(!existingUserEmail.getPassword().equals(password) | !existingUserPassword.getEmail().equals(email))
            throw new NotFoundException("There is no account with email " + email + " and password " + password);

        else
            return existingUserEmail;
    }

}
