package com.example.jpadto.persona.infraestructure.controller;

import com.example.jpadto.application.UsuarioServicioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Delete")
public class DeletePersonaControlador {

    @Autowired
    private UsuarioServicioInterface usuarioServicio;

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        usuarioServicio.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("");

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
