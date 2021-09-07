package com.Progetto2.Progetto2.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * classe nella quale verranno inseriti i dati inviati dall'utente
 */
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProfessoreDTO extends PersonaDto
{
    private String Nome;
    private String Cognome;
    private String Dob;
    private String Cittadinaza;
    private String Materia;
    private double Stipendio;
}
