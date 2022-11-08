package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CenterController {
    @Autowired
    CenterService centerService;

    @RequestMapping("/vaccinationcenter")
    public List<VaccinationCenter> getAllCenters() {
        return centerService.getAllCenters();
    }

    //
    @RequestMapping("/vaccinationcenter/{id}")
    public VaccinationCenter getCenters(@PathVariable int id) {
        try {
            return centerService.getCenters(id);
        } catch (NoSuchElementException e) {
            return new VaccinationCenter();
        }
    }
}
