package com.trofimovlipatnikov.medicalcalculator.service.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class ActionAfterMethodHandler {

    public String actionAfterFail(Model model, String errorMessage, String view) {

        model.addAttribute("error", true);
        model.addAttribute("errorMessage", errorMessage);
        return view;
    }

    public String actionAfterSuccess(Model model, String view) {

        model.addAttribute("isSuccess", true);
        return view;
    }

    public String actionAfterSuccess(String view) {
        return view;
    }
}
