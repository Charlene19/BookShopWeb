package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Vat;

/**
 *
 * @author zvr
 */
public class VatDAO implements DAO<Vat, Integer> {

    public final String TABLE_VAT = "VAT";

    public final String QUERY_SELECT_ALL_VAT
            = "SELECT * FROM " + TABLE_VAT;
    public final String QUERY_SELECT_VAT
            = "SELECT * FROM " + TABLE_VAT + " "
            + "WHERE VAT_ID = ?";

    @Override
    public void add(Vat object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vat> getAll() throws NamingException, SQLException {
        
        List<Vat> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_VAT);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Vat object = null;

        while (resultSet.next()) {

            object = new Vat();
            object.setId(resultSet.getInt(1));
            object.setRate(resultSet.getFloat(2));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Vat getById(Integer id) throws SQLException, NamingException{

        Vat vat = new Vat();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_VAT);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            vat.setId(resultSet.getInt(1));
            vat.setRate(resultSet.getFloat(2));
        }

        statement.close();

        return vat;
    }

    @Override
    public void update(Vat object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Vat object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
