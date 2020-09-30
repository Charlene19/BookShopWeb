/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Book;
import classes.Order;
import dao.PublisherDAO;
import dao.VatDAO;
import java.beans.*;
import java.io.Serializable;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author cda611
 */
public class beanOrder implements Serializable {
    
   
    
    public beanOrder() {    
    }
    
    public boolean validateOrder(){
        //doit retourner un booléen pour valider la commande
        return false;
    }
    
    public Order getOrder(){
        
        return new Order(); 
    }
    
    public List allOrder() throws SQLException{
     
        return new ArrayList<>();
      
    }
    
    public List unachieveOrder(){
        
        //retourne les commandes n'ayant pas un statut livré du client
        return new ArrayList<Order>(); 
    }
}
