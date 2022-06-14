package com.example.jpadto.persona.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class InputDTOPersona {
    int id;
    @NotBlank(message = "usuario No puede estar vacio")
    String usuario;
    String profesor;
    String estudiante;
    @NotBlank(message = "name No puede estar vacio")
    String name;
    @NotBlank(message = "password No puede estar vacio")
    String password;
    @NotBlank(message = "surname No puede estar vacio")
    String surname;
    @NotBlank(message = "company-email No puede estar vacio")
    String company_email;
    @NotBlank(message = "personal_email No puede estar vacio")
    String personal_email;
    @NotBlank(message = "city No puede estar vacio")
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
