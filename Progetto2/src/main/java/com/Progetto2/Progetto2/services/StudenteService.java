package com.Progetto2.Progetto2.services;

import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.dtoValidator.StudenteValidator;
import com.Progetto2.Progetto2.entities.Studente;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.Progetto2.Progetto2.repository.StudenteRepository;

import java.sql.SQLException;
import java.util.List;
/**
 * Questa classe si occupa di interagire con la classe StudenteController e StudenteRepository
 */
@Service
public class StudenteService {
    final StudenteRepository studenteRepository;
    final StudenteValidator studenteValidator;
    public StudenteService(StudenteRepository studenteRepository, StudenteValidator studenteValidator) {
        this.studenteRepository = studenteRepository;
        this.studenteValidator = studenteValidator;
    }

    /**
     * Questo metodo interagisce con la classe StudenteRepositpry per poter ricercare una istanza in base all'id
     * @param id
     * @return null
     */
    public Studente findStudenteById(Integer id) {
        try {
            return studenteRepository.findStudenteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe StudenteRepositpry in modo tale da estrarre tutte le istanze della classe
     * Studente
     * @return null
     */
    public List<Studente> findAllS()  {
        try {
            return studenteRepository.findAllStudente();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Questo metodo interagisce con la classe StudenteRepositpry in modo tale da eliminare una istanza della classe
     * Studente
     * @param id
     * @return null
     */
    public String deleteRecordS(Integer id)  {
        studenteRepository.DeleteStudente(id);
        return null;
    }

    /**
     * Questo metodo interagisce con la classe StudenteRepositpry in modo tale da creare una nuova istanza della classe
     * Studente
     * @param studenteDTO
     * @return null
     */
    @SneakyThrows
    public Studente saveStudente(StudenteDTO studenteDTO)
    {
         studenteValidator.isValid(studenteDTO);
        try {
            return studenteRepository.saveStudente(studenteDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Questo metodo interagisce con la classe StudenteRepositpry in modo tale da aggiornare una istanza della classe
     * Studente
     * @param studenteDTO
     * @param id
     * @return null
     */
    @SneakyThrows
    public Studente UpdateStudente(StudenteDTO studenteDTO, Integer id)
    {
        studenteValidator.isValid(studenteDTO);
        try {
            return studenteRepository.UpdateStudente(studenteDTO, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
