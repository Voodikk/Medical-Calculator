package com.trofimovlipatnikov.medicalcalculator.repositories;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.models.Entities.RegionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RegionVoteRepository extends JpaRepository<RegionVote, Integer> {

    //  Репозиторий таблицы регионов со средним значением очков

    Optional<RegionVote> findByRegion(Optional<Region> region);

    //  Обновляем запись, после того как пользователь проголосовал
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO votes_avg (region_id, v_avg) SELECT region_id, AVG(points) FROM votes WHERE region_id = :regionId GROUP BY region_id ON CONFLICT (region_id) DO UPDATE SET v_avg = EXCLUDED.v_avg;", nativeQuery = true)
    void calculateAvgPointsForRegion(Integer regionId);
}
