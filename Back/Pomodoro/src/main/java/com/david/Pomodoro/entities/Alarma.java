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
public class Alarma {

    private Long id;
    private String alarmName;
    private int volume;

    @JsonIgnore
    @OneToMany(targetEntity = Usuario.class, fetch = FetchType.LAZY, mappedBy = "alarma")
    private List<Usuario> usuarios;
}
