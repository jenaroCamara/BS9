package com.example.jpadto.student.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import com.example.jpadto.profesor.domain.Profesor;
import com.example.jpadto.persona.domain.Persona;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGen")
    @GenericGenerator(
            name = "studentIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "EST"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id_student;
    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;
    @Column (name = "num_hours_week")
    @NotNull
    private int num_hours_week;
    @OneToOne (cascade = CascadeType.ALL)//, fetch = FetchType.LAZY)
    private Profesor profesor;
    @Column (name = "branch")
    @NotNull
    String branch;
}