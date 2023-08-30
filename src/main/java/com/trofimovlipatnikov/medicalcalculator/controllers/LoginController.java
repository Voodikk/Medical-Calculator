package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    //  Контроллер страницы авторизации

    @GetMapping
    public String getLogin(Model model,
                           @RequestParam(value = "error", required = false) boolean error,
                           @RequestParam(value = "errorMessage", required = false, defaultValue = "") String errorMessage) {

        model.addAttribute("error", error);
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }
}
