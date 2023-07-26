package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.RegionVote;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionVoteRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionsRepository;
import com.trofimovlipatnikov.medicalcalculator.service.VotesService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    VotesService votesService;

    @Autowired
    RegionVoteRepository regionVoteRepository;

    @Autowired
    RegionsRepository regionsRepository;

    @GetMapping("/statistic")
    public String getStatistic(Model model) {
        List<RegionVote> votesList = regionVoteRepository.findAll();
        model.addAttribute("votesList", votesList);
        return "statistic";
    }

    @PostMapping("/submit_vote")
    public String vote(HttpServletRequest request, Vote usersVotes) {

        int points = Integer.parseInt(request.getParameter("points"));
        votesService.addVote(usersVotes, points);
        regionsRepository.calculateAvgPoints();
        return "statistic";
    }
}
