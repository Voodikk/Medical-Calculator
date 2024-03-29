package com.trofimovlipatnikov.medicalcalculator.models.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    //  Сущность таблицы регионов

    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "region_number")
    private Integer regionNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegionNumber() {
        return regionNumber;
    }

    public void setRegionNumber(Integer regionNumber) {
        this.regionNumber = regionNumber;
    }
}
