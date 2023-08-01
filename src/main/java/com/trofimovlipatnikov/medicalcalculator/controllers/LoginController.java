package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthService authService;

    @GetMapping
    public String getLogin(@RequestParam(value = "error", required = false) boolean error,
                           @RequestParam(value = "errorMessage", required = false) String errorMessage,
                           Model model) {

        model.addAttribute("error", error);
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @PostMapping("/auth_user")
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        return authService.authUser(username, password);
    }
}
