package com.Progetto2.Progetto2.converter;

import com.Progetto2.Progetto2.data.AtaDTO;
import com.Progetto2.Progetto2.dtoValidator.AtaValidator;
import com.Progetto2.Progetto2.entities.Ata;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * Classe che si occupa di convertire i dati inviati dall'utente e inseriti in AtaDTO in entità di tipo Ata
 */
@Component
public class AtaConverter
{
    final AtaValidator ataValidator;

    public AtaConverter(AtaValidator ataValidator) {
        this.ataValidator = ataValidator;
    }

    /**
     * prende i dati inseriti dall'utente dalla classe AtaDTO e crea una nuova istanza dell'entità Ata
     * inserendo così i dati
     * @param ataDTO
     * @param ID
     * @return ata
     */
    @SneakyThrows
    public Ata ataDTOConverter(AtaDTO ataDTO, Integer ID)
    {
        ataValidator.isValid(ataDTO);
        Ata ata = new Ata();
        ata.setId(ID);
        ata.setCittadinaza(ataDTO.getCittadinaza());
        ata.setMansione(ataDTO.getMansione());
        ata.setDob(ataDTO.getDob());
        ata.setCognome(ataDTO.getCognome());
        ata.setNome(ataDTO.getNome());
        return ata;
    }
}

