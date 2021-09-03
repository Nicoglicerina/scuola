package com.Progetto2.Progetto2.dtoValidator;

import com.Progetto2.Progetto2.data.PersonaDto;
import com.Progetto2.Progetto2.dtoValidator.DTOException.StudentiDtoException;
import com.Progetto2.Progetto2.entities.Persona;
import org.springframework.stereotype.Component;

@Component
public class StudenteValidator implements DTOvalidator{
    @Override
    public void isValid(PersonaDto personaDto) throws StudentiDtoException
    {

    }
}
