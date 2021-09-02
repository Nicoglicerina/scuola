package ant_lab.respositories;

import ant_lab.entities.Ata;
import ant_lab.entities.Persona;
import ant_lab.entities.Professore;
import ant_lab.entities.Studente;
import ant_lab.factories.PersonFactory;
import ant_lab.services.Context;
import ant_lab.services.Fileservices;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Carica i dati dal file
 */
public class Store {

    private Fileservices fileservices= new Fileservices();
    //il singleton è l'oggetto Store
     private  List<Persona> personaList;
    //la lista è un metodo del singleton
    static Store store;

    private Store()
    {
        personaList= new ArrayList<>();
        try{
            for(String i: fileservices.readAllLine())
            {
                personaList.add(PersonFactory.make(i));
            }
        fileservices.readAllLine();
    }catch (Exception e){
        e.printStackTrace();
        }
    }
    /**
     * Serve per poter creare una sola istanza di una classe (Singleton)
     */
    public static Store make()
    {
        System.out.println("==============================================");
        if (store==null)
        {
            System.out.println("CREO LO STORE");
            store = new Store();

        }
        System.out.println("ritorna store");
        return store;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }
    /**
     * serve per restituire il valore dell'id di una istanza
     */
    public Persona GetPersonaById (int id)
    {
       for(Persona p: personaList)
       {
           if(p.getId()==id)
               return p;
       }
       return null;
    }
    /**
     *salva una istanza nello store
     */
    public boolean SavePerson(Persona persona)
    {
        try
        {
            Context.getContext().personValidator.IsValidId(persona);
            fileservices.savePersona(persona);
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }
        this.personaList.add(persona);
        return true;
    }
    /**
     *rimuove una istanza a nostra scelta dallo store
     */
    public boolean removePerson (int id)
    {
        boolean deleted=false;
        int index=0;
        for(Persona p: personaList)
        {
            if(p.getId()==id)
            {
                try
                {
                    fileservices.deletePersona(index);
                    deleted= true;
                }catch (Exception e){e.printStackTrace();}
            }
            index++;
        }
        return deleted;
    }
    /**
     *modifica le caratteristiche di una determminata istanza a nostra scelta
     */
    public boolean UpdatePerson(Persona persona) {
        int index=0;
        for (Persona p:personaList
             ) {
            if(p.getId()==persona.getId())
            {
                personaList.remove(index);
                personaList.add(persona);
                try
                {
                    return fileservices.UpdatePerson(persona, index);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            index++;
        }
        return false;
    }
    /**
     *questa funzione restituisce il tipo di istanza che stiamo considerando
     */
    public void FindByType(String toLowerCase)
    {
        switch (toLowerCase)
        {
            case "studente":
                for (Persona p:personaList)
                {
                    if (p instanceof Studente)
                        System.out.println(p);
                }
                break;
            case "ata":
                for (Persona p:personaList)
                {
                    if(p instanceof Ata)
                        System.out.println(p);
                }
                break;
            case "professore":
                for (Persona p:personaList)
                {
                    if (p instanceof Professore)
                        System.out.println(p);
                }
                break;
        }
    }
}
