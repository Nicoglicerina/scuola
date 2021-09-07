package com.Progetto2.Progetto2.dtoValidator.DTOException;

import java.util.Map;

/**
 * super tipo di tutte le eccezioni dei DTO
 */
public abstract class DtoException extends Exception{
    /**
     * serve a registrare gli errori dell'inserimento dati da parte dell'utente
     */
    public Map<String, String> errors;
    public DtoException(Map<String, String> message) {
        errors=message;
    }

}
