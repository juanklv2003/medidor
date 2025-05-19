package com.cebem.medidor.components;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.RobotAsalto;
import com.cebem.medidor.models.RobotMedico;
import com.cebem.medidor.models.Mision.DificultadMision;
import com.cebem.medidor.models.Mision.ResultadoMision;
import com.cebem.medidor.models.Robot.EstadoRobot;
import com.cebem.medidor.repositories.MisionRepository;
import com.cebem.medidor.repositories.RobotRepository;

import java.time.LocalDate;
import java.util.List;

@Component
public class ComponentRobotMision implements CommandLineRunner {

    private final RobotRepository robotRepo;
    private final MisionRepository misionRepo;

    public ComponentRobotMision(RobotRepository robotRepo, MisionRepository misionRepo) {
        this.robotRepo = robotRepo;
        this.misionRepo = misionRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear robots (usando subclases)
        RobotAsalto r1 = new RobotAsalto();
        r1.setNombre("RoboAsalto1");
        r1.setModelo("XJ-9");
        r1.setEnergiaMaxima(100);
        r1.setEnergiaActual(80);
        r1.setNivel(3);
        r1.setEstado(EstadoRobot.ACTIVO);
        r1.setHabilidades(List.of("ataque láser", "camuflaje"));

        RobotMedico r2 = new RobotMedico();
        r2.setNombre("RoboMedico1");
        r2.setModelo("MD-3");
        r2.setEnergiaMaxima(120);
        r2.setEnergiaActual(120);
        r2.setNivel(5);
        r2.setEstado(EstadoRobot.ACTIVO);
        r2.setHabilidades(List.of("curación rápida", "reparación"));

        robotRepo.saveAll(List.of(r1, r2));

        // Crear misión
        Mision m1 = new Mision();
        m1.setNombre("Rescate en zona hostil");
        m1.setDescripcion("Rescatar a los humanos atrapados.");
        m1.setDificultad(DificultadMision.ALTA);
        m1.setRecompensa(500);
        m1.setFechaInicio(LocalDate.now());
        m1.setFechaFin(LocalDate.now().plusDays(7));
        m1.setResultado(ResultadoMision.PENDIENTE);
        m1.setRobotsParticipantes(List.of(r1, r2));

        misionRepo.save(m1);
    }
}

