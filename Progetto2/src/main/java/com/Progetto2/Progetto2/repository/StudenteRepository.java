package com.Progetto2.Progetto2.repository;

import com.Progetto2.Progetto2.converter.StudenteConverter;
import com.Progetto2.Progetto2.data.StudenteDTO;
import com.Progetto2.Progetto2.entities.Studente;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe repository si occupa di interagire con il database tramite metodi e query
 */
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

    /**
     * si occupa di fare una ricerca all'interno del database per estrarre una istanza che abbia un determinato
     * @param id
     * @return studente
     * @throws SQLException
     */
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

    /**
     * si occupa della gestione degli attributi della classe Studente
     * @param studente
     * @param rs
     * @throws SQLException
     */

    private void getStudente(Studente studente, ResultSet rs) throws SQLException {
        studente.setId(rs.getInt("id"));
        studente.setMedia(rs.getInt("media"));
        studente.setMateria(rs.getString("materia"));
        studente.setCittadinaza(rs.getString("cittadinanza"));
        studente.setCognome(rs.getString("cognome"));
        studente.setDob(rs.getString("dob"));
        studente.setNome(rs.getString("nome"));
    }

    /**
     * si occupa di estrarre dal database tutte le istanze della classe Studente
     * @return list
     * @throws SQLException
     */
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

    /**
     * si occupa di eliminare una determinata istanza in base all'id all'interno del database
     * @param id
     */
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

    /**
     * si occupa dell'inserimento all'interno del db di una nuova istanza della classe Studente
     * @param studenteDTO
     * @return
     * @throws SQLException
     */
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

    /**
     * si prepara in precedenza i dati da inserire in modo da stabilire un ordine e avere un maggior controllo sui dati inseriti
     * @param preparedStatement
     * @param studente
     * @return preparedStatement
     * @throws SQLException
     */
    private PreparedStatement preparedStatement (PreparedStatement preparedStatement, Studente studente) throws SQLException {
        //id, nome, cognome, materia, cittadinaza, media,dob
        preparedStatement.setString(1,studente.getNome());
        preparedStatement.setString(2,studente.getCognome());
        preparedStatement.setString(3,studente.getMateria());
        preparedStatement.setString(4,studente.getCittadinaza());
        preparedStatement.setDouble(5,studente.getMedia());
        preparedStatement.setInt(6,studente.getId());
        return preparedStatement;
    }

    /**
     * si occupa di aggiornare i dati di una determinata istanza dell'entita Studente
     * @param studenteDTO
     * @param id
     * @return studente
     * @throws SQLException
     */
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
