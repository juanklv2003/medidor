package com.cebem.medidor.service;

import org.springframework.stereotype.Service;

import com.cebem.medidor.models.FightResult;
import com.cebem.medidor.models.Powerstats;
import com.cebem.medidor.models.SuperHero;

@Service
public class FightService {

    private final SuperheroService superheroService;

    public FightService(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    public FightResult generarPelea() {
        SuperHero heroe1 = superheroService.getRandomHero();
        SuperHero heroe2 = superheroService.getRandomHero();

        int puntuacion1 = getPuntuacion(heroe1.getPowerstats());
        int puntuacion2 = getPuntuacion(heroe2.getPowerstats());

        String resultado;
        if (puntuacion1 > puntuacion2) {
            resultado = heroe1.getName() + " gana contra " + heroe2.getName();
        } else if (puntuacion2 > puntuacion1) {
            resultado = heroe2.getName() + " gana contra " + heroe1.getName();
        } else {
            resultado = heroe1.getName() + " y " + heroe2.getName() + " están empatados";
        }

        return new FightResult( // Verifica que este constructor coincide con el de la clase FightResult
            heroe1.getName(),
            puntuacion1,
            heroe2.getName(),
            puntuacion2,
            resultado
        );
    }

    private int getPuntuacion(Powerstats stats) {
        return parsear(stats.getIntelligence()) +
               parsear(stats.getStrength()) +
               parsear(stats.getSpeed()) +
               parsear(stats.getDurability()) +
               parsear(stats.getPower()) +
               parsear(stats.getCombat());
    }

    private int parsear(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            return 0;
        }
    }
}