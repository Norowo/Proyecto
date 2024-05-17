package com.david.Pomodoro.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Color {

    private Long id;
    private String color;

    @JsonIgnore
    @OneToMany(targetEntity = Usuario.class, fetch = FetchType.LAZY, mappedBy = "color")
    private List<Usuario> usuarios;
}
