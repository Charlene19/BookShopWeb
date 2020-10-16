/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.entity.Book;
import model.entity.Event;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import controller.eventServlet;
import model.dao.EventDAO;

/**
 *
 * @author cda611
 */
public class beanEvent implements Serializable {
    
 List<Book> books;
       EventDAO ed = new EventDAO(); 
    
    public beanEvent() {
       
      
    }
    
    
    
    public List<Book> returnlBook(String id) throws SQLException, NamingException {
    books = ed.getList(id); 
        
        return books;
    
    }
    
    public Double getDiscountPrice(String id) throws SQLException{
        Event event = ed.getEvent(id); 
        Double remise = event.getDiscount(); 
        
        return remise; 
        
    }
    
    public Event getEvent(String id) throws SQLException{
        
        return ed.getEvent(id);
    }
}
