package com.writeabyte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.writeabyte.entities.User;
import com.writeabyte.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
    
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}