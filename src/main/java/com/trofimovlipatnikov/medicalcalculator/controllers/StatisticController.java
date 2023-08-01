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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @Autowired
    VotesService votesService;

    @Autowired
    RegionVoteRepository regionVoteRepository;


    @GetMapping
    public String getStatistic(@RequestParam(value = "error", required = false) boolean error,
                               @RequestParam(value = "errorMessage", required = false) String errorMessage,
                               Model model) {

        List<RegionVote> votesList = regionVoteRepository.findAll();
        model.addAttribute("votesList", votesList);
        model.addAttribute("error", error);
        model.addAttribute("errorMessage", errorMessage);

        return "statistic";
    }

    @PostMapping("/submit_vote")
    public String vote(HttpServletRequest request, Vote usersVotes) {

        int points = Integer.parseInt(request.getParameter("points"));
        return votesService.addVote(usersVotes, points);
    }
}
