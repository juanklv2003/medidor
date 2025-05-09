package com.cebem.medidor.service;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.medidor.models.SuperHero;

@Service
public class SuperheroService {

    private final String TOKEN = "fb258fcac5c2d77c7b14e9fbd5c86f3a"; // cambia esto por tu token real
    private final String API_URL = "https://superheroapi.com/api/" + TOKEN  + "/";

    private final RestTemplate restTemplate = new RestTemplate();

    public SuperHero getHeroById(int id) {
        return restTemplate.getForObject(API_URL + id, SuperHero.class);
    }

    public SuperHero getRandomHero() {
        int randomId = new Random().nextInt(731) + 1; // hay 731 héroes
        return getHeroById(randomId);
    }
}
