package com.Progetto2.Progetto2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *classe astratta(classe genitore)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona{
    private String Nome;
    private String Cognome;
    private String Dob;
    private String Cittadinaza;
    int Id;
}
