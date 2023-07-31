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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView addVote(Vote usersVotes, int points) {
        ModelAndView modelAndView = new ModelAndView();
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication != null) {
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

                modelAndView.setViewName("statistic");
                modelAndView.addObject("error", true);
                modelAndView.addObject("errorMessage", "Ваш ответ записан.");
            }
            else {
                modelAndView.setViewName("login");
                modelAndView.addObject("error", true);
                modelAndView.addObject("errorMessage", "Сначала войдите в аккаунт");
            }

        }
        catch (Exception exception) {
            modelAndView.setViewName("statistic");
            modelAndView.addObject("error", true);
            modelAndView.addObject("errorMessage", exception.getMessage());
        }
        return modelAndView;


    }


}
