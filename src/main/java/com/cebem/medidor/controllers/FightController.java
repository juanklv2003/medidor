package com.cebem.medidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cebem.medidor.models.FightResult;
import com.cebem.medidor.service.FightService;

@Controller
@RequestMapping("/pelea")
public class FightController {

    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping
    public String mostrarPelea(Model model) {
        FightResult result = fightService.generarPelea(); // ver abajo

        model.addAttribute("heroe1", result.getHeroe1());
        model.addAttribute("puntuacion1", result.getPuntuacion1());
        model.addAttribute("heroe2", result.getHeroe2());
        model.addAttribute("puntuacion2", result.getPuntuacion2());
        model.addAttribute("resultado", result.getResultado());

        return "fight";
    }
}

