package com.example.jpadto.customError;

import com.example.jpadto.exceptions.BeanNotFoundException;
import com.example.jpadto.customError.CustomError;
import com.example.jpadto.exceptions.UnprocesableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BeanNotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(BeanNotFoundException ex, WebRequest request) {
        CustomError exceptionResponse = new CustomError(new Date(), "Error ", HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError> handleUnprocesableException(BeanNotFoundException ex, WebRequest request) {
        CustomError exceptionResponse = new CustomError(new Date(), "Error ", HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
