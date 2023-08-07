package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.User;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.Vote;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionsRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UserRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.UsersVotesRepository;
import com.trofimovlipatnikov.medicalcalculator.repositories.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotesService {

    private final UsersVotesRepository usersVotesRepository;

    private final UserRepository userRepository;

    private final VoteRepository voteRepository;

    private final RegionsRepository regionsRepository;


    @Transactional
    public String addVote(Vote usersVotes, int points) {
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Optional<User> user = userRepository.findByUsername(username);

            if(user.isPresent()) {
                Optional<Vote> existingVote = voteRepository.findByUser(user.get());

                if (existingVote.isPresent()) {
                    Vote voteToUpdate = existingVote.get();
                    voteToUpdate.setPoints(points);
                    voteRepository.save(voteToUpdate);
                } else {
                    usersVotes.setUser(user.get());
                    usersVotes.setRegion(user.get().getRegion());
                    usersVotes.setPoints(points);
                    usersVotesRepository.save(usersVotes);
                }

                Region region = user.get().getRegion();
                Integer regionId = region.getId();
                regionsRepository.calculateAvgPointsForRegion(regionId);
                return "redirect:/statistic";


            }
            else {
                throw new Exception("Сначала войдите в аккаунт");
            }

        }
        catch (Exception exception) {
            return "redirect:/login?error=true&errorMessage=" + URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8);
        }


    }


}
