package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.models.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionsRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.service.UsersVotesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class StatisticController {

    @Autowired
    UsersVotesService usersVotesService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegionsRepository regionsRepository;



    @GetMapping("/statistic")
    public String getStatistic() {
        return "statistic";
    }

    @PostMapping("/submit_vote")
    public String vote(HttpServletRequest request, Vote usersVotes) {

        int points = Integer.parseInt(request.getParameter("points"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUsername(username);

        usersVotes.setUser(user.get());
        usersVotes.setRegion(user.get().getRegion());
        usersVotesService.addVote(usersVotes, points);


        return "statistic";


    }
}
