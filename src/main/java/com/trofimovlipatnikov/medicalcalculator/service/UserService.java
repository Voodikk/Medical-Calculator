package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(user);
        return userDetailsPrincipal;
    }

    public User addUser(User user) {

        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Пользователь с таким именем уже есть");
        }

        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Пользователь с такой почтой уже зарегистрирован");
        }

        user.setRole("ROLE_USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }
}
