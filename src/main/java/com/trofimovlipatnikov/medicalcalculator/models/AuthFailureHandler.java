package com.trofimovlipatnikov.medicalcalculator.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    //  Обработка ошибок при авторизации

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = "Неправильный логин или пароль";
        if (exception instanceof LockedException) {
            errorMessage = "Ваш аккаунт заблокирован";
        } else if (exception instanceof DisabledException) {
            errorMessage = "Ваш аккаунт отключен";
        } else if (exception instanceof AccountExpiredException) {
            errorMessage = "Срок действия вашего аккаунта истек";
        } else if (exception instanceof CredentialsExpiredException) {
            errorMessage = "Срок действия вашего пароля истек";
        }
        String redirectUrl = request.getContextPath() + "/login?error=true&errorMessage=" + URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
        response.sendRedirect(redirectUrl);
    }

}
