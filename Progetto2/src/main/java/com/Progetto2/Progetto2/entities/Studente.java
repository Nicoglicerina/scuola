package com.Progetto2.Progetto2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta uno Studente (figlio di persona)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Studente extends Persona{
    private double Media;
    private String Materia;
}
