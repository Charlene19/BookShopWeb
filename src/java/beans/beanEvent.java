/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import classes.Book;
import classes.Event;
import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import servlets.eventServlet;

/**
 *
 * @author cda611
 */
public class beanEvent implements Serializable {
    
    List<Book> eventList = null;
    
    public beanEvent() {
        this.eventList = new ArrayList();
      
    }
    
    
    
    public List<Book> returnlBook() throws SQLException, NamingException {
    eventList = new eventServlet().getList();
        return eventList;
    }
    
    public double getRemise(){
       //doit retourner ou une remise ou le prix du livre à déterminer. 
        
        return 0.0;
    }
    
    public Event getEvent(){
        
        return new Event();
    }
}
