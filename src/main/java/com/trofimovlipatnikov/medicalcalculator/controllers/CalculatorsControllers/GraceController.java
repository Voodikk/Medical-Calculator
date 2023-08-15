package com.trofimovlipatnikov.medicalcalculator.controllers.CalculatorsControllers;


import com.trofimovlipatnikov.medicalcalculator.models.CalculatorModels.Grace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calculators/grace")
public class GraceController {

    //  Контроллер калькулятора Grace

    @GetMapping()
    public String getGrace() {
        return "grace";
    }
    @GetMapping("/info")
    public ResponseEntity<?> getGraceInfo() {
        Grace graceinfo = new Grace();
        return new ResponseEntity<>(graceinfo.getInfo(), HttpStatus.OK);
    }
    @PostMapping("/result")
    public ResponseEntity<?> sendGraceResult (@RequestBody Grace grace) {
        //  Метод, вычисляющий результат
        grace.setResult();
        return new ResponseEntity<>(grace.getResult(), HttpStatus.OK);
    }
}
