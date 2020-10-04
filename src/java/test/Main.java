package test;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.dao.CustomerDAO;
import model.entity.Customer;

/**
 *
 * @author zvr
 */
public class Main {
    
    public static void main(String [] a){
        
        //--------------------------------
        // Adds a customer to the database
        //--------------------------------
        
        CustomerDAO customerDAO = new CustomerDAO();

        // The customer to insert
        Customer customer = new Customer();

        customer.setCustomerFName("first_name_guy");
        customer.setCustomerLName("last_name_guy");
        customer.setCustomerUsername("123");
        customer.setCustomerPassword("123");
        customer.setCustomerEmail("email@email.mail");
        
        try {
            customerDAO.add(customer);
            
        } catch (NamingException ex) {
            System.out.println("Naming exception: " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
}