package com.trofimovlipatnikov.medicalcalculator.models;

import jakarta.persistence.*;

@Entity
@Table(name = "votes_avg")
public class RegionVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    @Column(name = "v_avg")
    private Integer votesAverage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getVotesAverage() {
        return votesAverage;
    }

    public void setVotesAverage(Integer votesAverage) {
        this.votesAverage = votesAverage;
    }
}
