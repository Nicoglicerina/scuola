package com.Progetto2.Progetto2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ata è una classe che eredita le caratteristiche di Persona(figlio di Persona)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ata extends Persona{
    private String Mansione;

}
