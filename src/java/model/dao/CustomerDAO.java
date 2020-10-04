package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Customer;
/**
 *
 * @author zvr
 */
public class CustomerDAO implements DAO<Customer,Long> {

    public final String TABLE_CUSTOMER = "CUSTOMER";

    public final String QUERY_INSERT_CUSTOMER
            = "INSERT INTO " + TABLE_CUSTOMER
            + "(CUSTOMER_L_NAME, CUSTOMER_F_NAME, CUSTOMER_EMAIL, "
            + "CUSTOMER_USERNAME, CUSTOMER_PASSWORD, CLIENT_DATE)"
            + " values"
            + "(?,?,?,?,?,?)";

    public final String QUERY_SELECT_ALL_CUSTOMER
            = "SELECT * FROM " + TABLE_CUSTOMER;
    public final String QUERY_SELECT_CUSTOMER
            = "SELECT * FROM " + TABLE_CUSTOMER + " "
            + "WHERE CUSTOMER_ID = ?";

    public final String QUERY_SELECT_CUSTOMER_FROM_EMAIL
            = "SELECT * FROM " + TABLE_CUSTOMER + " "
            + "WHERE CUSTOMER_EMAIL = ? AND "
            + "CUSTOMER_PASSWORD = ?";
 
    public final String QUERY_CHECK_CUSTOMER_BY_EMAIL
            = "SELECT CUSTOMER_EMAIL FROM " + TABLE_CUSTOMER + " "
            + "WHERE CUSTOMER_EMAIL = ?";
    
    
    @Override
    public void add(Customer object) throws NamingException, SQLException{
         
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        int result = -1;
 
        connection = database.getConnection();
        statement = connection.prepareStatement(QUERY_INSERT_CUSTOMER);
        
        statement.setString(1, object.getCustomerLName());
        statement.setString(2, object.getCustomerFName());
        statement.setString(3, object.getCustomerEmail());
        statement.setString(4, object.getCustomerUsername());
        statement.setString(5, object.getCustomerPassword());
        statement.setString(6, DateFormat.getInstance().format(new Date()));
        
        result = statement.executeUpdate();

        statement.close();
        connection.close();

    }

    @Override
    public List<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Customer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Customer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    public Customer getByUsername(String email, String password) throws NamingException, SQLException{
        
        Customer customer = null;

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_CUSTOMER_FROM_EMAIL);
        statement.setString(1, email);
        statement.setString(2, password);
        
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            customer = new Customer();
            customer.setCustomerId(resultSet.getLong(1));
            customer.setCustomerLName(resultSet.getString(2));
            customer.setCustomerFName(resultSet.getString(3));
            customer.setCustomerEmail(resultSet.getString(4));
            customer.setCustomerUsername(resultSet.getString(5));
            customer.setCustomerPassword(resultSet.getString(6));
        }

        statement.close();

        return customer;
    }
    
    public boolean getCheckEmail(String email) throws NamingException, SQLException{
        
        Boolean emailFound = false;

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_CHECK_CUSTOMER_BY_EMAIL);
        statement.setString(1, email);
        
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {
            emailFound = true;
         
        statement.close();
        
        }
        return emailFound; 
    }
}
