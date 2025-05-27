package com.cebem.medidor.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "misiones")
public class Mision {

    @Id
    private String id;
    private String nombre;               // título de la misión
    private String descripcion;          // en qué consiste
    private String dificultad;           // baja | media | alta
    private int recompensa;              // puntos o monedas
    private List<String> robotsParticipantes;  // IDs de robots asignados
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String resultado;            // pendiente | éxito | fracaso

}

