package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.RegionVote;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionVoteRepository;
import com.trofimovlipatnikov.medicalcalculator.service.VotesService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {

    //  Контроллер страницы Статистика

    //  Подключаем сервис голосов и репозиторий среднего значения по регионам
    private final VotesService votesService;
    private final RegionVoteRepository regionVoteRepository;


    @GetMapping
    public String getStatistic(@RequestParam(value = "error", required = false) boolean error,
                               @RequestParam(value = "errorMessage", required = false) String errorMessage,
                               @RequestParam(value = "isSubmit", required = false) boolean isSubmit,
                               Model model) {

        //  Отправляем на фронт наши средние значения по регионам из базы данных
        List<RegionVote> votesList = regionVoteRepository.findAll();
        model.addAttribute("votesList", votesList);

        //  Отправляем возможные ошибки, возникшие в процессе отправки своего голоса, а также текст ошибки
        model.addAttribute("error", error);
        model.addAttribute("errorMessage", errorMessage);

        //  Если все прошло без ошибок, сообщаем фронту
        //  Чтобы сайт реагировал на действие пользователя
        model.addAttribute("isSubmit", isSubmit);


        return "statistic";
    }

    @PostMapping("/submit_vote")
    public String vote(HttpServletRequest request, Vote usersVotes) {

        //  Получаем число, которое написал пользователь в своем голосе и возвращаем метод сервиса голосов,
        //  он в свою очередь сохраняет в базу данных голос пользователя или меняет уже существующий
        int points = Integer.parseInt(request.getParameter("points"));
        return votesService.addVote(usersVotes, points);
    }
}
