package com.Progetto2.Progetto2.repository;

import com.Progetto2.Progetto2.converter.StudenteConverter;
import com.Progetto2.Progetto2.data.StudenteDTO;
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
    String findMaxId="select max(id) as id from studente";
    String insertQuery="insert into studente (nome, cognome, materia, cittadinanza, media,dob,id) values (?,?,?,?,?,?,?)";
    String update= "update studente set nome= ?, cognome= ? , materia= ?, cittadinanza= ? , media= ? , dob= ? where id = ?";
    final DataSource dataSource;
    final StudenteConverter studenteConverter;
    public StudenteRepository(DataSource dataSource, StudenteConverter studenteConverter) {
        this.dataSource = dataSource;
        this.studenteConverter = studenteConverter;
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
        st.close();
        rs.close();
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
        st.close();
        rs.close();
        c.close();
        return list;
    }

    public void DeleteStudente(Integer id) {
        try {
            Connection c = dataSource.getConnection();
            PreparedStatement st = c.prepareStatement(deleteQuery + id);
            st.executeUpdate();
            st.close();
            c.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Studente saveStudente(StudenteDTO studenteDTO) throws SQLException {
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(findMaxId);
        Integer id=0;
        while(rs.next())
        {
            id=rs.getInt("id");
            break;
        }
        id++;
        Studente studente=studenteConverter.studenteDTOconverter(studenteDTO,id);
        rs.close();
        st.close();

        PreparedStatement ps = c.prepareStatement(insertQuery);
        ps=preparedStatement(ps,studente);
        ps.executeUpdate();
        ps.close();
        c.close();
        return studente;
    }


    private PreparedStatement preparedStatement (PreparedStatement preparedStatement, Studente studente) throws SQLException {
        //id, nome, cognome, materia, cittadinaza, media,dob
        preparedStatement.setString(1,studente.getNome());
        preparedStatement.setString(2,studente.getCognome());
        preparedStatement.setString(3,studente.getMateria());
        preparedStatement.setString(4,studente.getCittadinaza());
        preparedStatement.setDouble(5,studente.getMedia());
        preparedStatement.setString(6,studente.getMateria());
        preparedStatement.setInt(7,studente.getId());
        return preparedStatement;
    }
    public Studente UpdateStudente(StudenteDTO studenteDTO, Integer id) throws SQLException {
        Connection c=dataSource.getConnection();
        Studente studente=studenteConverter.studenteDTOconverter(studenteDTO,id);
        PreparedStatement ps = c.prepareStatement(update);
        ps=preparedStatement(ps,studente);
        ps.executeUpdate();
        ps.close();
        c.close();
        return studente;
    }
}
