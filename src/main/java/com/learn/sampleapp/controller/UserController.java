package com.learn.sampleapp.controller;

import com.learn.sampleapp.model.User;
import com.learn.sampleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Login");
        return "login";
    }

    @RequestMapping("/login")
    public String login(ModelMap modelMap,
                        HttpServletRequest request,
                        @RequestParam(value = "user_email", required = true) String user_email,
                        @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Login");
        User user = userService.authenticateUser(user_email, user_password);
        if (user == null) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid Credentials! Please try again.");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user_id", user.getUser_id());
        session.setAttribute("user_name", user.getUser_name());
        return "redirect:/vaccinationcenter";
    }

    @RequestMapping("/registration")
    public String registration(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Registration");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(ModelMap modelMap,
                           HttpServletRequest request,
                           @RequestParam(value = "user_name", required = true) String user_name,
                           @RequestParam(value = "user_email", required = true) String user_email,
                           @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Register");
        try {
            User user = new User();
            user.setUser_name(user_name);
            user.setUser_email(user_email);
            user.setUser_password(user_password);
            userService.registerUser(user);
            modelMap.addAttribute("success", true);
            modelMap.addAttribute("message", "Registration Successful! Please login to continue.");
            return "redirect:/";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Registration Failure!" + ex.getMessage());
            return "registration";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}

