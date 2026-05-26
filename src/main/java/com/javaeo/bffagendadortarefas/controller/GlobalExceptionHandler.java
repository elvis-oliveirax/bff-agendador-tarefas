package com.javaeo.bffagendadortarefas.controller;

<<<<<<< HEAD
import com.javaeo.usuario.infrastructure.exeptions.ConflictException;
import com.javaeo.usuario.infrastructure.exeptions.RescoucerNotFoundException;
import com.javaeo.usuario.infrastructure.exeptions.UnauthorizedException;
=======

import com.javaeo.bffagendadortarefas.infrastructure.exeptions.ConflictException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.RescoucerNotFoundException;
import com.javaeo.bffagendadortarefas.infrastructure.exeptions.UnauthorizedException;
>>>>>>> 89dc9c4d52af6dfa9174a4fcf566054523de6b5a
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RescoucerNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(RescoucerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}


