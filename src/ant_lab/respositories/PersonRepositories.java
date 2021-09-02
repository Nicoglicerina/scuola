package ant_lab.respositories;

import ant_lab.entities.Persona;
import ant_lab.entities.Professore;

import java.util.List;
/**
 *contiene tutti i metodi della classe astratta Persona
 */
public interface PersonRepositories {

    /**
     *dichiarazione
     */
    Store store ();
    /**
     *restituisce l'istanza di una classe tramite il sui identificatore univoco (id)
     */
    default  Persona GetPersonaById(int id)
    {
        return    store().GetPersonaById(id);
    }
    /**
     *restituisce una lista di stringhe con al suo interno le istanze richieste
     */
    default List<Persona> GetAllPersone()
    {
        return store().getPersonaList();
    }
    /**
     *in base all'id si va a indicare quale istanza bisogna cancellare
     */

    default boolean DeletePersona(int id)
    {
        return false;
    }
    /**
     *si aggiornano i dati di una istanza
     */
    default boolean UpdatePersona(Persona persona)
    {
        if (persona instanceof Professore)
        {
            ((Professore)persona).getMateria();
        }
        return store().UpdatePerson(persona);
    }

    /**
     * Salva l'istanza della classe nello store
     */
    default  boolean SavePerson(Persona persona)
    {
        return store().SavePerson(persona);
    }

    /**
     * trova le istanze delle classi in base al tipo
     */
    default void FindByType(String toLowerCase)
    {
        store().FindByType(toLowerCase);
    }
}
