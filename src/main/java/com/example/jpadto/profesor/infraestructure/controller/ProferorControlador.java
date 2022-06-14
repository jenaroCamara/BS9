package com.example.jpadto.profesor.infraestructure.controller;

import com.example.jpadto.exceptions.UnprocesableException;
import com.example.jpadto.feign.IFeignServer;
import com.example.jpadto.feign.dto.OutputDto;
import com.example.jpadto.profesor.application.ProfesorInterface;
import com.example.jpadto.profesor.infraestructure.dto.input.InputDTOProfesor;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import com.example.jpadto.application.UsuarioServicioInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/Profesor")
public class ProferorControlador {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProfesorInterface profesorInterface;
    @Autowired
    IFeignServer iFeignServer;

    @PostMapping("/anadirProfesor")
    public ResponseEntity<OutputDTOProfesor> anadirProfesor(@RequestBody @Valid InputDTOProfesor DTOprofesor) throws Exception {
        OutputDTOProfesor profesor = profesorInterface.guardarProfesor(DTOprofesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(profesor);
    }

    @GetMapping("/getProfesor/{id}")
    public ResponseEntity<OutputDTOProfesor> getProfesor(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(profesorInterface.getProfesor(id));
    }

    /*--------------------IFeign------------------------*/

    @GetMapping("/template/{code}")
    ResponseEntity<OutputDTOProfesor> callUsingRestTemplate(@PathVariable int code)
    {
        ResponseEntity<OutputDTOProfesor> rs = new RestTemplate().getForEntity("http://localhost:8081/server/feign/getProfesor/"+code,OutputDTOProfesor.class);
        if (rs.getStatusCode() != HttpStatus.OK){
            throw new UnprocesableException("No existe");
        }
        return ResponseEntity.ok(rs.getBody());
    }

    @GetMapping("/feign/getProfesor/{id}")
    public ResponseEntity<OutputDTOProfesor> callUsingFeigngetProfesor(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(profesorInterface.getProfesor(id));
    }

}
