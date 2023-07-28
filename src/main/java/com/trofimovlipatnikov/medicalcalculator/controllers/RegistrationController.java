package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    AuthService authService;

    @GetMapping("/registration")
    public String getRegistration(@RequestParam(value = "error", required = false) boolean error,
                                  @RequestParam(value = "errorMessage", required = false) String errorMessage,
                                  Model model) {
        model.addAttribute("error", error);
        model.addAttribute("errorMessage", errorMessage);
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          @RequestParam("region") int regionNumber) {

        return authService.addUser(username, password, email, regionNumber);
    }
}
