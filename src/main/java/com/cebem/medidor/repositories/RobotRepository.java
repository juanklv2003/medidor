package com.cebem.medidor.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cebem.medidor.models.Robot;

public interface RobotRepository extends MongoRepository<Robot, String> {
    // Aquí puedes agregar consultas personalizadas si quieres, ejemplo:
    // List<Robot> findByTipo(String tipo);
}

