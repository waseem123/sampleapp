package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<User> getAllUser() {

        return userService.getAllUsers();
    }
//    @RequestMapping("/")
//    public String home() {
//        return "home";
//    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public void addUser(@RequestBody String username, @RequestBody String city) {
//        User userRecord = new User(username, city);
//        userService.addUser(userRecord);
    }
}
