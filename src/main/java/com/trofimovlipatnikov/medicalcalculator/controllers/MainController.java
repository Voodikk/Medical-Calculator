package com.trofimovlipatnikov.medicalcalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //  Контроллер страницы Main


    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

}
