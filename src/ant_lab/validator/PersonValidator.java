package ant_lab.validator;

import Exceptions.NotValidPerson;
import ant_lab.entities.Persona;
import ant_lab.respositories.Store;
/**
 * si occupa di verificare che una determinata istanza non sia già presente all'interno del progetto
 */
public class PersonValidator
{
    private static PersonValidator personValidator;
    private Store store;
    private PersonValidator(Store store)
    {
        this.store=store;
    }
    /**
     * Serve per poter creare una sola istanza di una classe (Singleton)
     */
    public static PersonValidator make(Store store)
    {
        if(personValidator==null)
        personValidator=new PersonValidator(store);
        return personValidator;
    }
    /**
     *serve per verificare se un'isstanza sia già presente all'interno del progetto
     */
    public void IsValidId(Persona persona) throws NotValidPerson {
        if(store.GetPersonaById(persona.getId())!=null)
            throw new NotValidPerson("id già presente");
    }
}
