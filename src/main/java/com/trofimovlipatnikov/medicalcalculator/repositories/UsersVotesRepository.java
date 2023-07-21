package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.User;
import com.trofimovlipatnikov.medicalcalculator.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersVotesRepository extends JpaRepository<Vote, Integer> {

    Vote findByUser(User user);
}
