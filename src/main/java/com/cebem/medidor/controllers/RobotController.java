package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Robot;
import com.cebem.medidor.service.RobotService;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/robots")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping
    public ResponseEntity<Robot> crearRobot(@RequestBody Robot robot) {
        Robot creado = robotService.crearRobot(robot);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public ResponseEntity<List<Robot>> listarRobots() {
        List<Robot> lista = robotService.listarRobots();
        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}/recargar")
    public ResponseEntity<Robot> recargarEnergia(@PathVariable String id) {
        Robot robot = robotService.recargarEnergia(id);
        return ResponseEntity.ok(robot);
    }

    @PatchMapping("/{id}/subir-nivel")
    public ResponseEntity<Robot> subirNivel(@PathVariable String id) {
        Robot robot = robotService.subirNivel(id);
        return ResponseEntity.ok(robot);
    }

@GetMapping("/listar")
public String listarRobots(Model model) {
    List<Robot> robots = robotService.listarRobots();
    model.addAttribute("robots", robots);
    return "robots"; // archivo robots.html en templates
}

}

