package com.david.Pomodoro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.Pomodoro.entities.Color;

@Repository
public interface ColorRepository  extends JpaRepository<Color, Long>{

}
