package ant_lab.services;

import ant_lab.respositories.*;
import ant_lab.validator.PersonValidator;

/**
 *la classe context è una classe contenitore che al suo interno raccoglie tutti i metodi del progetto
 */
 public class Context {

    private static Context context;
    public final Store store;
    public final StudentiRepository studentiRepository;
    public final InsegnatiRepository insegnantiRepository;
    public  PersonValidator personValidator;

    private Context()
    {
        store = Store.make();
        studentiRepository= StudentiRepository.make(store);
        insegnantiRepository = InsegnatiRepository.make(store);
        personValidator= personValidator.make(store);

    }

    public static Context getContext()
    {

        if(context==null)
            context= new Context();
        return context;
    }

}
