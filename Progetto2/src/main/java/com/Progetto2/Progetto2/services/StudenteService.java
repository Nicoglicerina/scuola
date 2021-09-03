package com.Progetto2.Progetto2.services;

import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.entities.Studente;
import org.springframework.stereotype.Service;
import com.Progetto2.Progetto2.repository.StudenteRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudenteService {
    final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public Studente findStudenteById(Integer id) {
        try {
            return studenteRepository.findStudenteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Studente> findAll()  {
        try {
            return studenteRepository.findAllStudente();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String deleteRecord(Integer id)  {
        studenteRepository.DeleteStudente(id);
        return null;
    }

    public Studente saveStudente(StudenteDTO studenteDTO)
    {
        try {
            return studenteRepository.saveStudente(studenteDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Studente UpdateStudente(StudenteDTO studenteDTO, Integer id)
    {
        try {
            return studenteRepository.UpdateStudente(studenteDTO, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
