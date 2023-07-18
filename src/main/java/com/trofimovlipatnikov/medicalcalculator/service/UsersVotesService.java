package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.models.UsersVotes;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UsersVotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsersVotesService {

    @Autowired
    UsersVotesRepository usersVotesRepository;

    @Autowired
    UserRepository userRepository;


    public void addVote(UsersVotes usersVotes, int points) {
        usersVotes.setPoints(points);
        usersVotesRepository.save(usersVotes);
    }
}
