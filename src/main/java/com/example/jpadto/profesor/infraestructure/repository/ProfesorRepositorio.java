package com.example.jpadto.profesor.infraestructure.repository;

import com.example.jpadto.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor,String> {
}
