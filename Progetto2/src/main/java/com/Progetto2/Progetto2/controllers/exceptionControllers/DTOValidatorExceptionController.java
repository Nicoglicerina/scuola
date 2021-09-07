package com.Progetto2.Progetto2.controllers.exceptionControllers;

import com.Progetto2.Progetto2.dtoValidator.DTOException.DtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * classe che si occupa di gestire una generica eccezione del tipo
 */
@ControllerAdvice
public class DTOValidatorExceptionController
{
    /**
     * immagazzina errori e eccezioni
     * @param dtoException
     * @return ResponseEntity<>
     */
    @ExceptionHandler(value = DtoException.class)
    public ResponseEntity<Map<String, String>> DTOhandeler(DtoException dtoException){
        return  new ResponseEntity<>(dtoException.errors, HttpStatus.BAD_REQUEST);
    }
}
