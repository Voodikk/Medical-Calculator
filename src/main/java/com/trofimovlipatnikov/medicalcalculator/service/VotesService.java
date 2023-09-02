package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.*;
import com.trofimovlipatnikov.medicalcalculator.service.handlers.ActionAfterMethodHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotesService {

    //  Сервис голосов

    private final VoteRepository voteRepository;

    private final RegionVoteRepository regionVoteRepository;

    private final AuthService authService;

    private final ActionAfterMethodHandler actionAfterMethodHandler;


    //  Добавляем запись голоса в таблицу
    @Transactional
    public String addVote(Vote usersVotes, int points, Model model) {

        try {
            //  Получаем пользователя, который отправил свой голос
            Optional<User> user = authService.getUserFromSession();

            //  Если юзер из сессии не будет найден в базе данных, значит пользователь не авторизован
            if (user.isEmpty()) {
                return actionAfterMethodHandler.actionAfterFail(model, "Сначала войдите в аккаунт", "redirect:/login");
            }

            Optional<Vote> existingVote = voteRepository.findByUser(user.get());

            //  Если такой пользователь уже отправлял свой голос, то обновляем запись
            if (existingVote.isPresent()) {
                Vote voteToUpdate = existingVote.get();
                voteToUpdate.setPoints(points);
                voteRepository.save(voteToUpdate);
            }
            //  Если пользователь еще не голосовал, добавляем запись
            else {
                usersVotes.setUser(user.get());
                usersVotes.setRegion(user.get().getRegion());
                usersVotes.setPoints(points);
                voteRepository.save(usersVotes);
            }

            //  Обновляем запись, в которой регион соответствует региону проголосовавшего пользователя, в таблице средних значений по регионам
            Region region = user.get().getRegion();
            Integer regionId = region.getId();
            regionVoteRepository.calculateAvgPointsForRegion(regionId);

            //  Говорим контроллеру, что все прошло успешно
            return actionAfterMethodHandler.actionAfterSuccess(model, "redirect:/statistic");
        }
        catch (Exception exception) {
            return actionAfterMethodHandler.actionAfterFail(model, "Упс, возникла какая-то ошибка, попробуйте позже", "redirect:/statistic");
        }
    }


}
