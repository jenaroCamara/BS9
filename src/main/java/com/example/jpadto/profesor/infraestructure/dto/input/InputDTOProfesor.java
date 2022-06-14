package com.example.jpadto.profesor.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InputDTOProfesor {
    private int id_profesor;
    @NotNull
    private String persona;
    @NotNull
    private String coments;
    @NotNull
    private String branch;
}
