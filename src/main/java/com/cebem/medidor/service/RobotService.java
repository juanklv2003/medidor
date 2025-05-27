package com.cebem.medidor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.RobotRepository;

@Service
public class RobotService {

    private final RobotRepository robotRepository;

    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    public List<Robot> listarRobots() {
        return robotRepository.findAll();
    }

    public Robot crearRobot(Robot robot) {
        return robotRepository.save(robot);
    }

    public Robot recargarEnergia(String id) {
    Robot robot = robotRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Robot no encontrado"));
    robot.setEnergiaActual(robot.getEnergiaMaxima());
    return robotRepository.save(robot);
}

public Robot subirNivel(String id) {
    Robot robot = robotRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Robot no encontrado"));
    robot.setNivel(robot.getNivel() + 1);
    return robotRepository.save(robot);
}


}

