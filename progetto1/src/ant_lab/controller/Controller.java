package ant_lab.controller;

import ant_lab.entities.Persona;
import ant_lab.factories.PersonFactory;
import ant_lab.respositories.PersonRepositories;
import ant_lab.services.Context;

import java.util.Locale;
import java.util.Scanner;
/**
 * Serve per poter inserire gli input da tastiera
 */
public class Controller {


    public Controller()
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("AZIONI disponibili :\n" +
                    "1) EX (exit) \n"+
                    "2) LP (lista persone) \n"+
                    "3) AP (aggiungi persona) \n"+
                    "4) RM (rimuovi ) id \n"+
                    "5) UP(aggiorna) \n"+
                    "6) FT ATA \n"
            );
            String action= sc.nextLine().trim();
            String  ris = "null";
            try {
                /**
                 * qui ci sono le operazioni che si possono effettuare sulle classi
                 */
                switch (action.split(" ")[0]) {
                    case "EX":
                        System.exit(2);

                    case "LP":
                        System.out.printf(Context.getContext().insegnantiRepository.toString());
                        for (Persona p : Context.getContext().insegnantiRepository.GetAllPersone())
                            System.out.println(p);

                        break;
                    case "AP":
                        try {
                            Persona p = PersonFactory.make(action.split("-")[1].trim());
                            Context.getContext().insegnantiRepository.SavePerson(p);
                            ris = p.toString();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                        break;
                    default:
                        ris = "Non ho capito........";
                        break;
                    case "RM":
                        try {
                            int i = Integer.parseInt(action.split("-")[1].trim());
                            ris = Context.getContext().insegnantiRepository.DeletePersona(i) == true ?
                                    "OK" : "NOT OK";
                        } catch (Exception e) {
                            e.printStackTrace();
                            ris = "Non ho capito........";
                        }
                        break;
                    case "UP":
                        try {
                            Persona p = PersonFactory.make(action.split("-")[1].trim());
                            Context.getContext().insegnantiRepository.UpdatePersona(p);
                            ris = p.toString();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "FT":
                        Context.getContext().studentiRepository.FindByType(action.split("-")[1].trim().toLowerCase(Locale.ROOT));
                        break;
                }
            }catch (ArrayIndexOutOfBoundsException e){ ris = "Non ho capito........";}
            System.out.println(ris);

        }

    }

}