package com.cebem.medidor.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String modelo;
    private int energiaActual;
    private int energiaMaxima;
    private int nivel;

    public enum EstadoRobot {
    ACTIVO, DANADO, DESTRUIDO
    };

    @ElementCollection
    private List<String> habilidades;

    @Enumerated(EnumType.STRING)
    private EstadoRobot estado;
    
    @ManyToMany(mappedBy = "robotsParticipantes")
    private List<Mision> misionesRealizadas;
}
