package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //    @RequestMapping("/")
//    public List<User> getAllUser() {
//
//        return userService.getAllUsers();
//    }
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public void addUser(@RequestBody User userRecord) {
        userService.addUser(userRecord);
    }
}
