package com.example.jpadto.customError;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomError {
    Date timestamp;
    int HttpCode;
    String mensaje; // Devolverá el mensaje de error.

    public CustomError(Date timestamp, String message, int HttpCode) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;
        this.HttpCode = HttpCode;
    }
}
