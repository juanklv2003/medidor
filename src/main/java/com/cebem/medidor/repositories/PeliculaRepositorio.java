package com.cebem.medidor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cebem.medidor.models.Pelicula;

public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findTop10ByOrderByRatingDesc();
}
