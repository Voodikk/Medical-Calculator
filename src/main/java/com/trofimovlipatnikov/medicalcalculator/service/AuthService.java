package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.service.handlers.ActionAfterMethodHandler;
import com.trofimovlipatnikov.medicalcalculator.service.handlers.RegistrationFailureHandler;
import com.trofimovlipatnikov.medicalcalculator.service.handlers.SyntaxHandler;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Role;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    //  Сервис аутентификации

    //  Подключаем
    //  Репозиторий таблицы ролей
    private final RoleRepository roleRepository;
    //  Сервис регионов
    private final RegionsService regionsService;
    //  Сервис пользователей
    private final UserService userService;
    //  Bcrypt для шифрования паролей
    private final BCryptPasswordEncoder passwordEncoder;
    //  Репозиторий таблицы пользователей
    private final UserRepository userRepository;
    //  Обработчик ошибок
    private final RegistrationFailureHandler registrationFailureHandler;
    //  Обработчик действий после выполнения метода
    private final ActionAfterMethodHandler actionAfterMethodHandler;



    //  Метод регистрации пользователя
    public String addUser(String username, String password, String email, int regionNumber, Model model) {

        try {
            String errorMessage = registrationFailureHandler.checkRegistrationFailure(username, password, email, regionNumber);

            //  Проверяем на ошибки
            if (errorMessage != null) {
                return actionAfterMethodHandler.actionAfterFail(model, errorMessage, "registration");
            }

            //  Суём в переменную роль, которую будем выдавать (пока так топорно)
            Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
            // Получаем объект класса Region исходя из номера региона, который выбрал пользователь при регистрации
            Region region = regionsService.findByRegionNumber(regionNumber);

            if (userRole.isPresent()) {
                //  Создаем новый объект класса User
                User user = new User();
                //  Даём ему имя
                user.setUsername(username);
                //  Зашифрованный пароль
                user.setPassword(passwordEncoder.encode(password));
                //  Email
                user.setEmail(email);
                //  Регион
                user.setRegion(region);
                //  Выдаем список ролей, на данный момент только роль пользователя
                user.setRoles(List.of(userRole.get()));
                //  Сохраняем в базу данных
                userService.save(user);

                //  Отправляем пользователя на страницу авторизации
                return actionAfterMethodHandler.actionAfterSuccess("redirect:/login");
            }
            else {
                //  Если вы видите эту ошибку, значит у вас либо пустая таблица с ролями, либо вы опечатались в названии роли
                return actionAfterMethodHandler.actionAfterFail(model, "Извините, у нас возникла ошибка, попробуйте позже. Скоро мы все исправим.", "registration");
            }
        }
        catch (Exception exception) {
            return actionAfterMethodHandler.actionAfterFail(model, "Упс, возникла какая-то ошибка, попробуйте позже", "redirect:/registration");
        }
    }

    public Optional<User> getUserFromSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userRepository.findByUsername(username);
    }
}
