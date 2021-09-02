package ant_lab.entities;

/**
 * Classe che rappresenta uno Studente (figlio di persona)
 */
public class Studente extends Persona{
    private double Media;
    private String Materia;

    public Studente(String nome, String cognome, String dob, String cittadinaza, int id, double media, String materia) {
        super(nome, cognome, dob, cittadinaza, id);
        Media = media;
        Materia = materia;
    }
    public Studente()
    {

    }


    public double getMedia() {
        return Media;
    }

    public void setMedia(double media) {
        Media = media;
    }

    public String getMateria() {
        return Materia;
    }

    /**
     * materia da impostare
     */
    public void setMateria(String materia) {
        Materia = materia;
    }

    @Override
    public String toString() {
        return super.toString()  +Media +":"+Materia ;
    }
}
