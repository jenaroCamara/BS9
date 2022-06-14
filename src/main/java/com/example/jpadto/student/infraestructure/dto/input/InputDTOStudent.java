package com.example.jpadto.student.infraestructure.dto.input;

import lombok.Data;


@Data
public class InputDTOStudent {
    private int persona;
    private int num_hours_week;
    private String profesor;
    String branch;
}
