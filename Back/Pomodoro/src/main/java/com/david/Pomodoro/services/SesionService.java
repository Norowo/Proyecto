package com.david.Pomodoro.services;

import com.david.Pomodoro.entities.Sesion;
import com.david.Pomodoro.repositories.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    public List<Sesion> findAll() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> findById(Long id) {
        return sesionRepository.findById(id);
    }

    public Sesion save(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    public void deleteById(Long id) {
        sesionRepository.deleteById(id);
    }

    public Optional<Sesion> update(Long id, Sesion sesionDetails) {
        Optional<Sesion> sesionOptional = sesionRepository.findById(id);
        if (sesionOptional.isPresent()) {
            Sesion sesion = sesionOptional.get();
            sesion.setFechaHora(sesionDetails.getFechaHora());
            sesion.setWorkDuration(sesionDetails.getWorkDuration());
            sesion.setRestDuration(sesionDetails.getRestDuration());
            sesion.setLongRestDuration(sesionDetails.getLongRestDuration());
            sesion.setRepetitions(sesionDetails.getRepetitions());
            sesion.setUsuario(sesionDetails.getUsuario());
            return Optional.of(sesionRepository.save(sesion));
        } else {
            return Optional.empty();
        }
    }
}
