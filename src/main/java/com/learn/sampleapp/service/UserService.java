package com.learn.sampleapp.service;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(String user_email, String user_password) {
        User user = userRepository.findByEmail(user_email, user_password);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
