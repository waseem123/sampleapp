package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle","Login");
        return "login";
    }
}

