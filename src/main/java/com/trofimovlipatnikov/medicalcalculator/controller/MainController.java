package com.trofimovlipatnikov.medicalcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain() {
        return "apache";
    }

    @GetMapping("/apache")
    public String getApacheCalc() {
        return "apache";
    }
}
