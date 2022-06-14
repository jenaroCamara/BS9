package com.example.jpadto.student.infraestructure.repository;

import com.example.jpadto.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio  extends JpaRepository<Student,String> {
}
