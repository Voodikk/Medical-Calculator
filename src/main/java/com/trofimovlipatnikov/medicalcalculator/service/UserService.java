package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Role;
import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.repositories.RoleRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(user);
        return userDetailsPrincipal;
    }

    public User addUser(User user) {

        Set<Role> roles = new HashSet<>();
        user.getRoles().forEach(role -> {
            Role nRole = roleRepository.findById(role.getId()).get();
            nRole.getUsers().add(user);
            roles.add(nRole);
        });

        user.setRoles(roles);

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }
}
