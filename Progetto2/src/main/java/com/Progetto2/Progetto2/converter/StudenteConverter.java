package com.Progetto2.Progetto2.converter;

import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.dtoValidator.StudenteValidator;
import com.Progetto2.Progetto2.entities.Studente;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class StudenteConverter {
    final StudenteValidator studenteValidator;

    public StudenteConverter(StudenteValidator studenteValidator) {
        this.studenteValidator = studenteValidator;
    }
    @SneakyThrows
    public Studente studenteDTOconverter(StudenteDTO studenteDTO, Integer ID)
    {
        studenteValidator.isValid(studenteDTO);
        Studente studente = new Studente();
        studente.setId(ID);
        studente.setMedia(studenteDTO.getMedia());
        studente.setCittadinaza(studenteDTO.getCittadinaza());
        studente.setMateria(studenteDTO.getMateria());
        studente.setDob(studenteDTO.getDob());
        studente.setCognome(studenteDTO.getCognome());
        studente.setNome(studenteDTO.getNome());
        return studente;
    }
}
