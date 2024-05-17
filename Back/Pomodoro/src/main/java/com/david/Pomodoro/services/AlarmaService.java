package com.david.Pomodoro.services;

import com.david.Pomodoro.entities.Alarma;
import com.david.Pomodoro.repositories.AlarmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmaService {

    @Autowired
    private AlarmaRepository alarmaRepository;

    public List<Alarma> findAll() {
        return alarmaRepository.findAll();
    }

    public Optional<Alarma> findById(Long id) {
        return alarmaRepository.findById(id);
    }

    public Alarma save(Alarma alarma) {
        return alarmaRepository.save(alarma);
    }

    public void deleteById(Long id) {
        alarmaRepository.deleteById(id);
    }

    public Optional<Alarma> update(Long id, Alarma alarmaDetails) {
        Optional<Alarma> alarmaOptional = alarmaRepository.findById(id);
        if (alarmaOptional.isPresent()) {
            Alarma alarma = alarmaOptional.get();
            alarma.setAlarmName(alarmaDetails.getAlarmName());
            alarma.setVolume(alarmaDetails.getVolume());
            return Optional.of(alarmaRepository.save(alarma));
        } else {
            return Optional.empty();
        }
    }
}
