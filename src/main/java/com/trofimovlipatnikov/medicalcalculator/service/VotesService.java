package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UsersVotesRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VotesService {

    @Autowired
    UsersVotesRepository usersVotesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VoteRepository voteRepository;


    @Transactional
    public void addVote(Vote usersVotes, int points) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);

        Optional<Vote> existingVote = voteRepository.findByUser(user.get());
        if (existingVote.isPresent()) {
            // Запись уже существует, выполните обновление
            Vote voteToUpdate = existingVote.get();
            voteToUpdate.setPoints(points);
            voteRepository.save(voteToUpdate);
        } else {
            // Запись не существует, выполните добавление
            usersVotes.setUser(user.get());
            usersVotes.setRegion(user.get().getRegion());
            usersVotes.setPoints(points);
            usersVotesRepository.save(usersVotes);
        }
    }


}
