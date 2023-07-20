package com.trofimovlipatnikov.medicalcalculator.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_votes")
public class UsersVotes {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "region_id")
    private int regionId;

    @Column(name = "points")
    private int points;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
