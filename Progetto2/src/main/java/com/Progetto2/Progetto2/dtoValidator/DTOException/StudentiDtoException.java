package com.Progetto2.Progetto2.dtoValidator.DTOException;

import java.util.Map;

/**
 * si occupa di registrare gli errori/eccezioni dell'entità Studente
 */
public class StudentiDtoException extends DtoException {

    public StudentiDtoException(Map<String, String> message) {
        super(message);
    }

}
