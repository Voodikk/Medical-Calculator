package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final AuthService authService;

    @GetMapping("/me")
    public String getProfile(Model model) {
        return authService.getProfile(model);
    }
}
