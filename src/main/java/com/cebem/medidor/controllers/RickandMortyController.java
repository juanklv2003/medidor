package com.cebem.medidor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cebem.medidor.models.RickandmortyCharacter;
import com.cebem.medidor.service.RickandmortyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RickandMortyController {

    //private final RestTemplate restTemplate;
    private final RickandmortyService rickandmortyService;
   

    @GetMapping("/rickandmortyweb")
    public String getRandomCharacter(Model model) {
        RickandmortyCharacter character = rickandmortyService.getCharacterRandom();
        model.addAttribute("character", character);
        return "rick-card";
    }
}
