package com.david.Pomodoro.controllers;

import com.david.Pomodoro.entities.Alarma;
import com.david.Pomodoro.services.AlarmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alarmas")
public class AlarmaController {

    @Autowired
    private AlarmaService alarmaService;

    @GetMapping
    public List<Alarma> getAllAlarmas() {
        return alarmaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alarma> getAlarmaById(@PathVariable Long id) {
        Optional<Alarma> alarma = alarmaService.findById(id);
        return alarma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alarma createAlarma(@RequestBody Alarma alarma) {
        return alarmaService.save(alarma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alarma> updateAlarma(@PathVariable Long id, @RequestBody Alarma alarmaDetails) {
        Optional<Alarma> updatedAlarma = alarmaService.update(id, alarmaDetails);
        return updatedAlarma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlarma(@PathVariable Long id) {
        Optional<Alarma> alarma = alarmaService.findById(id);
        if (alarma.isPresent()) {
            alarmaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
