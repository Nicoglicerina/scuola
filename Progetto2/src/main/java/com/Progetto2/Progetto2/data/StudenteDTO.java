package com.Progetto2.Progetto2.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudenteDTO extends PersonaDto
{
    private String Nome;
    private String Cognome;
    private String Dob;
    private String Cittadinaza;
    private double Media;
    private String Materia;
}
