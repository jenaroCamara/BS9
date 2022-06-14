package com.example.jpadto.profesor.application;

import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorInterface{
    public OutputDTOProfesor guardarProfesor(InputDTOProfesor profesor) throws Exception;
    public OutputDTOProfesor getProfesor(String id) throws Exception;
}
