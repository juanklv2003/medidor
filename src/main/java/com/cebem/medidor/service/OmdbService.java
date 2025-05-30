package com.cebem.medidor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;



@Service
public class OmdbService {

    // Clave API directamente embebida (solo recomendado para pruebas)
    private final String apiKey = "ae516bc3";

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> buscarPeliculaPorTitulo(String titulo) {
        String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + titulo.replace(" ", "+");
        return restTemplate.getForObject(url, Map.class);
    }
}

