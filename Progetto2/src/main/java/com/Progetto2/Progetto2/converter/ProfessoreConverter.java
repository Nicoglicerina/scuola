package com.Progetto2.Progetto2.converter;

import com.Progetto2.Progetto2.data.ProfessoreDTO;
import com.Progetto2.Progetto2.dtoValidator.ProfessoreValidator;
import com.Progetto2.Progetto2.entities.Professore;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
/**
 * Classe che si occupa di convertire i dati inviati dall'utente e inseriti in ProfessoreDTO in entità di tipo Professore
 */
@Component
public class ProfessoreConverter
{
    final ProfessoreValidator professoreValidator;

    public ProfessoreConverter(ProfessoreValidator professoreValidator) {
        this.professoreValidator = professoreValidator;
    }

    /**
     * prende i dati inseriti dall'utente dalla classe ProfessoreDTO e crea una nuova istanza dell'entità Professore
     * inserendo così i dati
     * @param professoreDTO
     * @param ID
     * @return professore
     */
    @SneakyThrows
        public Professore professoreDTOConverter(ProfessoreDTO professoreDTO, Integer ID)
        {
            professoreValidator.isValid(professoreDTO);
            Professore professore = new Professore();
            professore.setId(ID);
            professore.setCittadinaza(professoreDTO.getCittadinaza());
            professore.setMateria(professoreDTO.getMateria());
            professore.setDob(professoreDTO.getDob());
            professore.setCognome(professoreDTO.getCognome());
            professore.setNome(professoreDTO.getNome());
            return professore;
        }
    }