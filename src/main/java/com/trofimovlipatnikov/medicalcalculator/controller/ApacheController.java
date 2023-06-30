package com.trofimovlipatnikov.medicalcalculator.controller;

import com.trofimovlipatnikov.medicalcalculator.models.Apache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/apache")
public class ApacheController {
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
        apache.setResult();
        apache.setPercLetal();
        return new ResponseEntity<>(apache, HttpStatus.OK);
    }
}
