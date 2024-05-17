package com.david.Pomodoro.controllers;

import com.david.Pomodoro.entities.Sesion;
import com.david.Pomodoro.services.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @GetMapping
    public List<Sesion> getAllSesiones() {
        return sesionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> getSesionById(@PathVariable Long id) {
        Optional<Sesion> sesion = sesionService.findById(id);
        return sesion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sesion createSesion(@RequestBody Sesion sesion) {
        return sesionService.save(sesion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion> updateSesion(@PathVariable Long id, @RequestBody Sesion sesionDetails) {
        Optional<Sesion> updatedSesion = sesionService.update(id, sesionDetails);
        return updatedSesion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSesion(@PathVariable Long id) {
        Optional<Sesion> sesion = sesionService.findById(id);
        if (sesion.isPresent()) {
            sesionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
