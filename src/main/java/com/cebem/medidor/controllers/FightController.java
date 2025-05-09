package com.cebem.medidor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.service.FightService;

@RestController
@RequestMapping("/api")
public class FightController {

    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping ("/fight")
    public String fight() {
        return fightService.fight();
    }
}

