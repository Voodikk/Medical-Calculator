package com.trofimovlipatnikov.medicalcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apache")
public class ApacheController {
    @GetMapping()
    public String getApache () {
        return "apache";
    }
    @GetMapping("/info")
    public String getApacheInfo() {
        return "apache";
    }
    @PostMapping("/result")
    public String sendApacheResult () {
        return null;
    }
}
