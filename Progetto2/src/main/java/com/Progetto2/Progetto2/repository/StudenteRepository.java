package com.Progetto2.Progetto2.repository;

import com.Progetto2.Progetto2.entities.Studente;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudenteRepository
{
    String idQuery="select * from studente where id=";
    String selectQuery = "select * from studente";
    String deleteQuery="delete from studente where id=";
    final DataSource dataSource;

    public StudenteRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Studente findStudenteById(Integer id) throws SQLException {
        Studente studente=null;
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(idQuery + id);
        while (rs.next()) {
            studente = new Studente();
            getStudente(studente, rs);
        }
        c.close();
        return studente;
    }

    private void getStudente(Studente studente, ResultSet rs) throws SQLException {
        studente.setId(rs.getInt("id"));
        studente.setMedia(rs.getInt("media"));
        studente.setMateria(rs.getString("materia"));
        studente.setCittadinaza(rs.getString("cittadinanza"));
        studente.setCognome(rs.getString("cognome"));
        studente.setDob(rs.getString("dob"));
        studente.setNome(rs.getString("nome"));
    }

    public List<Studente> findAllStudente() throws SQLException
    {
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery( selectQuery);
        List<Studente> list=new ArrayList<>();
        while (rs.next()) {
            Studente studente = new Studente();
            getStudente(studente, rs);
            list.add(studente);
        }
        c.close();
        return list;
    }

    public Studente UpdateStudente(Studente studente)
    {

        return null;
    }
    public Studente InsertStudente(Studente studente)
    {
        //TODO aspettami
        return null;
    }

    public void DeleteStudente(Integer id) {
        try {
            Connection c = dataSource.getConnection();
            PreparedStatement st = c.prepareStatement(deleteQuery + id);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
