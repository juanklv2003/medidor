package com.cebem.medidor.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cebem.medidor.models.Mision;

public interface MisionRepository extends MongoRepository<Mision, String> {
    // Puedes añadir métodos personalizados aquí
}

