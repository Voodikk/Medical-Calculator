package com.trofimovlipatnikov.medicalcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain() {
        return "main";
    }


    @GetMapping("/apache")
    public String getApache() {
        return "apache";
    }
}
