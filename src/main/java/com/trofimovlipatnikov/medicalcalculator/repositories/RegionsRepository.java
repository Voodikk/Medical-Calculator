package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionsRepository extends JpaRepository<Region, Integer> {

    //  Репозиторий таблицы регионов

    Optional<Region> findByRegionNumber(Integer regionNumber);
}
