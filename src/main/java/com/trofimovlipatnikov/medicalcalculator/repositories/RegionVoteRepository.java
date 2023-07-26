package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.RegionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionVoteRepository extends JpaRepository<RegionVote, Integer> {

    Optional<RegionVote> findByRegion(Optional<Region> region);
}
