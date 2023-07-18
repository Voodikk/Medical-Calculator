package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Авторизация успешна
            // Выполните необходимые действия, например, установите атрибуты сессии или добавьте пользователя в контекст безопасности

            return "main";
        } else {

            System.out.println(username);
            System.out.println(password);
            // Неверные авторизационные данные
            // Вы можете добавить обработку ошибки, например, установить флаг ошибки в модель и отобразить его на странице входа

            return "login";
        }
    }
}
