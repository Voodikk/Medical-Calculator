package com.trofimovlipatnikov.medicalcalculator.controllers.CalculatorsControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculators")
public class CalculatorsController {

    //  Контроллер страницы со списком калькуляторов

    @GetMapping()
    public String getCalculators() {
        return "calculators";
    }
}
