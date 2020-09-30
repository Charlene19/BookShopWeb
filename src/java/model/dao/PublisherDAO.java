package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Publisher;

/**
 *
 * @author zvr
 */
public class PublisherDAO implements DAO<Publisher,Integer>{

    public final String TABLE_PUBLISHER = "PUBLISHER";
    public final String TABLE_ASSOC_ADDRESS_PUBLISHER = "ASSOC_ADDRESS_PUBLISHER";
    
    public final String QUERY_SELECT_ALL_PUBLISHER = "SELECT * FROM PUBLISHER";
    public final String QUERY_SELECT_PUBLISHER = 
            "SELECT * FROM PUBLISHER "
            + "WHERE PUBLISHER_ID = ?";
    
    @Override
    public void add(Publisher object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Publisher> getAll() throws NamingException, SQLException{
  
        List<Publisher> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_PUBLISHER);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Publisher object = null;

        while (resultSet.next()) {

            object = new Publisher();
            object.setId(resultSet.getInt(1));
            object.setName(resultSet.getString(2));
            object.setPostIt(resultSet.getString(3));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Publisher getById(Integer id) throws NamingException, SQLException {

        Publisher publisher = new Publisher();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_PUBLISHER);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            publisher = new Publisher();
            publisher.setId(resultSet.getInt(1));
            publisher.setName(resultSet.getString(2));
            publisher.setPostIt(resultSet.getString(3));
        }

        statement.close();

        return publisher;
    }

    @Override
    public void update(Publisher object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Publisher object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
