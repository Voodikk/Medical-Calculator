package com.trofimovlipatnikov.medicalcalculator.service.handlers;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SyntaxHandler {

    //  Проверка синтаксиса в имени пользователя
    public String checkSyntaxUsername(String username) {

        if (username.length() > 15) {
            return "Имя пользователя не может содержать более 15 символов.";
        }
        else if (username.length() < 4) {
            return "Имя пользователя не может содержать менее 4 символов.";
        }
        //  Если такое имя пользователя будет в бд, метод addVote в классе VotesService сломается
        //  В Spring Security неавторизованный пользователь имеет это имя пользователя
        else if (username.equals("anonymousUser")) {
            return "Введите другое имя пользователя";
        }

        return null;
    }

    //  Проверка синтаксиса почты пользователя
    public String checkSyntaxEmail(String email) {

        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches() || email.length() < 6) {
            return "Введите корректную почту.";
        }

        return null;

    }

    //  Проверка синтаксиса пароля
    public String checkSyntaxPassword(String password) {

        if (password.length() <= 5) {
            return "Пароль должен содержать хотя бы 5 символов";
        }

        return null;
    }
}
