package com.david.Pomodoro.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sesion {

    private Long id;
    private LocalDate fechaHora;
    private int workDuration;
    private int restDuration;
    private int longRestDuration;
    private int repetitions;

    @JsonIgnore
    @ManyToOne(targetEntity = Usuario.class)
    private Usuario usuario;

}
