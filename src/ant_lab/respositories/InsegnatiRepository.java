package ant_lab.respositories;

import ant_lab.entities.Persona;
/**
 *si occupa di contenere i metodi della classe Professore
 */
public class InsegnatiRepository implements PersonRepositories{
    private Store Store;
    private static InsegnatiRepository insegnatiRepository;
    public InsegnatiRepository(Store store)
    {
        Store = store;
    }

    /**
     * Serve per poter creare una sola istanza di una classe (Singleton)
     */
    public static InsegnatiRepository make(ant_lab.respositories.Store store) {
    if(insegnatiRepository==null)
        insegnatiRepository= new InsegnatiRepository(store);
    return insegnatiRepository;
    }

    @Override
    public ant_lab.respositories.Store store() {
        return Store;
    }



    @Override
    public boolean UpdatePersona(Persona persona) {
        return false;
    }
}
