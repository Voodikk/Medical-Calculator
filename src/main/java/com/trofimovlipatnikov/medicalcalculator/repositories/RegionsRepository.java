package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionsRepository extends JpaRepository<Region, Integer> {

    Optional<Region> findByRegionNumber(Integer regionNumber);

}
