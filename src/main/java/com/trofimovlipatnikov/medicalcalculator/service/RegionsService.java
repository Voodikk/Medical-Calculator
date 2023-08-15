package com.trofimovlipatnikov.medicalcalculator.service;

import com.trofimovlipatnikov.medicalcalculator.models.Entities.Region;
import com.trofimovlipatnikov.medicalcalculator.repositories.RegionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionsService {

    //  Сервис регионов

    RegionsRepository regionsRepository;

    public Region findByRegionNumber(Integer number) {
        return regionsRepository.findByRegionNumber(number).orElse(null);
    }
}
