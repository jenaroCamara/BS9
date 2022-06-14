package com.example.jpadto.student.infraestructure.dto.output.Student;

import com.example.jpadto.persona.infraestructure.dto.output.OutputDTOPersona;
import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.persona.domain.Persona;
import com.example.jpadto.profesor.infraestructure.dto.output.outputDTOprofesorNC;
import lombok.Data;

import java.util.List;

@Data
public class OutputDTOStudentFull extends OutputDTOStudent {
    private OutputDTOPersona persona;
    private int num_hours_week;
    private outputDTOprofesorNC profesor;
    String branch;
}
