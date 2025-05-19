package com.cebem.medidor.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.models.Mision.DificultadMision;
import com.cebem.medidor.models.Mision.ResultadoMision;

@Repository
public interface MisionRepository extends JpaRepository<Mision, Long> {
    // Ejemplos de métodos personalizados:
    List<Mision> findByDificultad(DificultadMision dificultad);
    List<Mision> findByResultado(ResultadoMision resultado);
    List<Mision> findByFechaInicioBetween(LocalDate inicio, LocalDate fin);

}
