package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.Role;
import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistratoin() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("email") String email,
                          @RequestParam("region") int region) {
        Optional<Role> userRole = roleRepository.findByName("ROLE_USER");

        try {
            // Проверка, существует ли пользователь с таким же именем пользователя
            if (userService.findByUsername(username).isPresent()) {
                // Пользователь с таким именем уже существует, выполните соответствующие действия, например, перенаправление на страницу с ошибкой
                return "registration?error=true";
            }


            if (userRole.isPresent()) {
                // Создание нового пользователя
                User user = new User();
                user.setUsername(username);
                user.setPassword(passwordEncoder.encode(password));
                user.setEmail(email);
                user.setRegion(region);
                user.setRoles(List.of(userRole.get()));

                // Сохранение пользователя в базе данных
                userService.save(user);

                // Дополнительные действия после успешной регистрации, например, перенаправление на страницу входа
                return "login";
            } else {
                // Роль "ROLE_ADMIN" не найдена, выполните соответствующие действия, например, перенаправление на страницу с ошибкой
                return "main";
            }

        } catch (Exception e) {
            System.out.println(userRole);
            return "registration?error=true";
        }
    }
}
