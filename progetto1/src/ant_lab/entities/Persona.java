package ant_lab.entities;
/**
 *classe astratta(classe genitore)
 */
public abstract class Persona{
    public Persona() {
    }
    private String Nome;
    private String Cognome;
    private String Dob;
    private String Cittadinaza;
    int Id;
    /**
     *se esiste gia la persona tornerà false
     */
    public boolean isPresent()
    {

        return false;
    }

    /**
     *
     */

    public Persona(String nome, String cognome, String dob, String cittadinaza, int id) {
        this.Nome = nome;
        Cognome = cognome;
        Dob = dob;
        Cittadinaza = cittadinaza;
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getCittadinaza() {
        return Cittadinaza;
    }

    public void setCittadinaza(String cittadinaza) {
        Cittadinaza = cittadinaza;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName().toString() +":"+ Nome +":"+Cognome +":"+Dob+":"+Cittadinaza+":"+Id+":";
    }
}
