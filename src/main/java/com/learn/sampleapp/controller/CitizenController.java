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
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class CitizenController {
    @Autowired
    CitizenService citizenService;
    @Autowired
    CenterService centerService;

    @RequestMapping(value = "/citizens", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, HttpServletRequest request) {
        try {
            modelMap.addAttribute("pageTitle", "Citizens");
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            List<CitizenCenterDTO> citizens = citizenService.getCitizens();
            if (citizens.size() > 0) {
                modelMap.addAttribute("message", "Total " + citizens.size() + " citizens found.");
                modelMap.addAttribute("citizens", citizens);
            } else {
                modelMap.addAttribute("message", "Total " + citizens.size() + " citizens found.");
            }
            return "citizens";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping(value = "/citizens/{id}", method = RequestMethod.GET)
    public String getCitizen(ModelMap modelMap, HttpServletRequest request, @PathVariable Long id) {
        try {
            modelMap.addAttribute("pageTitle", "Citizen");
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            modelMap.addAttribute("citizen", citizenService.getCenterwiseCitizen(id));
            return "citizen";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping(value = "/citizens/center/{center_id}", method = RequestMethod.GET)
    public String getAllCitizens(ModelMap modelMap, HttpServletRequest request, @PathVariable int center_id) {
        try {
            modelMap.addAttribute("pageTitle", "Citizens");
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            modelMap.addAttribute("citizens", citizenService.findAllCitizens(center_id));
            return "centerwise_citizens";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping("/citizens/add-new")
    public String addNewCitizen(ModelMap modelMap, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            List<VaccinationCenter> vaccinationCenters = centerService.getAllCenters();
            modelMap.addAttribute("vaccinationCenters", vaccinationCenters);
            String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
            modelMap.addAttribute("cities", cities);
            return "add-citizen";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping(value = "/citizens/add", method = RequestMethod.POST)
    public String addCitizen(ModelMap modelMap,
                             HttpServletRequest request,
                             @RequestParam(value = "citizen_name", required = true) String name,
                             @RequestParam(value = "citizen_city", required = true) String city,
                             @RequestParam(value = "citizen_center", required = true) int center
    ) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            if (name.equals("") || city.equals("")) {
                modelMap.addAttribute("message", "Name and City are compulsory.");
                modelMap.addAttribute("error", true);
                return "redirect:/citizens/add-new";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            VaccinationCenter vc = centerService.getCenters(center);
            Citizen citizen = new Citizen();
            citizen.setCitizenName(name);
            citizen.setCitizenCity(city);
            citizen.setCitizenDoses(0);
            citizen.setVaccinationCenter(vc);
            Citizen c = citizenService.saveCitizen(citizen);
            modelMap.addAttribute("citizen", c);
            return "redirect:/citizens";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping("/citizens/edit-citizen/{id}")
    public String editCitizen(ModelMap modelMap, HttpServletRequest request, @PathVariable Long id) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            modelMap.addAttribute("citizen", citizenService.getCitizen(id));
            List<VaccinationCenter> vaccinationCenters = centerService.getAllCenters();
            modelMap.addAttribute("vaccinationCenters", vaccinationCenters);
            String[] cities = {"Mumbai", "Pune", "Bengaluru", "Hyderabad", "Chennai", "Surat"};
            modelMap.addAttribute("cities", cities);
            return "edit-citizen";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
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
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            if (name.equals("") || city.equals("")) {
                modelMap.addAttribute("message", "Name and City are compulsory.");
                modelMap.addAttribute("error", true);
                return "redirect:/citizens/edit-citizen/" + id;
            }
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
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }

    @RequestMapping(value = "/citizens/delete/{id}", method = RequestMethod.GET)
    public String deleteCitizen(ModelMap modelMap, HttpServletRequest request, @PathVariable Long id) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            modelMap.addAttribute("user_name", session.getAttribute("user_name"));
            modelMap.addAttribute("pageTitle", "Citizen");
            citizenService.deleteCitizen(id);
            modelMap.addAttribute("message", "Citizen Deleted Successfully.");
            return "redirect:/citizens";
        } catch (Exception ex) {
            modelMap.addAttribute("message", ex.getMessage() + "");
            modelMap.addAttribute("error", true);
            return "redirect:/citizens";
        }
    }
}
