package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.VaccinationCenter;
import com.learn.sampleapp.service.CenterService;
import com.learn.sampleapp.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class CenterController {
    @Autowired
    CenterService centerService;
    @Autowired
    private CitizenService citizenService;

    @RequestMapping(value = "/vaccinationcenter")
    public String getAllCenters(ModelMap modelMap) {
        modelMap.addAttribute("page_title", "Vaccination Centers");
        List<VaccinationCenter> centers = centerService.getAllCenters();
        if (centers.size() > 0) {
            modelMap.addAttribute("message", "Total " + centers.size() + " Vaccination Centers found.");
            modelMap.addAttribute("centers", centers);
        } else {
            modelMap.addAttribute("message", "Total " + centers.size() + " Vaccination Centers found.");
        }
        return "vaccination-centers";
    }

    @RequestMapping("/vaccinationcenter/{id}")
    public String getCenter(ModelMap modelMap, @PathVariable int id) {
        try {
            modelMap.addAttribute("center", centerService.getCenters(id));
            modelMap.addAttribute("citizens", citizenService.findAllCitizens(id));
            return "center";
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return "center";
        }
    }

    @RequestMapping("/vaccinationcenter/add-new")
    public String addNewCenter(ModelMap modelMap) {
        String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
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
        return "redirect:/vaccinationcenter";
    }

    @RequestMapping(value = "/vaccinationcenter/edit-center/{id}", method = RequestMethod.GET)
    public String editCenter(ModelMap modelMap, @PathVariable int id) {
        VaccinationCenter vaccinationCenter = centerService.getCenters(id);
        modelMap.addAttribute("center", vaccinationCenter);
        String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        return "edit-center";
    }

    @RequestMapping(value = "/vaccinationcenter/edit", method = RequestMethod.POST)
    public String edit(ModelMap modelMap,
                       HttpServletRequest request,
                       @RequestParam(value = "center_id", required = true) int id,
                       @RequestParam(value = "center_name", required = true) String name,
                       @RequestParam(value = "center_city", required = true) String city
    ) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter(id, name, city);
        modelMap.addAttribute("center", centerService.addCenter(vaccinationCenter));
        return "redirect:/vaccinationcenter";
    }

    @RequestMapping("/vaccinationcenter/delete/{id}")
    public String getCenters(ModelMap modelMap, @PathVariable int id) {
        try {
            modelMap.addAttribute("center", centerService.getCenters(id));
            centerService.deleteCenter(id);
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "ERROR");
            return "redirect:/vaccinationcenter";
        } catch (NoSuchElementException e) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", e.getMessage());
            return "redirect:/vaccinationcenter";
        }
    }
}