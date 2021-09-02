package ant_lab.services;

import ant_lab.entities.Persona;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * contiene i servizzi per la manipolazione e la gestione delle istanze
 */
public class Fileservices
{
    private String FileName="persone.csv";
    /**
     *si occupa di leggere ogni carattere di un file
     */
    public List<String> readAllLine() throws IOException {
        return Files.readAllLines(Path.of(FileName));
    }
    /**
     *si occupa della gestione e dell'inserimento delle isatanze
     */
    public boolean savePersona(Persona p) throws IOException {
        List<String> s = Files.readAllLines(Path.of(FileName));
        s.add(p.toString());
        Files.write(Path.of(FileName), s);
        return true;
    }
    /**
     *si occupa di eliminare l'istanza considerata
     */
    public void deletePersona(int index) throws IOException
    {
        List<String> a= Files.readAllLines(Path.of(FileName));
        a.remove(index);
        Files.write(Path.of(FileName), a);
    }
    /**
     *aggiorna i dati relativi all'istanza che stiamo considerando
     */
    public boolean UpdatePerson(Persona persona, int index) throws IOException {
        List<String> a= Files.readAllLines(Path.of(FileName));
        a.remove(index);
        a.add(persona.toString());
        Files.write(Path.of(FileName), a);
        return true;
    }
}
