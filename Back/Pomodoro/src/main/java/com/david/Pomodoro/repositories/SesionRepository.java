package com.david.Pomodoro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.Pomodoro.entities.Sesion;

@Repository
public interface SesionRepository  extends JpaRepository<Sesion, Long>{

}
