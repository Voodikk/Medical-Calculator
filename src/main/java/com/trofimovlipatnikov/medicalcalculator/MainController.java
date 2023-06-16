package com.trofimovlipatnikov.medicalcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain(Model model) {
        model.addAttribute("message", "privet");
        return "main";
    }
}
