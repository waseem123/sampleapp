package com.learn.sampleapp.controller;

import com.learn.sampleapp.dto.CitizenCenterDTO;
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

    @RequestMapping(value = "/citizens", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, HttpServletRequest request) {
        modelMap.addAttribute("pageTitle", "Citizens");
        List<CitizenCenterDTO> citizens = citizenService.getCitizens();
        if (citizens.size() > 0) {
            modelMap.addAttribute("message", "Total " + citizens.size() + " citizens found.");
            modelMap.addAttribute("citizens", citizens);
        } else {
            modelMap.addAttribute("message", "Total " + citizens.size() + " citizens found.");
        }
        return "citizens";
    }

    //    @RequestMapping("/citizen/{id}")
//    public Citizen getCitizen(@PathVariable Long id) {
//        return citizenService.getCitizen(id);
//    }
    /*@RequestMapping(value = "/citizen/{id}", method = RequestMethod.GET)
    public String getCitizen(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("pageTitle", "Citizen");
        modelMap.addAttribute("citizen", citizenService.getCitizen(id));
        return "citizen";
    }*/

    @RequestMapping(value = "/citizens/{id}", method = RequestMethod.GET)
    public String getCitizen(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("pageTitle", "Citizen");
        modelMap.addAttribute("citizen", citizenService.getCenterwiseCitizen(id));
        return "citizen";
    }

    @RequestMapping(value = "/citizens/center/{center_id}", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, @PathVariable int center_id) {
        modelMap.addAttribute("pageTitle", "Citizens");
        modelMap.addAttribute("citizens", citizenService.findAllCitizens(center_id));
        return "centerwise_citizens";
    }

    @RequestMapping("/citizens/add-new")
    public String addNewCitizen(ModelMap modelMap) {
        String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        return "add-citizen";
    }

    @RequestMapping(value = "/citizens/add", method = RequestMethod.POST)
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
        Citizen c = citizenService.saveCitizen(citizen);
        modelMap.addAttribute("citizen", c);
        return "redirect:/citizens";
    }

    @RequestMapping("/citizens/edit-citizen/{id}")
    public String editCitizen(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("citizen", citizenService.getCitizen(id));
        List<VaccinationCenter> vaccinationCenters = centerService.getAllCenters();
        modelMap.addAttribute("vaccinationCenters", vaccinationCenters);
        String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
        modelMap.addAttribute("cities", cities);
        return "edit-citizen";
    }

    @RequestMapping(value = "/citizens/edit", method = RequestMethod.POST)
    public String updateCitizen(ModelMap modelMap,
                                HttpServletRequest request,
                                @RequestParam(value = "citizen_id", required = true) Long id,
                                @RequestParam(value = "citizen_name", required = true) String name,
                                @RequestParam(value = "citizen_city", required = true) String city,
                                @RequestParam(value = "citizen_doses", required = true) int no_of_doses,
                                @RequestParam(value = "citizen_center", required = true) int center
    ) {
        VaccinationCenter vc = centerService.getCenters(center);
        Citizen citizen = new Citizen();
        citizen.setCitizenId(id);
        citizen.setCitizenName(name);
        citizen.setCitizenCity(city);
        citizen.setCitizenDoses(no_of_doses);
        citizen.setVaccinationCenter(vc);
        Citizen c = citizenService.saveCitizen(citizen);
        modelMap.addAttribute("citizen", c);
        return "redirect:/citizens";
    }

    @RequestMapping(value = "/citizens/delete/{id}", method = RequestMethod.GET)
    public String deleteCitizen(ModelMap modelMap, @PathVariable Long id) {
        modelMap.addAttribute("pageTitle", "Citizen");
        citizenService.deleteCitizen(id);
        modelMap.addAttribute("message", "Citizen Deleted Successfully.");
        return "redirect:/citizens";
    }
}
