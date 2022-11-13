package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.Citizen;
import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.service.CenterService;
import com.learn.sampleapp.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CitizenController {
    @Autowired
    CitizenService citizenService;
    @Autowired
    CenterService centerService;

//    @RequestMapping("/citizen")
//    public List<Citizen> getAllCitizens() {
//        return citizenService.getAllCitizens();
//    }

    @RequestMapping(value = "/citizen", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("pageTitle", "Citizens");
//        modelMap.addAttribute("citizens", citizenService.getAllCitizens());
        modelMap.addAttribute("citizens", citizenService.getCitizens());
//        return citizenService.getAllCitizens();
        return "citizens";
    }

    //    @RequestMapping("/citizen/{id}")
//    public Citizen getCitizen(@PathVariable Long id) {
//        return citizenService.getCitizen(id);
//    }
    @RequestMapping(value = "/citizen/{id}", method = RequestMethod.GET)
    public String getCitizen(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("pageTitle", "Citizen");
        modelMap.addAttribute("citizen", citizenService.getCitizen(id));
        return "citizen";
    }

    @RequestMapping(value = "/citizen/vaccinationcenter/{center_id}", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, @PathVariable int center_id) {
        modelMap.addAttribute("pageTitle", "Citizens");
        modelMap.addAttribute("citizens", citizenService.findAllCitizens(center_id));
        return "citizens";
//        return citizenService.findAllCitizens(center_id);
    }

    @RequestMapping("/citizen/add-new")
    public String addNewCitizen() {
        return "add-citizen";
    }

    @RequestMapping("/citizen/edit-citizen")
    public String editCitizen(ModelMap modelMap) {
        List<VaccinationCenter> vaccinationCenters = centerService.getAllCenters();
        modelMap.addAttribute("vaccinationCenters", vaccinationCenters);
        return "edit-citizen";
    }

    @RequestMapping(value = "/citizen/add", method = RequestMethod.POST)
    public String addCitizen(ModelMap modelMap,
                             HttpServletRequest request,
                             @RequestParam(value = "citizen_name", required = true) String name,
                             @RequestParam(value = "citizen_city", required = true) String city,
                             @RequestParam(value = "citizen_center", required = true) int center
    ) {
        System.out.println(center + "-------------------");
        VaccinationCenter vc = centerService.getCenters(center);

        Citizen citizen = new Citizen();
        citizen.setCitizenName(name);
        citizen.setCitizenCity(city);
        citizen.setCitizenDoses(0);
        citizen.setVaccinationCenter(vc);
//        citizen.setCenterId(center);
        Citizen c = citizenService.saveCitizen(citizen);
        modelMap.addAttribute("citizen", c);
        return "citizen";
    }
}
