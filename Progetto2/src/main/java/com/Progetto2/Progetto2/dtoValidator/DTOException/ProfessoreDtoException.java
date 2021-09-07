package com.Progetto2.Progetto2.dtoValidator.DTOException;

import java.util.Map;
/**
 * si occupa di registrare gli errori/eccezioni dell'entità Professore
 */
public class ProfessoreDtoException extends DtoException {
    public ProfessoreDtoException(Map<String, String> message) {
        super(message);
    }
}
