package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.Robot;
import com.cebem.medidor.service.MisionService;
import com.cebem.medidor.service.RobotService;

@Controller
@RequestMapping("/misiones")
public class MisionController {

    private final MisionService misionService;
    private final RobotService robotService;

    public MisionController(MisionService misionService, RobotService robotService) {
        this.misionService = misionService;
        this.robotService = robotService;
    }

    @PostMapping
    public ResponseEntity<Mision> crearMision(@RequestBody Mision mision) {
        Mision creada = misionService.crearMision(mision);
        return ResponseEntity.ok(creada);
    }

    @GetMapping
    public ResponseEntity<List<Mision>> listarMisiones() {
        List<Mision> lista = misionService.listarMisiones();
        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}/asignar-robot")
    public ResponseEntity<Mision> asignarRobot(@PathVariable String id, @RequestParam String robotId) {
        Mision misionActualizada = misionService.asignarRobotAMision(id, robotId);
        return ResponseEntity.ok(misionActualizada);
    }

    @GetMapping("/listar")
    public String listarMisiones(Model model) {
        List<Mision> misiones = misionService.listarMisiones();
        List<Robot> robots = robotService.listarRobots();
        model.addAttribute("misiones", misiones);
        model.addAttribute("robots", robots);
        return "misiones";  // nombre del template sin extensión
    }
}
