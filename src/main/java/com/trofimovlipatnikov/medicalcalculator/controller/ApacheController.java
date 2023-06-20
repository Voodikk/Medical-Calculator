package com.trofimovlipatnikov.medicalcalculator.controller;

import com.trofimovlipatnikov.medicalcalculator.models.Apache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apache")
public class ApacheController {
    @GetMapping()
    public String getApache (Model model) {
        model.addAttribute("apacheres", new Apache());
        return "apache";
    }
    @GetMapping("/info")
    public ResponseEntity<?> getApacheInfo() {
        TestClass testClass = new TestClass("Pridurok", "frik");
        return new ResponseEntity<>(testClass, HttpStatus.OK);
    }
    @PostMapping("/result")
    public ResponseEntity<?> sendApacheResult (@RequestBody Apache apache) {
        System.out.println(apache);
        return new ResponseEntity<>(apache, HttpStatus.OK);
    }
    public class TestClass {
        private String username;
        private String password;

        TestClass() {}

        public TestClass(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
