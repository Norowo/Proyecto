package com.david.Pomodoro.controllers;

import com.david.Pomodoro.entities.Color;
import com.david.Pomodoro.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colores")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public List<Color> getAllColores() {
        return colorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable Long id) {
        Optional<Color> color = colorService.findById(id);
        return color.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Color createColor(@RequestBody Color color) {
        return colorService.save(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Long id, @RequestBody Color colorDetails) {
        Optional<Color> updatedColor = colorService.update(id, colorDetails);
        return updatedColor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        Optional<Color> color = colorService.findById(id);
        if (color.isPresent()) {
            colorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
