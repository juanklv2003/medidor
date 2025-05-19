package com.cebem.medidor.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    public enum DificultadMision {
    BAJA, MEDIA, ALTA
}

public enum ResultadoMision {
    PENDIENTE, EXITO, FRACASO
}

    @Enumerated(EnumType.STRING)
    private DificultadMision dificultad;

    private int recompensa;

    @ManyToMany
    @JoinTable(
        name = "robot_mision",
        joinColumns = @JoinColumn(name = "mision_id"),
        inverseJoinColumns = @JoinColumn(name = "robot_id")
    )
    private List<Robot> robotsParticipantes;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private ResultadoMision resultado;

}
