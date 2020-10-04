package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.entity.Book;
import  model.entity.Event;

public class EventDAO {

    
    
        public Event getEvent(String evId) throws SQLException{
          
                DataSource ds = null;
                try {
                    InitialContext context = new InitialContext();
                    ds = (DataSource) context.lookup("jdbc/bookshop");
                } catch (NamingException ex) {
                    System.out.println(">>>Oops:Naming:" + ex.getMessage());
                }
                
                Connection connexion = null;
                
                
                connexion= ds.getConnection();
                String query = "select * from EVENT where Event_ID="+evId + "";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Event event = null; 
                
                while (rs.next()) {
                    event = new Event();
                    event.setName(rs.getString("EVENT_NAME"));
                    event.setDateFin(rs.getString("EVENT_DATE_END"));
                    event.setDiscount(rs.getDouble("EVENT_DISCOUNT_VALUE"));
                    
                }
                
            
           return event;     
        }
    
    

	public List<Book> getList(String event) throws SQLException, NamingException{
        List<Book> lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = "select * from Book where BOOK_ISBN in (Select BOOK_ISBN from dbo.ASSOC_BOOK_EVENT where EVENT_ID ="+ event+" )";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                 Book object = null;

                while (rs.next()) {
                    
                    
                    object = new Book();
                object.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                //object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                object.setTitle(rs.getString(4));
                object.setSubTitle(rs.getString(5));
                object.setPrice(rs.getFloat(6));
                object.setCoverURL(rs.getString(7));
                object.setSummary(rs.getString(8));
                object.setQuantity(rs.getInt(9));
                object.setShelf(rs.getString(10));
                object.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(object );
                   
                }

        
        
        return lBook;
    }
     	
}

