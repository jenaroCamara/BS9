package com.example.jpadto.persona.domain;

import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    int id;
    //para chequear con mayor facilidad si una persona es estudiante o profesor
    //la asociaremos con una relacion
    @OneToOne(fetch = FetchType.LAZY)
    Profesor profesor;
    @OneToOne(fetch = FetchType.LAZY)//el tipo lazy, indica que no cargaremos al estudiante cuando se cree.
    Student estudiante;
    @NotBlank(message = "usuario No puede estar vacio")
    String usuario;
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
    @NotBlank(message = "imagen-url No puede estar vacio")
    String imagen_url;
    Date termination_date;
}
