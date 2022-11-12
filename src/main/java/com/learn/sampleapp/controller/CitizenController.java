package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CitizenController {
    @Autowired
    CitizenService citizenService;

//    @RequestMapping("/citizen")
//    public List<Citizen> getAllCitizens() {
//        return citizenService.getAllCitizens();
//    }

    @RequestMapping(value = "/citizen", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("pageTitle", "Citizens");
        modelMap.addAttribute("citizens", citizenService.getAllCitizens());
//        return citizenService.getAllCitizens();
        return "home";
    }

    //    @RequestMapping("/citizen/{id}")
//    public Citizen getCitizen(@PathVariable Long id) {
//        return citizenService.getCitizen(id);
//    }
    @RequestMapping(value = "/citizen/{id}", method = RequestMethod.GET)
    public String getCitizen(ModelMap modelMap, @PathVariable Long id) {
//        return citizenService.getCitizen(id);
        modelMap.addAttribute("pageTitle", "Citizen");
        modelMap.addAttribute("citizen", citizenService.getCitizen(id));
        return "citizen";
    }

    @RequestMapping("/citizen/vaccinationcenter/{center_id}")
    public List<Citizen> getAllCitizens(@PathVariable int center_id) {
        return citizenService.findAllCitizens(center_id);
    }
}
