package com.example.jpadto.profesor.infraestructure.controller;

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

    @GetMapping("{code}")
    ResponseEntity<OutputDto> callUsingFeign(@PathVariable int code)
    {
        System.out.println("En client. Antes de llamada a server Devolvere: "+code);
        ResponseEntity<OutputDto> respuesta=iFeignServer.callServer(code);
        System.out.println("En client. Despues de llamada a server");
        return respuesta;
    }
    @GetMapping("1/{code}")
    ResponseEntity<OutputDto> callUsingFeignPlusOne(@PathVariable int code)
    {
        System.out.println("En client. Antes de llamada a server Devolvere: "+code);
        ResponseEntity<OutputDto> respuesta=iFeignServer.callServerMas1(code);
        System.out.println("En client. Despues de llamada a server");
        return respuesta;
    }

    @GetMapping("/template/{code}")
    ResponseEntity<OutputDto> callUsingRestTemplate(@PathVariable int code)
    {
        System.out.println("En client Resttemplate. Antes de llamada a server Devolvere: "+code);
        ResponseEntity<OutputDto> rs = new RestTemplate().getForEntity("http://localhost:8080/server/"+code,OutputDto.class);
        System.out.println("En client Resttemplate. Despues de llamada a server");
        return ResponseEntity.ok(rs.getBody());
    }

    @GetMapping("/feign/getProfesor/{id}")
    public ResponseEntity<OutputDTOProfesor> callUsingFeigngetProfesor(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(profesorInterface.getProfesor(id));
    }

}
