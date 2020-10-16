
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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.naming.NamingException;
import model.dao.BookDAO;
import model.dao.EventDAO;
import model.entity.Book;

/**
 *
 * @author cda611
 */
public class beanSearch implements Serializable {
    
   Set<Book> books;
    
    public beanSearch() {
      books =  new HashSet(); 
    }
     
    public Set<Book> getAll() throws NamingException, SQLException{
       // books = new HashSet<>(new BookDAO().getAll()); 
        
        return books; 
    }
    
    public Set<Book> getByCategory(String category) throws NamingException, SQLException{
        books = new HashSet<>(new BookDAO().categorySearch(category)); 
        
        return books; 
    }
    
    public Set<Book> getByTitle(String title) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().titleSearch(title)); 
        
        return books; 
    }
    
    public Set<Book> getByISBN(String isbn) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().isbnSearch(isbn)); 
        
        return books; 
    }
    
    public Set<Book> getByKeywords(String keyword) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().keywordSearch(keyword)); 
        
        return books; 
    }
    
    public Set<Book> getByPrice(Double priceS, Double priceE) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().priceSearch(priceS, priceE)); 
        
        return books; 
    }
    
    public Set<Book> getByPriceMin(Double priceS) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().priceSearchMin(priceS)); 
        
        return books; 
    }
    
    public Set<Book> getByPriceMax(Double priceS) throws NamingException, SQLException{
        books = new HashSet<>( new BookDAO().priceSearchMax(priceS)); 
        
        return books; 
    }
     public Set<Book> getByRemise() throws NamingException, SQLException{
         
          EventDAO ed = new EventDAO(); 
       
        books = new HashSet<>(  ed.getList("2")); 
        
        return books; 
    }

   
}

