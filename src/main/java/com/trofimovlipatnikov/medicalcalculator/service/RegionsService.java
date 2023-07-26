package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionsService {

    @Autowired
    RegionsRepository regionsRepository;

    public Region findByRegionNumber(Integer number) {
        return regionsRepository.findByRegionNumber(number).orElse(null);
    }
}
