package com.Progetto2.Progetto2.repository;

import com.Progetto2.Progetto2.converter.AtaConverter;
import com.Progetto2.Progetto2.data.AtaDTO;
import com.Progetto2.Progetto2.entities.Ata;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtaRepository
{
    String idQuery="select * from professore where id=";
    String selectQuery = "select * from professore";
    String deleteQuery="delete from professore where id=";
    String findMaxId="select max(id) as id from studente";
    String insertQuery="insert into professore(nome, cognome, dob, cittadinanza,materia,stipendio) values (?,?,?,?,?,?)";
    String update= "update studente set nome= ?, cognome= ? , dob= ?, cittadinanza= ? , materia= ? , stipendio= ? where id = ?";
    final DataSource dataSource;
    final AtaConverter ataConverter;

    public AtaRepository(DataSource dataSource, AtaConverter ataConverter) {
        this.dataSource = dataSource;
        this.ataConverter = ataConverter;
    }

    /**
     * si occupa della gestione degli attributi della classe Ata
     * @param ata
     * @param rs
     * @throws SQLException
     */
    private void getAta(Ata ata, ResultSet rs) throws SQLException {
        ata.setId(rs.getInt("id"));
        ata.setStipendio(rs.getDouble("stipendio"));
        ata.setMansione(rs.getString("mansione"));
        ata.setCittadinaza(rs.getString("cittadinanza"));
        ata.setCognome(rs.getString("cognome"));
        ata.setDob(rs.getString("dob"));
        ata.setNome(rs.getString("nome"));

    }

    /**
     * metodo che si occupa di estrare dal database una istanza della classe Ata inn base all'id inserito dall'utente
     * @param id
     * @return ata
     * @throws SQLException
     */
    public Ata findAtaById(Integer id) throws SQLException {
        Ata ata=null;
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(idQuery + id);
        while (rs.next()) {
            ata = new Ata();
            getAta(ata, rs);
        }
        st.close();
        rs.close();
        c.close();
        return ata;
    }

    /**
     * si occupa di estrarre dal database tutte le istanze della classe Ata
     * @return list
     * @throws Exception
     */
    public List<Ata> findAllAta() throws Exception{
        Connection c=dataSource.getConnection();
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery( selectQuery);
        List<Ata> list=new ArrayList<>();
        while (rs.next())
        {
            Ata ata = new Ata();
            getAta(ata, rs);
            list.add(ata);
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
    public void DeleteAta (Integer id) {
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
     * @param ata
     * @return preparedStatement
     * @throws SQLException
     */
    private PreparedStatement preparedStatement (PreparedStatement preparedStatement, Ata ata) throws SQLException {
        //id, nome, cognome, dob, cittadinaza, materia, stipendio
        preparedStatement.setString(1,ata.getNome());
        preparedStatement.setString(2,ata.getCognome());
        preparedStatement.setString(3,ata.getDob());
        preparedStatement.setString(4,ata.getCittadinaza());
        preparedStatement.setString(5,ata.getMansione());
        preparedStatement.setDouble(6,ata.getStipendio());
        return preparedStatement;
    }

    /**
     * si occupa dell'inserimento all'interno del database di una nuova istanza della classe Ata
     * @param ataDTO
     * @return ata
     * @throws SQLException
     */
    public Ata saveAta(AtaDTO ataDTO) throws SQLException {
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
        Ata ata=ataConverter.ataDTOConverter(ataDTO,id);
        rs.close();
        st.close();

        PreparedStatement ps = c.prepareStatement(insertQuery);
        ps=preparedStatement(ps,ata);
        ps.executeUpdate();
        ps.close();
        c.close();
        return ata;
    }

    /**
     * si occupa di aggiornare i dati di una determinata istanza dell'entità Ata
     * @param ataDTO
     * @param id
     * @return ata
     * @throws SQLException
     */
    public Ata UpdateAta(AtaDTO ataDTO, Integer id) throws SQLException {
        Connection c=dataSource.getConnection();
        Ata ata=ataConverter.ataDTOConverter(ataDTO,id);
        PreparedStatement ps = c.prepareStatement(update);
        ps=preparedStatement(ps,ata);
        ps.executeUpdate();
        ps.close();
        c.close();
        return ata;
    }
}
