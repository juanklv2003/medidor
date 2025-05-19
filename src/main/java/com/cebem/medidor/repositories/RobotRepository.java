package com.cebem.medidor.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cebem.medidor.models.Robot;
import com.cebem.medidor.models.Robot.EstadoRobot;

@Repository
public interface RobotRepository extends JpaRepository<Robot, Long> {
    // Ejemplos de métodos personalizados:
    List<Robot> findByEstado(EstadoRobot estado);
    List<Robot> findByNombreContainingIgnoreCase(String nombre);
}
