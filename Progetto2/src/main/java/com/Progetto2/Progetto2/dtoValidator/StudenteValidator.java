package com.Progetto2.Progetto2.dtoValidator;

import com.Progetto2.Progetto2.data.PersonaDto;
import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.dtoValidator.DTOException.StudentiDtoException;
import com.Progetto2.Progetto2.entities.Persona;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * si occupa di convalidare i dati inseriti dall'utente della classe Studente
 */
@Component
public class StudenteValidator implements DTOvalidator{
    /**
     * controlla se i dati inseriti dall'utente sono null o vuoti e nel caso restituisce un messaggio di errore
     * @param personaDto
     * @throws StudentiDtoException
     */
    @Override
    public void isValid(PersonaDto personaDto) throws StudentiDtoException {
        Map<String, String> errors = new HashMap<>();
        StudenteDTO studenteDTO = ((StudenteDTO) personaDto);
        if (studenteDTO.getNome()==null || studenteDTO.getNome().trim().equalsIgnoreCase(""))
            errors.put("nome", "vuoto");
        if (studenteDTO.getCittadinaza()==null || studenteDTO.getCittadinaza().trim().equalsIgnoreCase(""))
            errors.put("cittadinanza", "vuota");
        if (studenteDTO.getCognome()== null || studenteDTO.getCognome().trim().equalsIgnoreCase(""))
            errors.put("cognome", "vuoto");
        if (studenteDTO.getMedia()<=0)
            errors.put("media", "vuota");
        if (studenteDTO.getMateria()== null || studenteDTO.getMateria().trim().equalsIgnoreCase(""))
            errors.put("materia", "vuota");
        if (studenteDTO.getDob()== null || studenteDTO.getDob().trim().equalsIgnoreCase(""))
            errors.put("dob", "vuota");
        if (errors.size() > 0)
            throw new StudentiDtoException(errors);
    }
    }