package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String getRegistratoin() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user, Model model) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "Пользователь с таким именем уже существует");
            return "registration";
        }
        else if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("errorMessage", "Пользователь с такой почтой уже зарегистрирован");
            return "registration";
        }
        else if(userService.addUser(user) == null) {
            model.addAttribute("errorMessage", "Непредвиденная ошибка, попробуйте позже");
            return "registration";
        }
        else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userService.addUser(user);

            return "main";
        }
    }
}
