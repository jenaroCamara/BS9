package com.example.jpadto.persona.infraestructure.dto.output;

import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.profesor.infraestructure.dto.output.outputDTOprofesorNC;
import com.example.jpadto.student.infraestructure.dto.output.Student.OutputDTOStudentNC;
import lombok.Data;

import java.util.Date;

@Data
public class outputDTOpersonafull extends OutputDTOPersona {
    int id;
    outputDTOprofesorNC profesor;
    OutputDTOStudentNC estudiante;
    String usuario;
    String name;
    String password;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
