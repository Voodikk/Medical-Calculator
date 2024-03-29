package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    //  Контроллер регистрации

    //  Подключаем сервис аутентификации
    private final AuthService authService;

    @GetMapping
    public String getRegistration(Model model) {
        return "registration";
    }

    @PostMapping("/add_user")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          @RequestParam("region") int regionNumber,
                          Model model) {

        //  Возвращаем метод добавления пользователя в базу данных (регистрация)
        return authService.addUser(username, password, email, regionNumber, model);
    }
}
