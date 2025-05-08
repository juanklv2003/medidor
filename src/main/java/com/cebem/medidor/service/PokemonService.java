package com.cebem.medidor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cebem.medidor.models.PokemonCharacter;

@Service
public class PokemonService {
    
    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonCharacter getCharacterRandom() {
        int randomId = (int) (Math.random() * 1010 + 1); // Hay 1010 Pokémon en la API
        String url = "https://pokeapi.co/api/v2/pokemon/" + randomId; // URL de la API para obtener un Pokémon por ID
        return restTemplate.getForObject(url, PokemonCharacter.class);
    }
}
