package com.example.jpadto.student.infraestructure.controller;

import com.example.jpadto.student.infraestructure.dto.input.InputDTOStudent;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudent;
import com.example.jpadto.application.UsuarioServicioInterface;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentFull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Estudiante")
public class PostEstudianteControlador {
    @Autowired
    private UsuarioServicioInterface usuarioServicio;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/anadirEstudiante")
    public ResponseEntity<OutputDTOStudent> anadirProfesor(@RequestBody InputDTOStudent dtoStudent) throws Exception {
        OutputDTOStudent estudiante = usuarioServicio.guardarEstudiante(dtoStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
    }

}
