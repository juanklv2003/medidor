package com.cebem.medidor.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.List;

@Data
@Document(collection = "robots")
public class Robot {

    @Id
    private String id;
    private String nombre;
    private String modelo;
    private String tipo;  // asalto, defensa, espionaje, médico…
    private int energiaActual;
    private int energiaMaxima;
    private int nivel;
    private List<String> habilidades;          // lista de habilidades
    private String estado;                     // activo | dañado | destruido
    private List<String> misionesRealizadas;  // IDs de misiones completadas

}


