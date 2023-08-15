package com.trofimovlipatnikov.medicalcalculator.controllers.CalculatorsControllers;

import com.trofimovlipatnikov.medicalcalculator.models.CalculatorModels.Apache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("calculators/apache")
public class ApacheController {

    //  Контроллер калькулятора Apache

    @GetMapping()
    public String getApache () {
        return "apache";
    }
    @GetMapping("/info")
    public ResponseEntity<?> getApacheInfo() {
        Apache apacheinfo = new Apache();
        return new ResponseEntity<>(apacheinfo.getInfo(), HttpStatus.OK);
    }
    @PostMapping("/result")
    public ResponseEntity<?> sendApacheResult (@RequestBody Apache apache) {
        //  Методы, высчитывающие и возвращающие результат
        apache.setResult();
        apache.setPercLetal();
        return new ResponseEntity<>(apache, HttpStatus.OK);
    }
}
