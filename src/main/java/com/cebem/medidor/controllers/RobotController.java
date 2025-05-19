package com.cebem.medidor.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.RobotRepository;

import java.util.List;

@Controller
@RequestMapping("/robots")
public class RobotController {

    private final RobotRepository robotRepository;

    public RobotController(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    @GetMapping
    public String listarRobots(Model model) {
        List<Robot> robots = robotRepository.findAll();
        model.addAttribute("robots", robots);
        return "robot";  // Thymeleaf buscará templates/robots.html
    }

    @PostMapping
    @ResponseBody
    public Robot crearRobot(@RequestBody Robot robot) {
        return robotRepository.save(robot);
    }

    @PatchMapping("/{id}/recargar")
    @ResponseBody
    public Robot recargarEnergia(@PathVariable Long id) {
        return robotRepository.findById(id)
            .map(robot -> {
                robot.setEnergiaActual(robot.getEnergiaMaxima());
                return robotRepository.save(robot);
            })
            .orElse(null);
    }

    @PatchMapping("/{id}/subir-nivel")
    @ResponseBody
    public Robot subirNivel(@PathVariable Long id) {
        return robotRepository.findById(id)
            .map(robot -> {
                robot.setNivel(robot.getNivel() + 1);
                return robotRepository.save(robot);
            })
            .orElse(null);
    }
}
