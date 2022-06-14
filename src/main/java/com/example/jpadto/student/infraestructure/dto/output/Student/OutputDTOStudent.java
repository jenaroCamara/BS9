package com.example.jpadto.student.infraestructure.dto.output.Student;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OutputDTOStudent {
    @NotNull
    String id_student;
}
