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
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.Event;

public class EventDAO {


	//private String url ; 
    //private String username ; 
    //private String password ; 
    Scanner sc = new Scanner(System.in);
    private Connection connection;
 	private ResultSet result;
 	private Statement state;
 	ResultSetMetaData resultMeta;
 	PreparedStatement prepare;
 	boolean exist;
 	private String query;
 	private String date;
    private String nom ;
 	private int num;
 	private  String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop;"; 
    private  String username = "sa"; 
    private  String password = "sa"; 
    private Event event2;
 	private Date eventD;
 	private Date eventDFin;
 	java.sql.Date sqlDate;
 	java.sql.Date sqlDateF;

 	   public EventDAO(String url, String username, String password) throws SQLException{
 	        this.url = url; 
 	        this.username = username; 
 	        this.password = password; 
 	      
 	        connection = DriverManager.getConnection(url, username, password);
 	    }
 	    
 	   public EventDAO() throws SQLException{
 	        System.out.println("Entrez vos informations de connexion: \n "); 
 	        System.out.println("Url : \n");
 	         url = sc.nextLine(); 
 	        System.out.println("User : \n");
 	         username = sc.nextLine(); 
 	        System.out.println("password : \n");
 	         password = sc.nextLine(); 
 	         
 	         connection = DriverManager.getConnection(url, username, password);
 	        
 	    }
 	    
 	   public void SaveEvent(Event event) throws SQLException{
 
 	        connection = DriverManager.getConnection(url, username, password);
 	        
 	        if (event.Aurl = true) 
 	        
 	       num = 1;
 	        query = "SELECT EVENT_NAME, EVENT_DATE_START, EVENT_DATE_END, EVENT_DISCOUNT_VALUE, EVENT_IMAGE_URL  from Event ";
 	         
 	       if (event.Aurl = false) 
 	       	System.out.println("test");
 	      num = 2;
 	 	        query = "SELECT EVENT_NAME, EVENT_DATE_START, EVENT_DATE_END, EVENT_DISCOUNT_VALUE  from Event ";
 	 	        
 	       
 	      // String query = "SELECT * from Auteur"; 
 	       state = connection.createStatement();
 	       result = state.executeQuery(query);
 	      resultMeta = result.getMetaData();
 	      
 	      if (result.next()){  
 	    	  
 	    	
	 	      nom = result.getString("EVENT_NAME");
	 	     date = result.getString("EVENT_DATE_START");
	 	
 	       if (nom.equals(event.getName())){
 	    	   	if (date.equals(event.getDate())) {
 	    	  JOptionPane.showMessageDialog(new JFrame(), "Event dÃ©jÃ  enregistrÃ©");
 	    	  }
 	    	  
 	       }else {
 	    		
 	    	   if (event.Aurl = true)
 	    	  prepare = connection.prepareStatement("insert into dbo.Event VALUES(?,?,?,?,?);");
 	    	 //
 	    	try {
				eventD = event.stringToDate( event.getDate());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 	    	 sqlDate = new java.sql.Date(eventD.getTime());
 	    	 
 	    	try {
				eventDFin = event.stringToDate( event.getDateFin());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    	 sqlDateF = new java.sql.Date(eventDFin.getTime());
 	    	    prepare.setString(1, event.getName());
	 	        prepare.setDate(2, sqlDate);
	 	        prepare.setDate(3, sqlDateF);
	 	        prepare.setDouble(4, event.getDiscount());
	 	        prepare.setString(5, event.getUrl());
	 	        
	 	        prepare.execute();
 	    	  if (event.Aurl = false)
 	 	    	  prepare = connection.prepareStatement("insert into dbo.Event VALUES(?,?,?,?);");
 	    	  
	 	        prepare.setString(1, event.getName());
	 	       prepare.setDate(2, sqlDate);
	 	        prepare.setDate(3, sqlDateF);
	 	        prepare.setDouble(4, event.getDiscount());
	 	        
	 	        prepare.execute();
	 					
	 		JOptionPane.showMessageDialog(new JFrame(), event.getName() + " mis dans dbb");}}}
 	   
 	   public void UpdateEvent(Event event) throws SQLException{
 		  
	        connection = DriverManager.getConnection(url, username, password);
	        
	        if (event.Aurl = true) 
	        
	       num = 1;
	        query = "SELECT EVENT_NAME, EVENT_DATE_START, EVENT_DATE_END, EVENT_DISCOUNT_VALUE, EVENT_IMAGE_URL  from Event ";
	         
	       if (event.Aurl = false) 
	       	System.out.println("test");
	      num = 2;
	 	        query = "SELECT EVENT_NAME, EVENT_DATE_START, EVENT_DATE_END, EVENT_DISCOUNT_VALUE  from Event ";
	 	        
	       
	      // String query = "SELECT * from Auteur"; 
	       state = connection.createStatement();
	       result = state.executeQuery(query);
	      resultMeta = result.getMetaData();
	      
	      if (result.next()){  
	    	  
	    	
	 	      nom = result.getString("EVENT_NAME");
	 	     date = result.getString("EVENT_DATE_START");
	 	
	       if (nom.equals(event.getName())){
	    	   	if (date.equals(event.getDate())) {
	    	  JOptionPane.showMessageDialog(new JFrame(), "Event dÃ©jÃ  enregistrÃ©");
	    	  }
	    	  
	       }else {
	    		
	    	   if (event.Aurl = true)
	    	  prepare = connection.prepareStatement("update into dbo.Event VALUES(?,?,?,?,?);");
	    	 //
	    	try {
				eventD = event.stringToDate( event.getDate());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 sqlDate = new java.sql.Date(eventD.getTime());
	    	 
	    	try {
				eventDFin = event.stringToDate( event.getDateFin());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 sqlDateF = new java.sql.Date(eventDFin.getTime());
	    	    prepare.setString(1, event.getName());
	 	        prepare.setDate(2, sqlDate);
	 	        prepare.setDate(3, sqlDateF);
	 	        prepare.setDouble(4, event.getDiscount());
	 	        prepare.setString(5, event.getUrl());
	 	        
	 	        prepare.execute();
	    	  if (event.Aurl = false)
	 	    	  prepare = connection.prepareStatement("update into dbo.Event VALUES(?,?,?,?);");
	    	  
	 	        prepare.setString(1, event.getName());
	 	       prepare.setDate(2, sqlDate);
	 	        prepare.setDate(3, sqlDateF);
	 	        prepare.setDouble(4, event.getDiscount());
	 	        
	 	        prepare.execute();
	 					
	 		JOptionPane.showMessageDialog(new JFrame(), event.getName() + " mis dans dbb");}}}
 	   
 	   
 	   public Event searchEvent(String name) throws SQLException {
 		  connection = DriverManager.getConnection(url, username, password); String
 		 
 		  query = "SELECT * from Event where EVENT_NAME = '"+ name +"'";
 		  
 		  state = connection.createStatement();
 		  // String query = "SELECT * from Author"; state =
 		   result = state.executeQuery(query); 
 		  
 		  if (result.next()){
 		  
 		 return new Event(result.getString("EVENT_NAME"), result.getString("EVENT_DATE_START"), result.getString("EVENT_DATE_END"), result.getDouble("EVENT_DISCOUNT_VALUE"), result.getString("EVENT_IMAGE_URL") );
 		  }
 		  System.out.println("Event inexistant !"); 
 		  return  new Event();
 		  
 		  }
 	  public Event searchEventDate(String date) throws SQLException {
 		  connection = DriverManager.getConnection(url, username, password); String
 		  query = "SELECT * from Event where EVENT_DATE_START = '"+ date +"'";
 		  
 		  
 		  // String query = "SELECT * from Author"; state =
 		  connection.createStatement(); result = state.executeQuery(query); 
 		  
 		  if (result.next()){
 		  
 		 return new Event(result.getString("EVENT_NAME"), result.getString("EVENT_DATE_START"), result.getString("EVENT_DATE_END"), result.getDouble("EVENT_DISCOUNT_VALUE"), result.getString("EVENT_IMAGE_URL") );
 		  }
 		  System.out.println("Event inexistant !"); 
 		  return  new Event();
 		  
 		  }
 		   
 	   
	  public Long getId(Event event) throws SQLException {
	  
	  connection = DriverManager.getConnection(url, username, password); String
	  query = "SELECT * from Event where EVENT_NAME = '"+event.getName()+"'";
	  
	  
	  // String query = "SELECT * from Author"; state =
	  connection.createStatement(); result = state.executeQuery(query); resultMeta
	  = result.getMetaData();
	  
	  if (result.next()){
	  
	  System.out.println(result.getLong(1)); return result.getLong(1); }
	  System.out.println("Event inexistant !"); return 0l;
	  
	  }
	  
	  public void createEvent(String name, String date, String dateFin, double remise) {
		   
		   Event e1 = new Event(name, date, dateFin, remise); 
		   try {
			SaveEvent(e1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public void createEvent(Event event) {
		   
		
		   try {
			SaveEvent(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
          
           public List authorEvent(){
                      
                      List<Event> eventl = new ArrayList<>(); 
                      
                       try {
		connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       String query = "SELECT * from Event ";
       try {
		state = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		result = state.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       try {
		while (result.next()) {
                    

			eventl.add(new Event(result.getString("EVENT_NAME"), result.getString("EVENT_DATE_START"), result.getString("EVENT_DATE_END"), result.getDouble("EVENT_DISCOUNT_VALUE"), result.getString("EVENT_IMAGE_URL") ));
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return eventl;
                  }
	  
 	   public static void main(String []args) throws SQLException {
 		   
 		  Event e2 = new Event("Ete","21-06-2020", "21-09-2020", 5.5);

 		   
 		   EventDAO eD = new EventDAO("jdbc:sqlserver://localhost:1433;databaseName=BookShop;", "sa", "sa");
 		   eD.SaveEvent(e2);
 	   }
 		
}

