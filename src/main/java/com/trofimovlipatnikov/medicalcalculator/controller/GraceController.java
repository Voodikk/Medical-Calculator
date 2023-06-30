package com.trofimovlipatnikov.medicalcalculator.controller;


import com.trofimovlipatnikov.medicalcalculator.models.Grace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grace")
public class GraceController {
    @GetMapping()
    public String getGrace() {
        return "grace";
    }
    @GetMapping("/info")
    public ResponseEntity<?> getApacheInfo() {
        Grace graceinfo = new Grace();
        return new ResponseEntity<>(graceinfo, HttpStatus.OK);
    }
    @PostMapping("/result")
    public ResponseEntity<?> sendApacheResult (@RequestBody Grace grace) {
        return new ResponseEntity<>(grace, HttpStatus.OK);
    }
}
