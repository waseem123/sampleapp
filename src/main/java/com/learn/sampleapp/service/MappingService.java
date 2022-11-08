package com.learn.sampleapp.service;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.repository.MappingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MappingService {
    @Autowired
    MappingRepository mappingRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        mappingRepository.findAll().forEach(users::add);
        return users;
    }
}
