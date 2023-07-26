package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RegionsRepository extends JpaRepository<Region, Integer> {

    Optional<Region> findByRegionNumber(Integer regionNumber);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO votes_avg (region_id, v_avg) SELECT region_id, AVG(points) FROM votes GROUP BY region_id ON CONFLICT (region_id) DO UPDATE SET v_avg = EXCLUDED.v_avg;", nativeQuery = true)
    void calculateAvgPoints();
}
