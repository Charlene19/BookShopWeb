package model.dao;

import db.Database;
import java.awt.Image;
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
import javax.naming.NamingException;

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
 	    
           public Order_RowDAO(int id) {
               
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
           
           
    public final String QUERY_INSERT_ORDER_ROW = "insert into ORDER_ROW"
            + " (COMMENT_ID, ORDER_ID, BOOK_ISBN, ORDER_ROW_QTY, ORDER_ROW_HT_PRICE, ORDER_ROW_DISCOUNT_VALUE)"
            + " values (?, ?, ?, ?, ?, ?)";
    
    public void add(Order_Row object) throws NamingException, SQLException, Exception {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();
        statement = connection.prepareStatement(QUERY_INSERT_ORDER_ROW);

        // Updates book's stock quantity
        new BookDAO().reduceQuantity(object.getBookIsbn(), object.getOrderQuantity());
        
        statement.setString(1, null);
        statement.setInt(2, object.getOrderId());
        statement.setString(3, object.getBookIsbn());
        statement.setInt(4, object.getOrderQuantity());
        statement.setDouble(5, object.getOrderRowPrice());
        statement.setDouble(6, 0);

        statement.executeUpdate();

        statement.close();
    }
    
    public final String QUERY_SELECT_ORDER_ROW = "SELECT * FROM ORDER_ROW";
    
    public List<Order_Row> getAll() throws NamingException, SQLException{
        
        List<Order_Row> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ORDER_ROW);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Order_Row object = null;

        while (resultSet.next()) {

            object = new Order_Row();
           
            object.setOrderRowId(resultSet.getInt(1));
            object.setCommentId(resultSet.getInt(2));
            object.setOrderId(resultSet.getInt(3));
            object.setBookIsbn(resultSet.getString(4));
            object.setOrderQuantity(resultSet.getInt(5));
            object.setOrderRowPrice(resultSet.getDouble(6));
            object.setOrderRowDiscount(resultSet.getDouble(7));

            objects.add(object);
        }

        statement.close();
        
        return objects;
    }
}