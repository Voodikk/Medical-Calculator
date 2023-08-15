package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Role;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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


    //  т. к. я больше не использую кастомную авторизацию, я закомментировал метод

//    public String authUser(String username, String password) {
//        try {
//            Optional<User> user = userRepository.findByUsername(username);
//            if (userRepository.findByUsername(username).isPresent()) {
//                if (passwordEncoder.matches(password, user.get().getPassword())) {
//                    Authentication authentication = authenticationManager.authenticate(
//                            new UsernamePasswordAuthenticationToken(username, password)
//                    );
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//                    return "redirect:/main";
//                }
//                else {
//                    throw new Exception("Неправильный пароль");
//                }
//            }
//            else {
//                throw new Exception("Пользователя с таким именем не существует");
//            }
//
//        }
//        catch (Exception exception) {
//            return "redirect:/login?error=true&errorMessage=" + URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8);
//        }
//    }

    //  Метод регистрации пользователя
    public String addUser(String username, String password, String email, int regionNumber) {

        //  Используем try, чтобы соблюдать обработку ошибок
        try {
            //  Суём в переменную роль, которую будем выдавать (пока так топорно)
            Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
            // Получаем объект класса Region исходя из номера региона, который выбрал пользователь при регистрации
            Region region = regionsService.findByRegionNumber(regionNumber);

            //  Проверяем на ошибки
            if (userService.findByUsername(username).isPresent()) {
                throw new Exception("Пользователь с таким именем уже есть");
            }
            else if(userRepository.findByEmail(email).isPresent()) {
                throw new Exception("Пользователь с такой почтой уже есть");
            }
            if(username == null || password == null || email == null || regionNumber == 0) {
                throw new Exception("Заполните все поля");
            }

            // Если ошибок нет, начинаем процесс сохранения пользователя в базу данных
            else {
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

                    //  Отправляем пользователяна страницу авторизации
                    return "redirect:/login";
                }
                else {
                    //  Если вы видите эту ошибку, значит у вас либо пустая таблица с ролями, либо вы опечатались в названии роли
                    throw new Exception("Непредвиденная ошибка");
                }
            }

        }
        catch (Exception exception) {
            //  В случае возникновения какой-либо ошибки, возвращаем пользователя на страницу регистрации с текстом ошибки
            return "redirect:/registration?error=true&errorMessage=" + URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8);
        }
    }
}
