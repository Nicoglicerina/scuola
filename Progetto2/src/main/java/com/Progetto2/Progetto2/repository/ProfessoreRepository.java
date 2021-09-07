package com.Progetto2.Progetto2.repository;
import com.Progetto2.Progetto2.converter.ProfessoreConverter;
import com.Progetto2.Progetto2.data.ProfessoreDTO;
import com.Progetto2.Progetto2.entities.Professore;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe repository si occupa di interagire con il database tramite metodi e query
 */
@Repository
public class ProfessoreRepository {
    String idQuery="select * from professore where id=";
    String selectQuery = "select * from professore";
    String deleteQuery="delete from professore where id=";
    String findMaxId="select max(id) as id from studente";
    String insertQuery="insert into professore(nome, cognome, dob, cittadinanza,materia,stipendio) values (?,?,?,?,?,?)";
    String update= "update studente set nome= ?, cognome= ? , dob= ?, cittadinanza= ? , materia= ? , stipendio= ? where id = ?";
    final DataSource dataSource;
    final ProfessoreConverter professoreConverter;

    public ProfessoreRepository(DataSource dataSource, ProfessoreConverter professoreConverter) {
        this.dataSource = dataSource;
        this.professoreConverter = professoreConverter;
    }

    /**
     * si occupa della gestione degli attributi della classe Professore
     * @param professore
     * @param rs
     * @throws SQLException
     */
    private void getProfessore(Professore professore, ResultSet rs) throws SQLException {
        professore.setId(rs.getInt("id"));
        professore.setMateria(rs.getString("materia"));
        professore.setCittadinaza(rs.getString("cittadinanza"));
        professore.setCognome(rs.getString("cognome"));
        professore.setDob(rs.getString("dob"));
        professore.setNome(rs.getString("nome"));
    }

    /**
     * metodo che si occupa di estrare dal database una istanza della classe Professore inn base all'id inserito dall'utente
     * @param id
     * @return professore
     * @throws SQLException
     */
    public Professore findProfessoreById(Integer id) throws SQLException {
        Professore professore=null;
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(idQuery + id);
        while (rs.next()) {
            professore = new Professore();
            getProfessore(professore, rs);
        }
        st.close();
        rs.close();
        c.close();
        return professore;
    }

    /**
     * si occupa di estrarre dal database tutte le istanze della classe Professore
     * @return list
     * @throws Exception
     */
    public List<Professore> findAllProfessore() throws Exception{
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery( selectQuery);
        List<Professore> list=new ArrayList<>();
        while (rs.next())
        {
            Professore professore = new Professore();
            getProfessore(professore, rs);
            list.add(professore);
        }
        st.close();
        rs.close();
        c.close();
        return list;
    }

    /**
     * si occupa di eliminare una determinata istanza in base all'id inserito dall'utente all'interno del database
     * @param id
     */
    public void DeleteProfessore (Integer id) {
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
     * si prepara in precedenza i dati da inserire in modo da stabilire un ordine sui dati inseriti
     * @param preparedStatement
     * @param professore
     * @return preparedStatement
     * @throws SQLException
     */
    private PreparedStatement preparedStatement (PreparedStatement preparedStatement, Professore professore) throws SQLException {
        //id, nome, cognome, dob, cittadinaza, materia, stipendio
        preparedStatement.setString(1,professore.getNome());
        preparedStatement.setString(2,professore.getCognome());
        preparedStatement.setString(3,professore.getDob());
        preparedStatement.setString(4,professore.getCittadinaza());
        preparedStatement.setString(5,professore.getMateria());
        preparedStatement.setDouble(6,professore.getStipendio());
        return preparedStatement;
    }

    /**
     * si occupa dell'inserimento all'interno del database di una nuova istanza della classe Studente
     * @param professoreDTO
     * @return professore
     * @throws SQLException
     */
    public Professore saveProfessore(ProfessoreDTO professoreDTO) throws SQLException {
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
        Professore professore=professoreConverter.professoreDTOConverter(professoreDTO,id);
        rs.close();
        st.close();

        PreparedStatement ps = c.prepareStatement(insertQuery);
        ps=preparedStatement(ps,professore);
        ps.executeUpdate();
        ps.close();
        c.close();
        return professore;
    }

    /**
     * si occupa di aggiornare i dati di una determinata istanza dell'entità Professore
     * @param professoreDTO
     * @param id
     * @return
     * @throws SQLException
     */
    public Professore UpdateProfessore(ProfessoreDTO professoreDTO, Integer id) throws SQLException {
        Connection c=dataSource.getConnection();
        Professore professore=professoreConverter.professoreDTOConverter(professoreDTO,id);
        PreparedStatement ps = c.prepareStatement(update);
        ps=preparedStatement(ps,professore);
        ps.executeUpdate();
        ps.close();
        c.close();
        return professore;
    }

}
