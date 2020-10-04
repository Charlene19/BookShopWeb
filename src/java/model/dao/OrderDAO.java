/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import db.Database;
import  model.entity.Address;
import model.entity.Book;
import  model.entity.Customer;
import model.entity.Order;
import model.entity.OrderStatus;
import model.entity.ShippingOffer;

/**
 *
 * @author cda611
 */
public class OrderDAO implements DAO<Order, Book>{
    
	
	
	 
	 	ResultSetMetaData resultMeta;
	 	PreparedStatement prepare;
	 	boolean exist;
	 	String query;
	 	Date packD;
	 	java.sql.Date sqlDate;
	 	 String nom ;
	 	String prenom ;
	 	Customer c = new Customer(); 
	 	ShippingOffer sO = new ShippingOffer(); 
	 	Address a = new Address(); 
	 	Address b = new Address(); 
                List<Book> lBook;
	  

	 public OrderDAO(){
          
         }	
	  	  
               
  //récupere tous les livres d'un client selon une commande du dernier mois par Id client
         
     public List<Book> getListLast(Long id) throws SQLException, NamingException{
         
         
        lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                
                String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID ="+ id +" and [dbo].[ORDER].ORDER_CREATION_DATE < 2019-09-04 ));";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Book book = null;

                while (rs.next()) {
                    
                    
                book = new Book();
                book.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                book.setTitle(rs.getString(4));
                book.setSubTitle(rs.getString(5));
                book.setPrice(rs.getFloat(6));
                book.setCoverURL(rs.getString(7));
                book.setSummary(rs.getString(8));
                book.setQuantity(rs.getInt(9));
                book.setShelf(rs.getString(10));
                book.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(book );
                   
                }
                return lBook;
     }
     
                    
  //récupere tous les livres d'un client selon une commande par Id client
     
                public List<Book> getList(Long id) throws SQLException, NamingException{
         
         
        lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in(\n" + "Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID = "+ id +"));";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Book book = null;

                while (rs.next()) {
                    
                    
                book = new Book();
                book.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                book.setTitle(rs.getString(4));
                book.setSubTitle(rs.getString(5));
                book.setPrice(rs.getFloat(6));
                book.setCoverURL(rs.getString(7));
                book.setSummary(rs.getString(8));
                book.setQuantity(rs.getInt(9));
                book.setShelf(rs.getString(10));
                book.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(book );
                   
                }

        
        
        return lBook;
    }
               
  //récupere tous les livres d'un client selon une commande des 6 derniers mois  par Id client
                
  public List<Book> getListSixMonth(Long id) throws SQLException, NamingException{
         
         
        lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = "select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID ="+ id +" and [dbo].[ORDER].ORDER_CREATION_DATE >2019-09-04 and  [dbo].[ORDER].ORDER_CREATION_DATE <2019-04-04 ));";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Book book = null;

                while (rs.next()) {
                    
                    
                book = new Book();
                book.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                book.setTitle(rs.getString(4));
                book.setSubTitle(rs.getString(5));
                book.setPrice(rs.getFloat(6));
                book.setCoverURL(rs.getString(7));
                book.setSummary(rs.getString(8));
                book.setQuantity(rs.getInt(9));
                book.setShelf(rs.getString(10));
                book.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(book );
                   
                }

        
        
        return lBook;
    }
     
  
// récupere tous les livres d'une commande plus ancienne que 6 mois par id Client 
  
  public List<Book> getListPast(Long id) throws SQLException, NamingException{
         
         
        lBook = new ArrayList();
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID ="+ id +"  and  [dbo].[ORDER].ORDER_CREATION_DATE > 2019-04-04 ));";
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Book book = null;

                while (rs.next()) {
                    
                    
                book = new Book();
                book.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                book.setTitle(rs.getString(4));
                book.setSubTitle(rs.getString(5));
                book.setPrice(rs.getFloat(6));
                book.setCoverURL(rs.getString(7));
                book.setSummary(rs.getString(8));
                book.setQuantity(rs.getInt(9));
                book.setShelf(rs.getString(10));
                book.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(book );
                   
                }

        
        
        return lBook;
    }
  
  
  //retourne  le nom du statut de la commande
  
    public String getStatusOrder(Order orderCours) throws SQLException{
              String statut = "";
             DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
                String query = "Select [ORDER_STATUS_NAME] from [dbo].[ORDER_STATUS] where [ORDER_STATUS_ID] in (Select [ORDER_STATUS_ID] from [dbo].[ASSOC_STATUS_ORDER] where [ORDER_ID] = '" + orderCours.getId() +  "' ";
                 
                Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                 while (rs.next()){
                    statut = rs.getString("ORDER_STATUS_NAME");
                 }
                 return statut; 
    }

    @Override
    public void add(Order object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Order getById(String id) throws Exception {
        Order order = null; 
        
        DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
        String query = "Select * from [dbo].[ORDER] where [dbo].[ORDER].Order_id =" + id + "";
         Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                 while (rs.next()){
                     order = new Order(); 
                     order.setCustomer(new CustomerDAO().getById(rs.getLong("Customer_Id")));
                 }
      return order;   
    }

    public List<Book> getListById(String id) throws SQLException{
        List<Book> Ibook = new ArrayList(); 
        
         DataSource ds = null;
            try {
                InitialContext context = new InitialContext();
                ds = (DataSource) context.lookup("jdbc/bookshop");
            } catch (NamingException ex) {
                System.out.println(">>>Oops:Naming:" + ex.getMessage());
            }

            Connection connexion = null;
 

                connexion= ds.getConnection();
        String query = "select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id=" + id + "";
         Statement stmt = connexion.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                Book book = null;

                while (rs.next()) {
                    
                    
                book = new Book();
                book.setIsbn(rs.getString(1));
                
                // Obtains the publisher matching the ID
                // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
                // Obtains the VAT matching the ID
                //object.setVat(new VatDAO().get(rs.getInt(3)));
                book.setTitle(rs.getString(4));
                book.setSubTitle(rs.getString(5));
                book.setPrice(rs.getFloat(6));
                book.setCoverURL(rs.getString(7));
                book.setSummary(rs.getString(8));
                book.setQuantity(rs.getInt(9));
                book.setShelf(rs.getString(10));
                book.setPostIt(rs.getString(11));
                
               
                
                  lBook.add(book );
                   
                }

      return Ibook;   
    }
    
    @Override
    public void update(Order object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getById(Book id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
                  
               
}
