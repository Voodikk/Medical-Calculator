package com.trofimovlipatnikov.medicalcalculator.models;


import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 20, message = "Имя пользователя должно содержать от 4 до 20 символов")
    private String username;

    @NotBlank
    @Email
    @Size(min = 4, max = 50, message = "Введите корректный адрес")
    private String email;

    @NotBlank
    @Size(min = 5, max = 50, message = "Пароль должен содержать минимум 5 символов")
    private String password;
}
