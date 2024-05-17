package com.david.Pomodoro.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    private Long id;
    private String username;
    private String password;
    private String email;

    @JsonIgnore
    @OneToMany(targetEntity = Sesion.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Sesion> sesiones;

    @JsonIgnore
    @ManyToOne(targetEntity = Color.class)
    private Color color;

    @JsonIgnore
    @ManyToOne(targetEntity = Alarma.class)
    private Color alarma;
}
