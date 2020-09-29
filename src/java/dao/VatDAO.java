package dao;

import classes.Vat;
import dao.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zvr
 */
public class VatDAO implements DAO<Vat>{

    private final String DB_NAME = "bookshop";
    private final String DB_USER = "sa";
    private final String DB_PASS = "sa";
    private final String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + DB_NAME + ";"
            + "user=" + DB_USER + ";"
            + "password=" + DB_PASS;

    public final String TABLE_VAT = "VAT";
    
    public final String QUERY_INSERT_VAT =
            "INSERT INTO " + TABLE_VAT
            + "(VAT_RATE)"
            + " values"
            + "(?)";
    
    public final String QUERY_SELECT_ALL_VAT = 
            "SELECT * FROM "+TABLE_VAT;
    public final String QUERY_SELECT_VAT = 
            "SELECT * FROM "+TABLE_VAT+" "
            +"WHERE VAT_ID = ?";
    public final String QUERY_UPDATE_VAT =
            "UPDATE "+TABLE_VAT+" "
            + "SET VAT_RATE = ? "
            + "WHERE VAT_ID = ?";
    public final String QUERY_DELETE_VAT =
        "DELETE FROM VAT WHERE VAT_ID = ?";

    @Override
    public void add(Vat object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);

            statement = connection.prepareStatement(QUERY_INSERT_VAT);
            statement.setFloat(1, object.getRate());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void update(Vat object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_VAT);

            statement.setFloat(1, object.getRate());
            statement.setInt(2, object.getId());

            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(Vat object) throws DatabaseException{
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }

        try{
            statement = connection.prepareStatement(QUERY_DELETE_VAT);
            statement.setInt(1, object.getId());
            result = statement.executeUpdate();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public List<Vat> getAll(){
        List<Vat> objects = new ArrayList<>();
        
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
            statement = connection.prepareStatement(QUERY_SELECT_ALL_VAT);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            Vat object = null;
            
            while(resultSet.next()){
                
                object = new Vat();
                object.setId(resultSet.getInt(1));
                object.setRate(resultSet.getFloat(2));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){

        }

        return objects;
    }
    
    public Vat get(Object id){
        
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        
        Vat vat = new Vat();
        
        // SQL server connection creation
        try{
            connection = DriverManager.getConnection(DB_URL);
        }catch(SQLException ex){
            return vat;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_VAT);
            statement.setInt(1, (int)id);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            
            while(resultSet.next()){
                
                vat = new Vat();
                vat.setId(resultSet.getInt(1));
                vat.setRate(resultSet.getFloat(2));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return vat;
    }
}
