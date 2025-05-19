package com.cebem.medidor.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.Robot;
import com.cebem.medidor.repositories.MisionRepository;
import com.cebem.medidor.repositories.RobotRepository;

import java.util.List;

@Controller
@RequestMapping("/misiones")
public class MisionController {

    private final MisionRepository misionRepository;
    private final RobotRepository robotRepository;

    public MisionController(MisionRepository misionRepository, RobotRepository robotRepository) {
        this.misionRepository = misionRepository;
        this.robotRepository = robotRepository;
    }

    @GetMapping
    public String listarMisiones(Model model) {
        List<Mision> misiones = misionRepository.findAll();
        model.addAttribute("misiones", misiones);
        return "mision";  // Thymeleaf buscará templates/misiones.html
    }

    @PostMapping
    @ResponseBody
    public Mision crearMision(@RequestBody Mision mision) {
        return misionRepository.save(mision);
    }

 @PatchMapping("/{id}/asignar-robot")
public ResponseEntity<Mision> asignarRobot(@PathVariable Long id, @RequestParam Long robotId) {
    var misionOpt = misionRepository.findById(id);
    var robotOpt = robotRepository.findById(robotId);

    if (misionOpt.isEmpty() || robotOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    Mision mision = misionOpt.get();
    Robot robot = robotOpt.get();

    mision.getRobotsParticipantes().add(robot);
    Mision actualizada = misionRepository.save(mision);

    return ResponseEntity.ok(actualizada);
}
}