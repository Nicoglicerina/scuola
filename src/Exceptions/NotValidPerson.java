package Exceptions;
/**
 *Restituisce un messaggio di errore nel caso l'istanza fosse ggià presente all'interno del progetto
 */
public class NotValidPerson extends Exception
{
    /**
     *Restituisce un messaggio di errore nel caso l'istanza fosse ggià presente all'interno del progetto
     */
    public NotValidPerson(String message)
    {
        super(message);
    }
}
