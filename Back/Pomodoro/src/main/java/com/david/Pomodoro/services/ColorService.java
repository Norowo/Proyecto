package com.david.Pomodoro.services;

import com.david.Pomodoro.entities.Color;
import com.david.Pomodoro.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    public Optional<Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    public Color save(Color color) {
        return colorRepository.save(color);
    }

    public void deleteById(Long id) {
        colorRepository.deleteById(id);
    }

    public Optional<Color> update(Long id, Color colorDetails) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        if (colorOptional.isPresent()) {
            Color color = colorOptional.get();
            color.setColor(colorDetails.getColor());
            return Optional.of(colorRepository.save(color));
        } else {
            return Optional.empty();
        }
    }
}
