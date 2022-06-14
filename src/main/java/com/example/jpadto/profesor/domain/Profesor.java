package com.example.jpadto.profesor.domain;

import com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator;
import com.example.jpadto.persona.domain.Persona;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Table(name = "profesor")
@Entity
public class Profesor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorIdGen")
    @GenericGenerator(
            name = "professorIdGen",
            strategy = "com.example.jpadto.application.stringGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "id_professor", nullable=false)
    private String id_profesor;

    @OneToOne(cascade = CascadeType.ALL)
    private Persona persona;
    @Column(name = "coments")
    private String coments;
    @Column(name = "branch")
    private String branch;

    enum branch {
        BACK,
        FRONT,
        DEVOPS,
        UNASIGNED;
    }
}
