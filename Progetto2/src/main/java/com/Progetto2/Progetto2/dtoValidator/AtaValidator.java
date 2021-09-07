package com.Progetto2.Progetto2.dtoValidator;

import com.Progetto2.Progetto2.data.AtaDTO;
import com.Progetto2.Progetto2.data.PersonaDto;
import com.Progetto2.Progetto2.dtoValidator.DTOException.AtaDtoException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class AtaValidator implements DTOvalidator
{
    /**
     * controlla se i dati inseriti dall'utente sono null o vuoti e nel caso restituisce un messaggio di errore
     * @param personaDto
     * @throws AtaDtoException
     */
    @Override
    public void isValid(PersonaDto personaDto) throws AtaDtoException
    {
        Map<String, String> errors = new HashMap<>();
        AtaDTO ataDTO = ((AtaDTO) personaDto);
        if (ataDTO.getNome()==null || ataDTO.getNome().trim().equalsIgnoreCase(""))
            errors.put("nome", "vuoto");
        if (ataDTO.getCittadinaza()==null || ataDTO.getCittadinaza().trim().equalsIgnoreCase(""))
            errors.put("cittadinanza", "vuota");
        if (ataDTO.getCognome()== null || ataDTO.getCognome().trim().equalsIgnoreCase(""))
            errors.put("cognome", "vuoto");
        if (ataDTO.getMansione()== null || ataDTO.getMansione().trim().equalsIgnoreCase(""))
            errors.put("materia", "vuota");
        if (ataDTO.getDob()== null || ataDTO.getDob().trim().equalsIgnoreCase(""))
            errors.put("dob", "vuota");
        if (ataDTO.getStipendio()<=0)
            errors.put("stipendio", "vuota");
        if (errors.size() > 0)
            throw new AtaDtoException(errors);
    }
}
