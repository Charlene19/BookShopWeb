/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.Address;
import classes.Customer;
import classes.Order;
import classes.OrderStatus;
import classes.ShippingOffer;

/**
 *
 * @author cda611
 */
public class OrderDAO {
    
	
		private String url ; 
	    private String username ; 
	    private String password ; 
	    Scanner sc = new Scanner(System.in);
	    private Connection connection;
	 	private ResultSet result;
	 	private Statement state;
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
	  

	 	   public OrderDAO(String url, String username, String password) throws SQLException{
	 	        this.url = url; 
	 	        this.username = username; 
	 	        this.password = password; 
	 	      
	 	        connection = DriverManager.getConnection(url, username, password);
	 	    }
	 	    
	 	   public OrderDAO() throws SQLException{
	 	        System.out.println("Entrez vos informations de connexion: \n "); 
	 	        System.out.println("Url : \n");
	 	         url = sc.nextLine(); 
	 	        System.out.println("User : \n");
	 	         username = sc.nextLine(); 
	 	        System.out.println("password : \n");
	 	         password = sc.nextLine(); 
	 	         
	 	         connection = DriverManager.getConnection(url, username, password);
	 	        
	 	    }
	 	    
	 	   public void SaveOrder(classes.Order order) throws SQLException{
	 
	 	        connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT [ORDER_ID]\n" +
"      ,[CUSTOMER_ID]\n" +
"      ,[DELIVERY_ADDRESS_ID]\n" +
"      ,[BILLING_ADDRESS_ID]\n" +
"      ,[SHIPPING_OFFER_ID]\n" +
"      ,[ORDER_CREATION_DATE]\n" +
"      ,[ORDER_SHIPPING_TIME_LIMIT]\n" +
"      ,[ORDER_USER_IP]\n" +
"      ,[ORDER_COMMENT]\n" +
"      ,[ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE] from Order where [ORDER_ID] ='" + order.getId()+ "'";
	 	       
	  
	 	     
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	
		 	     
	 	    	  JOptionPane.showMessageDialog(new JFrame(), "Commande dÃ©jÃ  enregistrÃ© !");
	 	    	   
	 	    	  
	 	       }else {
	 	    	  prepare = connection.prepareStatement("INSERT INTO [dbo].[ORDER] VALUES(?,?,?,?,?,?,?,?);");
//	 	    	 try {
//	 				packD = pack.stringToDate( pack.getDateLivraison());
//	 			} catch (Exception e1) {
//	 				// TODO Auto-generated catch block
//	 				e1.printStackTrace();
//	 			}
//	 	    	 sqlDate = new java.sql.Date(packD.getTime()); 
			 	  
		 	        prepare.setLong(1, order.getCustomer().getCustomerId());
		 	        prepare.setLong(2, order.getAdresseLiv().getAddressId());
		 	        prepare.setLong(3, order.getAdresseBil().getAddressId());
                                prepare.setLong(4, order.getShipping().getShippingOfferId());
		 	        prepare.setString(5, order.getDateOrder());
                                prepare.setString(6, order.getDateLivraison());
                                prepare.setString(7, order.getIpCustomer());
                                prepare.setString(8, order.getCommentaire());
                                prepare.setDouble(9, order.getPriceTaxFree());
                                
		 	        prepare.execute();
		 					
		 		JOptionPane.showMessageDialog(new JFrame(), order.getDateOrder() + " mis dans dbb");}}
	 	   
	 	   public Long getId(classes.Order order) throws SQLException {
	 		   
	 		   connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT * from Order where [CUSTOMER_ID]  = '"+ order.getCustomer().getCustomerId()+"' AND [ORDER_CREATION_DATE]= '" + order.getDateOrder() +"'";
	 	       
	  
	 	      // String query = "SELECT * from Author"; 
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	System.out.println(result.getLong(1));
		 	    return result.getLong(1);
	 	      }
	 	     System.out.println("Commande inexistante !");
	 	    	return 0l;  
	 	      
	 	   }
	 	   
	 	
	 	  public void createOrder(classes.Order order) {
	 		   
	 		  
	 		   try {
				SaveOrder(order);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
	 		
                  
}
	 	  public Order searchById(int id) throws SQLException {
	 		  
	 		 connection = DriverManager.getConnection(url, username, password);
	 	      query = "SELECT * from [ORDER] where ORDER_ID ='" + id + "'";
	 	       
	  
	 	     
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	       c = c.getClientById( (int) result.getLong("CUSTOMER_ID"));
	 	       a = new Address(result.getLong("DELIVERY_ADDRESS_ID"));
	 	       b = new Address(result.getLong("DELIVERY_ADDRESS_ID"));
	 	      sO = new ShippingOffer(result.getLong("SHIPPING_OFFER_ID"));
	 	    	  
	 	    	  Order order = new Order(result.getLong("ORDER_ID"),c , a ,b
	 	    		    	      ,sO
	 	    		    	      ,result.getString("ORDER_CREATION_DATE")
	 	    		    	      ,result.getString("ORDER_SHIPPING_TIME_LIMIT")
	 	    		    	      ,result.getString("ORDER_USER_IP")
	 	    		    	      ,result.getString("ORDER_COMMENT")
	 	    		    	      ,result.getDouble("ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE"));
	 	    	
		 	     
	 	    	  JOptionPane.showMessageDialog(new JFrame(), order.toString());
	 	    	   
	 	    	  
	 	       }else {
	 		  
	 	    	  JOptionPane.showMessageDialog(new JFrame(), "La commande n'existe pas");}
			return new Order();
	 	  }
	 	  
                  public void associateStatus(Order order, OrderStatus orderStatus) throws SQLException{
                        connection = DriverManager.getConnection(url, username, password);
                    try {
                        prepare = connection.prepareStatement("INSERT INTO [dbo].[ASSOC_STATUS_ORDER]([ORDER_ID] ,[ORDER_STATUS_ID] ,[ASSOC_STATUS_ORDER_DATE],[ASSOC_STATUS_ORDER_POST_IT])VALUES(?,?,?,?,?,?,?,?);");
                        prepare.setLong(1, order.getId());
		 	prepare.setInt(2, orderStatus.getOrderStatusId());
                        prepare.setString(3, orderStatus.getOrderStatusPostIt());
                        // sqlDate = new java.sql.Date(eventD.getTime());
                    
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                  }
                  
                  public static void main (String []args) {
                	  
                	  OrderDAO o;
					try {
						o = new OrderDAO("jdbc:sqlserver://localhost:1433;databaseName=BookShop;", "sa", "sa");
						System.out.println( o.searchById(2));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
                	 
                  }
}
