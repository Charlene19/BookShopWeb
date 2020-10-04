/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.dao.EventDAO;
import model.entity.Book;
import model.entity.Event;

/**
 *
 * @author cda611
 */
public class beanSearch implements Serializable {
    
      
       
    public beanSearch() {
      
    }
    
    public List<Book> allBook(String id) throws SQLException, NamingException{
         List<Book> books =new ArrayList();
      
        
        return books;
    }
    
   
    
}
