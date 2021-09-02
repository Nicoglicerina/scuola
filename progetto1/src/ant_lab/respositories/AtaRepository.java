package ant_lab.respositories;


import ant_lab.entities.Persona;

import java.util.List;
/**
 *si occupa di contenere i metodi della classe Ata
 */
public class AtaRepository implements PersonRepositories{
    private Store Store;
    private static AtaRepository ataRepository;
    public AtaRepository(Store store)
    {
        Store = store;
    }

    /**
     * Serve per poter creare una sola istanza di una classe (Singleton)
     */
    public static AtaRepository make(ant_lab.respositories.Store store) {
        if(ataRepository==null)
            ataRepository= new AtaRepository(store);
        return ataRepository;
    }
    @Override
    public Store store() {
        return Store;
    }

    @Override
    public Persona GetPersonaById(int id) {
        return PersonRepositories.super.GetPersonaById(id);
    }

    @Override
    public List<Persona> GetAllPersone() {
        return PersonRepositories.super.GetAllPersone();
    }

    @Override
    public boolean DeletePersona(int id) {
        return PersonRepositories.super.DeletePersona(id);
    }

    @Override
    public boolean UpdatePersona(Persona persona) {
        return false;
    }

    @Override
    public boolean SavePerson(Persona persona) {
        return PersonRepositories.super.SavePerson(persona);
    }
}
