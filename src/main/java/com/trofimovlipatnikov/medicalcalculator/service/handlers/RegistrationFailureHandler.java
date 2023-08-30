package com.trofimovlipatnikov.medicalcalculator.service.handlers;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationFailureHandler {

    //  Проверка на синтаксические ошибки
    private final SyntaxHandler syntaxHandler;
    //  Сервис пользователей
    private final UserService userService;
    //  Репозиторий таблицы пользователей
    private final UserRepository userRepository;

    public String checkRegistrationFailure(String username, String password, String email, int regionNumber) {

        //  Проверка синтаксиса имени пользователя, если метод checkSyntaxUsername найдет ошибку в синтаксисе,
        //  регистрация прервётся
        if (syntaxHandler.checkSyntaxUsername(username) != null) {
            return syntaxHandler.checkSyntaxUsername(username);
        }
        //  Проверка синтаксиса почты пользователя, если метод checkSyntaxEmail найдет ошибку в синтаксисе,
        //  регистрация прервётся
        if (syntaxHandler.checkSyntaxEmail(email) != null) {
            return syntaxHandler.checkSyntaxEmail(email);
        }
        //  Проверяем пароль
        if (syntaxHandler.checkSyntaxPassword(password) != null) {
            return syntaxHandler.checkSyntaxPassword(password);
        }

        if (userService.findByUsername(username).isPresent()) {
            return "Пользователь с таким именем уже есть";
        }
        else if(userRepository.findByEmail(email).isPresent()) {
            return "Пользователь с такой почтой уже есть";
        }

        return null;

    }
}
