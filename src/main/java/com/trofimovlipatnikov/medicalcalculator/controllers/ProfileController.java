package com.trofimovlipatnikov.medicalcalculator.controllers;

import com.trofimovlipatnikov.medicalcalculator.service.AuthService;
import com.trofimovlipatnikov.medicalcalculator.service.ProfileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileDataService profileDataService;

    @GetMapping("/me")
    public String getProfile(Model model) {
        return profileDataService.getProfile(model);
    }

    @PostMapping("/me/change_info")
    public String changeProfileData(@RequestParam("username") String username,
                                    @RequestParam("email") String email
    ) {
        return profileDataService.changeProfileData(username, email);
    }
}
