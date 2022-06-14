package com.example.jpadto.feign;


import com.example.jpadto.feign.dto.OutputDto;
import com.example.jpadto.profesor.application.ProfesorInterface;
import com.example.jpadto.profesor.infraestructure.dto.output.OutputDTOProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class ServerController {

    @Autowired
    ProfesorInterface profesorInterface;

   @GetMapping("/feign/getProfesor/{id}")
    public ResponseEntity<OutputDTOProfesor> callUsingFeigngetProfesor(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(profesorInterface.getProfesor(id));
    }

}