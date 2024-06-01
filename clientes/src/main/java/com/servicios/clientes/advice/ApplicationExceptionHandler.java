package com.servicios.clientes.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.servicios.clientes.exception.ClienteException;


@RestControllerAdvice
public class ApplicationExceptionHandler {
	
    private static String error_const = "error";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClienteException.class)
    public Map<String,String> handleClientException( ClienteException ex ){
    	
        Map<String, String> errors = new HashMap<>();
        errors.put(error_const, ex.getMessage());
        return errors;
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAnyException(Exception ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put(error_const, ex.getMessage());

        return errors;
    }
}
