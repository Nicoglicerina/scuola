package com.Progetto2.Progetto2.services;
import com.Progetto2.Progetto2.data.ProfessoreDTO;
import com.Progetto2.Progetto2.dtoValidator.ProfessoreValidator;
import com.Progetto2.Progetto2.entities.Professore;
import lombok.SneakyThrows;
import com.Progetto2.Progetto2.repository.ProfessoreRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
/**
 * Questa classe si occupa di interagire con la classe ProfessoreController e ProfessoreRepository
 */
@Service
public class ProfessoreService
{
    final ProfessoreRepository professoreRepository;
    final ProfessoreValidator professoreValidator;

    public ProfessoreService(ProfessoreRepository professoreRepository, ProfessoreValidator professoreValidator) {
        this.professoreRepository = professoreRepository;
        this.professoreValidator = professoreValidator;
    }

    /**
     * Questo metodo interagisce con la classe ProfessoreRepositpry per poter ricercare una istanza in base all'id
     * @param id
     * @return null
     */
    public Professore findProfessoreById(Integer id) {
        try {
            return professoreRepository.findProfessoreById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe ProfessoreRepositpry in modo tale da estrarre tutte le istanze della
     * classe Professore
     * @return null
     */
    @SneakyThrows
    public List<Professore> findAllP()  {
        try {
            return professoreRepository.findAllProfessore();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe ProfessoreRepositpry in modo tale da eliminare una istanza della classe
     * Professore
     * @param id
     * @return null
     */
    public String deleteRecordP(Integer id)  {
        professoreRepository.DeleteProfessore(id);
        return null;
    }

    /**
     * Questo metodo interagisce con la classe ProfessoreRepositpry in modo tale da creare una nuova istanza della
     * classe Professore
     * @param professoreDTO
     * @return null
     */
    @SneakyThrows
    public Professore saveProfessore(ProfessoreDTO professoreDTO)
    {
        professoreValidator.isValid(professoreDTO);
        try {
            return professoreRepository.saveProfessore(professoreDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Questo metodo interagisce con la classe ProfessoreRepositpry in modo tale da aggiornare una istanza della classe
     * Professore
     * @return null
     */
    @SneakyThrows
    public Professore UpdateProfessore(ProfessoreDTO professoreDTO, Integer id)
    {
        professoreValidator.isValid(professoreDTO);
        try {
            return professoreRepository.UpdateProfessore(professoreDTO, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
