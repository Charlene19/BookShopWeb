package model.dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.entity.Order_Row;

public class Order_RowDAO {
	
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;"; 
        private String username = "sa" ; 
        private String password = "sa" ; 
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
	final ImageIcon icon = new ImageIcon("icone.png");
        Order_Row or; 
        
    Image image2 = icon.getImage().getScaledInstance(32,32,0);

 	   public Order_RowDAO(String url, String username, String password) throws SQLException{
 	        this.url = url; 
 	        this.username = username; 
 	        this.password = password; 
 	      
 	        connection = DriverManager.getConnection(url, username, password);
 	    }
 	    
 	   public Order_RowDAO() throws SQLException{
 	        System.out.println("Entrez vos informations de connexion: \n "); 
 	        System.out.println("Url : \n");
 	         url = sc.nextLine(); 
 	        System.out.println("User : \n");
 	         username = sc.nextLine(); 
 	        System.out.println("password : \n");
 	         password = sc.nextLine(); 
 	         
 	         connection = DriverManager.getConnection(url, username, password);
 	        
 	    }
 	    
 	   public Order_Row SelectOrderRow(Order_Row orderRow) throws SQLException{
 
 	        connection = DriverManager.getConnection(url, username, password);
 	        
 	       String query = "SELECT [ORDER_ROW_ID]\r\n" + 
 	       		"      ,[COMMENT_ID]\r\n" + 
 	       		"      ,[ORDER_ID]\r\n" + 
 	       		"      ,[BOOK_ISBN]\r\n" + 
 	       		"      ,[ORDER_ROW_QTY]\r\n" + 
 	       		"      ,[ORDER_ROW_HT_PRICE]\r\n" + 
 	       		"      ,[ORDER_ROW_DISCOUNT_VALUE]\r\n" + 
 	       		"  FROM [dbo].[ORDER_ROW] where [ORDER_ID] = '"+ orderRow.getOrderId() +"'";
 	       
  
 	      // String query = "SELECT * from Auteur"; 
 	       state = connection.createStatement();
 	       result = state.executeQuery(query);
 	      resultMeta = result.getMetaData();
 	      
 	     if (result.next()){  
 	    	 
	 	 or = new Order_Row(result.getInt("ORDER_ROW_ID"), result.getInt("COMMENT_ID"), result.getInt("ORDER_ID"), result.getString("BOOK_ISBN"), result.getInt("ORDER_ROW_QTY"), result.getDouble("ORDER_ROW_HT_PRICE"), result.getDouble("ORDER_ROW_DISCOUNT_VALUE"));  
 	    	  return or;
                 
 	       }else {
 	    	  JOptionPane.showMessageDialog(new JFrame(), "Ligne de commande inexistante !", "Erreur Order_Row",  JOptionPane.WARNING_MESSAGE,  new ImageIcon(image2));

return new Order_Row();
}
             
           }
}