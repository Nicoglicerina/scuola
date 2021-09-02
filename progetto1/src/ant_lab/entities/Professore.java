package ant_lab.entities;
/**
 * Classe che rappresenta uno Professore(figlio di persona)
 */
public class Professore extends Persona
{
    private String Materia;
    private double Stipendio;

    public Professore(String nome, String cognome, String dob, String cittadinaza, int id, String materia, double stipendio) {
        super(nome, cognome, dob, cittadinaza, id);
        Materia = materia;
        Stipendio = stipendio;
    }

    public Professore()
    {

    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public double getStipendio() {
        return Stipendio;
    }

    public void setStipendio(double stipendio) {
        Stipendio = stipendio;
    }

    @Override
    public String toString() {
        return super.toString()+ Materia+":"+ Stipendio ;
    }
}
