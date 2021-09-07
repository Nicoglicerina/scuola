package com.Progetto2.Progetto2.dtoValidator;

import com.Progetto2.Progetto2.data.PersonaDto;

/**
 * insertfaccia di tutte le classi DTO che si occupano di convalidare se i dati inseriti dall'utente siano corretti
 */
public interface DTOvalidator
{
    /**
     * controlla se i dati inseriti dall'utente sono null o vuoti e nel caso restituisce un messaggio di errore
     * @param personaDto
     * @throws Exception
     */
    public void isValid(PersonaDto personaDto) throws Exception;
}
