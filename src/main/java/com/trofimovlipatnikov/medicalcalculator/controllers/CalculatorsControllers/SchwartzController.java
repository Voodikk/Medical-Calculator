package com.trofimovlipatnikov.medicalcalculator.controllers.CalculatorsControllers;

import com.trofimovlipatnikov.medicalcalculator.models.CalculatorModels.Schwartz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calculators/schwartz")
public class SchwartzController {

    //  Контроллер калькулятора Schwartz

    @GetMapping
    public String getSchwartz() {
        return "schwartz";
    }

    @GetMapping("/info")
    public ResponseEntity<?> getSchwartzInfo() {
        Schwartz schwartzInfo = new Schwartz();
        return new ResponseEntity<>(schwartzInfo.getInfo(), HttpStatus.OK);
    }

    @PostMapping("/result")
    public ResponseEntity<?> sendSchwartzResult(@RequestBody Schwartz schwartz){
        //  Метод вычисления результата
        schwartz.setResult();
        return new ResponseEntity<>(schwartz.getResult(), HttpStatus.OK);
    }
}
