package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UsersVotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersVotesService {

    @Autowired
    UsersVotesRepository usersVotesRepository;

    @Autowired
    UserRepository userRepository;


    @Transactional
    public void addVote(Vote usersVotes, int points) {
        usersVotes.setPoints(points);
        usersVotesRepository.save(usersVotes);
    }
}
