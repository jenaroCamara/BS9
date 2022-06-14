package com.example.jpadto.persona.infraestructure.repository;

import com.example.jpadto.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
    List<Persona> findByName(String nombre);
}
