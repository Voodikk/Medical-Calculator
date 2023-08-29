package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileDataService {

    private final UserRepository userRepository;

    private final AuthService authService;

    // Получаем данные пользователя
    public String getProfile(Model model) {
        try {
            //  Получаем пользователя из сессии
            Optional<User> user = authService.getUserFromSessionByUsername();

            //  Даём посмотреть на данные своего профиля только если авторизован
            if (user.isPresent()) {
                model.addAttribute("username", user.get().getUsername());
                model.addAttribute("email", user.get().getEmail());
                model.addAttribute("region", user.get().getRegion().getRegionNumber());

                return "profile";
            }
            //  Если не авторизован, кидаем ошибку
            else
                throw new Exception("Сначала войдите в аккаунт");
        }
        //  Шлём на страницу авторизации
        catch (Exception exception) {
            //
            return "redirect:/login";
        }
    }

    public String changeProfileData(String username, String email) {
        try {
            //  Получаем пользователя из сессии
            Optional<User> user = authService.getUserFromSessionByUsername();

            // Проверяем авторизирован ли пользователь
            if (user.isPresent()) {
                // Проверяем есть ли пользователь с таким именем
                Optional<User> userByUsername = userRepository.findByUsername(username);
                Optional<User> userByEmail = userRepository.findByEmail(email);

                if (userByUsername.isPresent() && userByUsername != user) {
                    throw new Exception("Пользователь с таким именем уже есть");
                }
                else {
                    user.get().setUsername(username);
                }
                if (userRepository.findByEmail(email).isPresent() && userByEmail != user) {
                    throw new Exception("Пользователь с такой почтой уже есть");
                }
                else {
                    user.get().setEmail(email);
                }

                return "redirect:/profile?isChange=true";
            }
            else {
                throw  new Exception();
            }
        }
        // Обработка ошибок
        catch (Exception exception) {
            return "redirect:/profile?error=true";
        }
    }
}
