package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.service.handlers.ActionAfterMethodHandler;
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

    private final ActionAfterMethodHandler actionAfterMethodHandler;

    // Получаем данные пользователя
    public String getProfile(Model model) {
        try {
            //  Получаем пользователя из сессии
            Optional<User> user = authService.getUserFromSession();

            //  Даём посмотреть на данные своего профиля только если авторизован
            if (user.isPresent()) {
                model.addAttribute("username", user.get().getUsername());
                model.addAttribute("email", user.get().getEmail());
                model.addAttribute("region", user.get().getRegion().getRegionNumber());

                return actionAfterMethodHandler.actionAfterSuccess("profile");
            }
            //  Если не авторизован, кидаем ошибку
            else
                return actionAfterMethodHandler.actionAfterFail(model, "Сначала войдите в аккаунт", "redirect:/login");
        }
        //  Обработка ошибок со стороны сервера
        catch (Exception exception) {
            return actionAfterMethodHandler.actionAfterFail(model, "Упс, возникла какая-то ошибка, попробуйте позже", "redirect:/main");
        }
    }

    public String changeProfileData(Model model, String username, String email) {
        try {
            //  Получаем пользователя из сессии
            Optional<User> user = authService.getUserFromSession();

            // Проверяем авторизирован ли пользователь
            if (user.isPresent()) {
                // Проверяем есть ли пользователь с таким именем
                Optional<User> userByUsername = userRepository.findByUsername(username);
                Optional<User> userByEmail = userRepository.findByEmail(email);

                if (userByUsername.isPresent() && userByUsername != user) {
                    return actionAfterMethodHandler.actionAfterFail(model, "Это имя пользователя занято", "redirect:/profile");
                }
                else {
                    user.get().setUsername(username);
                }
                if (userRepository.findByEmail(email).isPresent() && userByEmail != user) {
                    return actionAfterMethodHandler.actionAfterFail(model, "Пользователь с такой почтой уже есть", "redirect:/profile");
                }
                else {
                    user.get().setEmail(email);
                }

                return actionAfterMethodHandler.actionAfterSuccess(model, "redirect:/profile");
            }
            else {
                return actionAfterMethodHandler.actionAfterFail(model, "Сначала войдите в аккаунт", "redirect:/login");
            }
        }
        // Обработка ошибок
        catch (Exception exception) {
            return actionAfterMethodHandler.actionAfterFail(model, "Упс, возникла какая-то ошибка, попробуйте позже", "redirect:/main");
        }
    }
}
