package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.UsersVotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersVotesRepository extends JpaRepository<UsersVotes, Integer> {

    UsersVotes findByUserId(int user_id);
}
