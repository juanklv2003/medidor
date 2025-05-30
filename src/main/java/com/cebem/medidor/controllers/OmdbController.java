package com.cebem.medidor.controllers;

import com.cebem.medidor.service.OmdbService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/peliculas")
public class OmdbController {

    private final OmdbService omdbService;

    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    // Muestra el formulario
    @GetMapping("/buscar")
    public String mostrarFormulario() {
        return "buscar-pelicula";
    }

    // Procesa el formulario y muestra los resultados
    @PostMapping("/buscar")
    public String procesarBusqueda(@RequestParam String titulo, Model model) {
        Map pelicula = omdbService.buscarPeliculaPorTitulo(titulo);

        if (pelicula == null || "False".equals(pelicula.get("Response"))) {
            model.addAttribute("error", "Película no encontrada");
            return "buscar-pelicula";
        }

        model.addAttribute("pelicula", pelicula);
        return "resultado-pelicula";
    }
}

