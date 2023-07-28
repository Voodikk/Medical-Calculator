package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Role;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RegionsService regionsService;

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    public ModelAndView authUser(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (userRepository.findByUsername(username).isPresent()) {
                if (passwordEncoder.matches(password, user.get().getPassword())) {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(username, password)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    modelAndView.setViewName("main");
                }
                else {
                    throw new Exception("Неправильный пароль");
                }
            }
            else {
                throw new Exception("Пользователя с таким именем не существует");
            }

        }
        catch (Exception exception) {
            modelAndView.setViewName("login");
            modelAndView.addObject("error", true);
            modelAndView.addObject("errorMessage", exception.getMessage());
        }

        return modelAndView;
    }

    @Transactional
    public ModelAndView addUser(String username, String password, String email, int regionNumber) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
            Region region = regionsService.findByRegionNumber(regionNumber);

            if (userService.findByUsername(username).isPresent()) {
                throw new Exception("Пользователь с таким именем уже есть");
            }
            else if(userRepository.findByEmail(email).isPresent()) {
                throw new Exception("Пользователь с такой почтой уже есть");
            }
            else {
                if (userRole.isPresent()) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(passwordEncoder.encode(password));
                    user.setEmail(email);
                    user.setRegion(region);
                    user.setRoles(List.of(userRole.get()));
                    userService.save(user);

                    modelAndView.setViewName("login");
                }
                else {
                    throw new Exception("Непредвиденная ошибка");
                }
            }

        }
        catch (Exception exception) {
            modelAndView.setViewName("redirect:/registration");
            modelAndView.addObject("error", true);
            modelAndView.addObject("errorMessage", exception.getMessage());
        }
        return modelAndView;
    }
}
