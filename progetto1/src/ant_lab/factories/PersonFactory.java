package ant_lab.factories;

import ant_lab.entities.Ata;
import ant_lab.entities.Persona;
import ant_lab.entities.Professore;
import ant_lab.entities.Studente;

/**
 * Serve per inserire una istanza nello store a partire da una stringa di input
 */
public class PersonFactory
{
    /**
     * Questa funzione permette di creare un istanza di una classe a partire da una stringa(singleton)
     */
    public static Persona make(String line)
    {
        String [] Lines= line.split(":");
        System.out.println(Lines.length);
        Persona persona= null;
        String [] switcher=Lines[0].split("\\.");
        switch (switcher[switcher.length-1]){
            case "Studente":
                persona = new Studente(
                        Lines[1],
                        Lines[2],
                        Lines[3],
                        Lines[4],
                        Integer.parseInt(Lines[5]),
                        Double.parseDouble(Lines[6]),
                        Lines[7]
                );
                break;
            case "Professore":
                persona = new Professore(
                        Lines[1],
                        Lines[2],
                        Lines[3],
                        Lines[4],
                        Integer.parseInt(Lines[5]),
                        Lines[6],
                        Double.parseDouble(Lines[7])
                );
                break;
            case "Ata":
                persona = new Ata(
                        Lines[1],
                        Lines[2],
                        Lines[3],
                        Lines[4],
                        Integer.parseInt(Lines[5]),
                        Lines[6]
                );
                break;
        }
        return persona;
    }
}
