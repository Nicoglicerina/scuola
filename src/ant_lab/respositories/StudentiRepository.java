package ant_lab.respositories;

import ant_lab.entities.Persona;
/**
 *si occupa di contenere i metodi della classe Studente
 */
public class StudentiRepository implements PersonRepositories {

    @Override
    public ant_lab.respositories.Store store() {
        return Store;
    }

    private static StudentiRepository studentiRepository;
    private Store Store;
    public StudentiRepository(Store store)
    {
        Store = store;
    }
    /**
     * Serve per poter creare una sola istanza di una classe (Singleton)
     */
    public static StudentiRepository make(Store store)
    {
        if(studentiRepository ==null)
            studentiRepository= new StudentiRepository(store);
        return  studentiRepository;
    }

    public static StudentiRepository getStudentiRepository() {
        return studentiRepository;
    }


    @Override
    public boolean UpdatePersona(Persona persona) {
        return false;
    }
}
