package ant_lab.entities;
/**
 * Ata è una classe che eredita le caratteristiche di Persona(figlio di Persona)
 */
public class Ata extends Persona{
    private String Mansione;
    //costruttore
    public Ata(String nome, String cognome, String dob, String cittadinaza, int id, String mansione) {
        super(nome, cognome, dob, cittadinaza, id);
        Mansione = mansione;
    }

    public Ata()
    {

    }

    /**
     * come risultato ha la mansione dell'istanza Ata
     */
    public String getMansione() {
        return Mansione;
    }
    /**
     *va a  impostare la mansione dell'istanza Ata
     */
    public void setMansione(String mansione) {
        Mansione = mansione;
    }

    @Override
    public String toString() {
        return  super.toString() + Mansione ;
    }
}
