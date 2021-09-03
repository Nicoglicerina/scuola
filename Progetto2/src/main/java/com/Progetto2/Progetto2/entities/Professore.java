package com.Progetto2.Progetto2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe che rappresenta uno Professore(figlio di persona)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professore extends Persona
{
    private String Materia;
    private double Stipendio;
}
