package com.Progetto2.Progetto2.dtoValidator;

import com.Progetto2.Progetto2.data.PersonaDto;
import com.Progetto2.Progetto2.data.ProfessoreDTO;
import com.Progetto2.Progetto2.dtoValidator.DTOException.ProfessoreDtoException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * classe che si occupa di verificare se i dati inseriti dall'utente siano null oppure vuoti restituendo un messaggio di
 * errore al fine di inserire i dati correttamente nella entità Professore
 */
@Component
public class ProfessoreValidator implements DTOvalidator
{
    /**
     * controlla se i dati inseriti dall'utente sono null o vuoti e nel caso restituisce un messaggio di errore
     * @param personaDto
     * @throws ProfessoreDtoException
     */
    @Override
    public void isValid(PersonaDto personaDto) throws ProfessoreDtoException
    {
        Map<String, String> errors = new HashMap<>();
        ProfessoreDTO professoreDTO = ((ProfessoreDTO) personaDto);
        if (professoreDTO.getNome()==null || professoreDTO.getNome().trim().equalsIgnoreCase(""))
            errors.put("nome", "vuoto");
        if (professoreDTO.getCittadinaza()==null || professoreDTO.getCittadinaza().trim().equalsIgnoreCase(""))
            errors.put("cittadinanza", "vuota");
        if (professoreDTO.getCognome()== null || professoreDTO.getCognome().trim().equalsIgnoreCase(""))
            errors.put("cognome", "vuoto");
        if (professoreDTO.getMateria()== null || professoreDTO.getMateria().trim().equalsIgnoreCase(""))
            errors.put("materia", "vuota");
        if (professoreDTO.getDob()== null || professoreDTO.getDob().trim().equalsIgnoreCase(""))
            errors.put("dob", "vuota");
        if (professoreDTO.getStipendio()<=0)
            errors.put("stipendio", "vuoto");
        if (errors.size() > 0)
            throw new ProfessoreDtoException(errors);
    }
}
