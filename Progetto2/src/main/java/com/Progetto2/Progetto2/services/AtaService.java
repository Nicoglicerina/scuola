package com.Progetto2.Progetto2.services;

import com.Progetto2.Progetto2.data.AtaDTO;
import com.Progetto2.Progetto2.dtoValidator.AtaValidator;
import com.Progetto2.Progetto2.entities.Ata;
import com.Progetto2.Progetto2.repository.AtaRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
/**
 * Questa classe si occupa di interagire con la classe AtaController e AtaRepository
 */
@Service
public class AtaService
{
    final AtaRepository ataRepository;
    final AtaValidator ataValidator;

    public AtaService(AtaRepository ataRepository, AtaValidator ataValidator) {
        this.ataRepository = ataRepository;
        this.ataValidator = ataValidator;
    }

    /**
     * Questo metodo interagisce con la classe AtaRepositpry per poter ricercare una istanza in base all'id
     * @param id
     * @return null
     */
    public Ata findAtaById(Integer id) {
        try {
            return ataRepository.findAtaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe AtaRepositpry in modo tale da estrarre tutte le istanze della
     * classe Ata
     * @return null
     */
    @SneakyThrows
    public List<Ata> findAllA()  {
        try {
            return ataRepository.findAllAta();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe AtaRepositpry in modo tale da eliminare una istanza della classe
     * Ata
     * @param id
     * @return null
     */
    public String deleteRecordA(Integer id)  {
        ataRepository.DeleteAta(id);
        return null;
    }

    /**
     * Questo metodo interagisce con la classe AtaRepositpry in modo tale da creare una nuova istanza della
     * classe Ata
     * @param ataDTO
     * @return null
     */
    @SneakyThrows
    public Ata saveAta(AtaDTO ataDTO)
    {
        ataValidator.isValid(ataDTO);
        try {
            return ataRepository.saveAta(ataDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Questo metodo interagisce con la classe AtaRepositpry in modo tale da aggiornare una istanza della classe
     * Ata
     * @param ataDTO
     * @param id
     * @return null
     */
    @SneakyThrows
    public Ata UpdateAta(AtaDTO ataDTO, Integer id)
    {
        ataValidator.isValid(ataDTO);
        try {
            return ataRepository.UpdateAta(ataDTO, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
