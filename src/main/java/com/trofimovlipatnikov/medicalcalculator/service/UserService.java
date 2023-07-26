package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    AuthenticationManager authenticationManager;


    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {

        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь с именем %s не найден", username)
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }


    public String authUser(String username,
                           String password) {
        try {
            Optional<User> user = findByUsername(username);
            if (user.isPresent()) {
                if (Objects.equals(user.get().getPassword(), password)) {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(username, password)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    UserDetails userDetails = loadUserByUsername(username);
                    return "main";
                }
                else {
                    throw new Exception("Неправильный пароль");
                }
            }
            else {
                throw new Exception("Пользователь не найден");
            }

        }
        catch (Exception exception) {
            return "redirect:/login?error=true";
        }

    }

}
