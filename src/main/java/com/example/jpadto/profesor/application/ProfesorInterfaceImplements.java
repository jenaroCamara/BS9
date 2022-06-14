package com.example.jpadto.profesor.application;

import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.persona.infraestructure.repository.PersonaRepositorio;
import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.repository.ProfesorRepositorio;
import com.example.jpadto.student.infraestructure.repository.EstudianteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorInterfaceImplements implements ProfesorInterface{
    @Autowired
    private PersonaRepositorio personaRepositorio;
    @Autowired
    private ProfesorRepositorio profesorRepositorio;
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    //--------------------------Profesor----------------------

    public OutputDTOProfesor guardarProfesor(InputDTOProfesor profesor) throws Exception {
        Persona persona = personaRepositorio.findById(Integer.parseInt(profesor.getPersona())).orElseThrow(
                () -> new UnprocesableException("Error, el usuario con id: " + profesor.getId_profesor() + ", no se encuentra"));
        if (persona.getEstudiante() != null) {
            throw new BeanNotFoundException("Error, el usuario no puede ser 2 cosas a la vez");
        }
        Profesor profesor1 = modelMapper.map(profesor, Profesor.class);
        profesor1.setPersona(persona);
        profesor1.getPersona().setProfesor(profesor1);
        profesor1 = profesorRepositorio.save(profesor1);
        return modelMapper.map(profesor1, OutputDTOProfesor.class);
    }

    public OutputDTOProfesor getProfesor(String id) throws Exception{
        return modelMapper.map(profesorRepositorio.findById(id)
                        .orElseThrow(()->new UnprocesableException("Error, el profesro con id " + id + " no se encuentra"))
                ,OutputDTOProfesor.class);
    }
}
