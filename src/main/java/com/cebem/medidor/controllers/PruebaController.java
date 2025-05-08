package com.cebem.medidor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cebem.medidor.models.Measure;
import com.cebem.medidor.models.Pelicula;
import com.cebem.medidor.models.PokemonCharacter;
import com.cebem.medidor.models.RickandmortyCharacter;
import com.cebem.medidor.utils.Utils;

import lombok.RequiredArgsConstructor;

import com.cebem.medidor.repositories.MeasureRepository;
import com.cebem.medidor.repositories.PeliculaRepositorio;
import com.cebem.medidor.service.PokemonService;
import com.cebem.medidor.service.RickandmortyService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequiredArgsConstructor
public class PruebaController {
    @GetMapping("/saluda")
    // https:/localhost:8080/saluda
    public String saluda() {
        return "hola jefe jeje";
    }

    @GetMapping("/palindromo/{word}")
    // https:/localhost:8080/palindromo/ana
    public String palindromo(@PathVariable String word) {
        String sb = new StringBuilder(word).reverse().toString();

        return word.equalsIgnoreCase(sb) ? "Si es un palindromo" : "No es un palindromo";

    }

    @GetMapping("/palin")
    // https:/localhost:8080/palin?word=xxx&valor=55
    public String palin(@RequestParam String word, @RequestParam String valor) {
        return Utils.Ispalindromo(word) ? "Si es un palindromo" : "No es un palindromo";
    }

    @PostMapping("/saveOnDisk")
    // https:/localhost:8080/saveOnDisk
    public String postMethodName(@RequestParam String usuario,
            @RequestParam String password) {
        System.out.println("body" + usuario + ' ' + password);
        return "hola";
    }

    // inyeccion de dependecias
    private final MeasureRepository sensorDataRepository;

    @PostMapping("/saveMeasure")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSensorData(@RequestBody Measure sensorData) {
        sensorDataRepository.save(sensorData);
    }

    @GetMapping("/getMeasures")
    public ResponseEntity<List<Measure>> getAllSensorData() {
        List<Measure> sensorDataList = sensorDataRepository.findAll();
        return ResponseEntity.ok(sensorDataList);
    }
    /*
     * - [] Un endpoint que te permita añadir una pelicula (con los datos que
     * estimes oportunos)
     * - [] Un endpoint que te permita listar todas las peliculas que has insertado
     * - [] Un endpoint que te permita borrar una pelicula (por su id)
     * - [] Un endpoint que te permita listar las 10 peliculas mejor valoradas
     */

    // inyeccion de dependecias
    private final PeliculaRepositorio peliculaRepository;

    // Añadir una película
    @PostMapping("/peliculas")
    @ResponseStatus(HttpStatus.CREATED)
    public Pelicula addPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Listar todas las películas
    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    // Borrar una película por ID
    @PostMapping("/peliculasDelete/{id}")
    public ResponseEntity<String> deletePelicula(@PathVariable Long id) {
        if (!peliculaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Película no encontrada");
        }
        peliculaRepository.deleteById(id);
        return ResponseEntity.ok("Película eliminada");
    }

    // Listar top 10 mejor valoradas
    @GetMapping("/peliculasTop")
    public List<Pelicula> topPeliculas() {
        return peliculaRepository.findTop10ByOrderByRatingDesc();
    }

    private final RickandmortyService rickandmortyService;

    // ejercicio 4 endpoints
    @GetMapping("/rickandmorty/random")
    public RickandmortyCharacter randomRickandmorty() {
        // obtener los datos del personaje (nombre, foto, ...)
        return rickandmortyService.getCharacterRandom();
    }

    private final PokemonService pokemonService;

    // Endpoint para obtener un Pokémon aleatorio
    @GetMapping("/pokemon/random")
    public PokemonCharacter randomPokemon() {
        return pokemonService.getCharacterRandom();
    }
}
