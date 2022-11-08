package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MappingController {
    @Autowired
    private MappingService mappingService;

    @RequestMapping("vc")
    public List<User> getAllUsers(){
        return mappingService.getAllUsers();
    }
}
