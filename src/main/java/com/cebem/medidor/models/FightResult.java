package com.cebem.medidor.models;

import lombok.Data;

@Data
public class FightResult {
    private String heroe1;
    private int puntuacion1;
    private String heroe2;
    private int puntuacion2;
    private String resultado;


    public FightResult(String heroe1, int puntuacion1, String heroe2, int puntuacion2, String resultado) {
        this.heroe1 = heroe1;
        this.puntuacion1 = puntuacion1;
        this.heroe2 = heroe2;
        this.puntuacion2 = puntuacion2;
        this.resultado = resultado;
    }
}