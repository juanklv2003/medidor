package com.cebem.medidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cebem.medidor.models.Mision;
import com.cebem.medidor.repositories.MisionRepository;

@Service
public class MisionService {

    private final MisionRepository misionRepository;

    public MisionService(MisionRepository misionRepository) {
        this.misionRepository = misionRepository;
    }

    public List<Mision> listarMisiones() {
        return misionRepository.findAll();
    }

    public Mision crearMision(Mision mision) {
        // Aquí podrías agregar validaciones antes de guardar
        return misionRepository.save(mision);
    }

    public Optional<Mision> buscarPorId(String id) {
        return misionRepository.findById(id);
    }

    public Mision asignarRobotAMision(String idMision, String idRobot) {
        Optional<Mision> optionalMision = misionRepository.findById(idMision);
        if(optionalMision.isPresent()) {
            Mision mision = optionalMision.get();
            if(mision.getRobotsParticipantes() == null) {
                mision.setRobotsParticipantes(new java.util.ArrayList<>());
            }
            if(!mision.getRobotsParticipantes().contains(idRobot)) {
                mision.getRobotsParticipantes().add(idRobot);
            }
            return misionRepository.save(mision);
        }
        throw new RuntimeException("Misión no encontrada");
    }
}
