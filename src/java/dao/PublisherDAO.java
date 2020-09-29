package dao;

import classes.Publisher;
import dao.DatabaseException;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author zvr
 */
public class PublisherDAO implements DAO<Publisher>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_PUBLISHER = "PUBLISHER";
    public final String TABLE_ASSOC_ADDRESS_PUBLISHER = "ASSOC_ADDRESS_PUBLISHER";
    
    public final String QUERY_INSERT_PUBLISHER =
            "INSERT INTO " + TABLE_PUBLISHER
            + "(PUBLISHER_NAME, PUBLISHER_POST_IT)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_INSERT_ASSOC_ADDRESS_PUBLISHER =
            "INSERT INTO " + TABLE_PUBLISHER
            + "(ADDRESS_ID, PUBLISHER_ID)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_PUBLISHER = "SELECT * FROM PUBLISHER";
    public final String QUERY_SELECT_PUBLISHER = 
            "SELECT * FROM PUBLISHER "
            + "WHERE PUBLISHER_ID = ?";
    
    public final String QUERY_UPDATE_PUBLISHER =
            "UPDATE PUBLISHER "
            + "SET PUBLISHER_NAME=?,"
            + "PUBLISHER_POST_IT=? "
            + "WHERE PUBLISHER_ID = ?";
    public final String QUERY_DELETE_PUBLISHER =
        "DELETE FROM PUBLISHER WHERE PUBLISHER_ID = ?";
    
    public final String QUERY_DELETE_ASSOC_ADDRESS_PUBLISHER =
        "DELETE FROM "+TABLE_ASSOC_ADDRESS_PUBLISHER+" WHERE PUBLISHER_ID = ?";
    

final ImageIcon icon = new ImageIcon("icone.png");
	    Image image2 = icon.getImage().getScaledInstance(32,32,0);
    

    @Override
    public void add(Publisher object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
            
            statement = connection.prepareStatement(QUERY_INSERT_PUBLISHER);

            statement.setString(1, object.getName());
            statement.setString(2, object.getPostIt());

            result = statement.executeUpdate();

            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(new JFrame(), "Editeur dans Bdd", "Editeur insertion", 1, new ImageIcon(image2));
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Publisher object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_PUBLISHER);

            statement.setString(1, object.getName());
            statement.setString(2, object.getPostIt());
            statement.setInt(3, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    // TODO : message when confict due to book assoc
    /**
     * 
     * @param object 
     */
    @Override
    public void delete(Publisher object) throws DatabaseException{
        
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_DELETE_ASSOC_ADDRESS_PUBLISHER);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();
            
            statement = connection.prepareStatement(QUERY_DELETE_PUBLISHER);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();

            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public List<Publisher> getAll(){
        List<Publisher> objects = new ArrayList<>();
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return objects;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ALL_PUBLISHER);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Publisher object = null;
            
            while(resultSet.next()){
                
                object = new Publisher();
                object.setId(resultSet.getInt(1));
                object.setName(resultSet.getString(2));
                object.setPostIt(resultSet.getString(3));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            
        }
        return objects;
    }
    
    public Publisher get(Object id){
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Publisher publisher = new Publisher();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return publisher;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_PUBLISHER);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            
            while(resultSet.next()){
                
                publisher = new Publisher();
                publisher.setId(resultSet.getInt(1));
                publisher.setName(resultSet.getString(2));
                publisher.setPostIt(resultSet.getString(3));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return publisher;
    }
    
}