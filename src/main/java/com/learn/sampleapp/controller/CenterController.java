package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
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

    @RequestMapping("/vaccinationcenter/delete/{id}")
    public void deleteCenter(@PathVariable int id) {
        try {
            centerService.deleteCenter(id);
        } catch (NoSuchElementException e) {
            new VaccinationCenter();
        }
    }

    @RequestMapping("/vaccinationcenter/add-new")
    public String addNewCenter() {
        return "add-center";
    }

    @RequestMapping(value = "/vaccinationcenter/add", method = RequestMethod.POST)
    public String addCenter(ModelMap modelMap,
                            HttpServletRequest request,
                            @RequestParam(value = "center_name", required = true) String name,
                            @RequestParam(value = "center_city", required = true) String city
    ) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter(name, city);
        centerService.addCenter(vaccinationCenter);
        return "home";
    }
}
