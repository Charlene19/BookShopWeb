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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.entity.Package;




public class PackageDAO {
	
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
		final ImageIcon icon = new ImageIcon("icone.png");
	    Image image2 = icon.getImage().getScaledInstance(32,32,0);

	 	   public PackageDAO(String url, String username, String password) throws SQLException{
	 	        this.url = url; 
	 	        this.username = username; 
	 	        this.password = password; 
	 	      
	 	        connection = DriverManager.getConnection(url, username, password);
	 	    }
	 	    
	 	   public PackageDAO() throws SQLException{
	 	        System.out.println("Entrez vos informations de connexion: \n "); 
	 	        System.out.println("Url : \n");
	 	         url = sc.nextLine(); 
	 	        System.out.println("User : \n");
	 	         username = sc.nextLine(); 
	 	        System.out.println("password : \n");
	 	         password = sc.nextLine(); 
	 	         
	 	         connection = DriverManager.getConnection(url, username, password);
	 	        
	 	    }
	 	    
	 	   public void SavePackage(Package pack) throws SQLException{
	 
	 	        connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT [PACKAGE_TRACKING_NUMBER]\r\n" + 
	 	       		"           ,[PACKAGE_SHIPPING_DATE]\r\n" + 
	 	       		"           ,[PACKAGE_POST_IT] where PACKAGE_TRACKING_NUMBER = '"+ ((Package) pack).getTracker() +"'";
	 	       
	  
	 	      // String query = "SELECT * from Auteur"; 
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	
		 	     
	 	    	  JOptionPane.showMessageDialog(new JFrame(), "Colis déjà enregistré !");
	 	    	   
	 	    	  
	 	       }else {
	 	    	  prepare = connection.prepareStatement("insert into dbo.PACKAGE VALUES(?,?,?);");
	 	    	 try {
	 				packD = pack.stringToDate( pack.getDateLivraison());
	 			} catch (Exception e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 	    	 sqlDate = new java.sql.Date(packD.getTime()); 
			 	  
		 	        prepare.setString(1, pack.getTracker());
		 	        prepare.setDate(2, sqlDate);
		 	        prepare.setString(3, pack.getPostIt());
		 	        
		 	        prepare.execute();
		 					
		 		JOptionPane.showMessageDialog(new JFrame(), pack.getTracker() + " mis dans dbb");}}
	 	   
	 	   public Long getId(Package pack) throws SQLException {
	 		   
	 		   connection = DriverManager.getConnection(url, username, password);
	 	       String query = "SELECT * from Package where PACKAGE_TRACKING_NUMBER = '"+pack.getTracker()+"'";
	 	       
	  
	 	      // String query = "SELECT * from Author"; 
	 	       state = connection.createStatement();
	 	       result = state.executeQuery(query);
	 	      resultMeta = result.getMetaData();
	 	      
	 	      if (result.next()){  
	 	    	  
	 	    	System.out.println(result.getLong(1));
		 	    return result.getLong(1);
	 	      }
	 	     System.out.println("Package inexistant !");
	 	    	return 0l;  
	 	      
	 	   }
	 	   
	 	
	 	  public void createPackage(Package pack) {
	 		   
	 		  
	 		   try {
				SavePackage(pack);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
}
	 	  
	 	  public void searchPackage(Package pack) throws SQLException {
	 		  
	 	      Box box = Box.createVerticalBox();
	 	        JCheckBox cbox1 = new JCheckBox("par tracker ?");
	 	        JCheckBox cbox2 = new JCheckBox("par date ?");
	 	        JCheckBox cbox3 = new JCheckBox("par status ?");
	 	        box.add(cbox1);
	 	        box.add(cbox2);
	 	        box.add(cbox3);
	 	        JOptionPane.showMessageDialog(new JFrame(), box);
	 	        
	 	       if(cbox1.isSelected()) {
	 	    	  connection = DriverManager.getConnection(url, username, password);
		 	       String query = "SELECT * from Package where PACKAGE_TRACKING_NUMBER = '"+pack.getTracker()+"'";
		 	       
		  
		 	    
		 	       state = connection.createStatement();
		 	       result = state.executeQuery(query);
		 	      resultMeta = result.getMetaData();
		 	      
		 	      if (result.next()){  
		 	    	  
		 	    	Package packS = new Package(result.getString("[PACKAGE_TRACKING_NUMBER]"), result.getString("[PACKAGE_SHIPPING_DATE]"), result.getString("[PACKAGE_POST_IT]"));
		 	    	JOptionPane.showMessageDialog(new JFrame(), packS.toString(), "Résultat recherche", 1, new ImageIcon(image2));
		 	      }
		 	     JOptionPane.showMessageDialog(new JFrame(), "Package inexistant", "Résultat recherche", 1, new ImageIcon(image2));
		 	    	
		 	      
	 	       }
	 	       
		       if(cbox2.isSelected()) {
		 	    	  connection = DriverManager.getConnection(url, username, password);
			 	       String query = "SELECT * from Package where [PACKAGE_SHIPPING_DATE] = '"+pack.getDateLivraison()+"'";
			 	       
			  
			 	    
			 	       state = connection.createStatement();
			 	       result = state.executeQuery(query);
			 	      resultMeta = result.getMetaData();
			 	      
			 	      if (result.next()){  
			 	    	  
			 	    	Package packS = new Package(result.getString("[PACKAGE_TRACKING_NUMBER]"), result.getString("[PACKAGE_SHIPPING_DATE]"), result.getString("[PACKAGE_POST_IT]"));
			 	    	JOptionPane.showMessageDialog(new JFrame(), packS.toString(), "Résultat recherche", 1, new ImageIcon(image2));
			 	      }
			 	     JOptionPane.showMessageDialog(new JFrame(), "Package inexistant", "Résultat recherche", 1, new ImageIcon(image2));
			 	    	
			 	      
		 	       }
		       
		       if(cbox3.isSelected()) {
		 	    	  connection = DriverManager.getConnection(url, username, password);
			 	       String query = "SELECT * from PACKAGE_STATUS_ID where [PACKAGE_id] = '"+pack.getId()+"'";
			 	       
			  
			 	    
			 	       state = connection.createStatement();
			 	       result = state.executeQuery(query);
			 	      resultMeta = result.getMetaData();
			 	      
			 	      if (result.next()){  
			 	    	  
			 	    	Package packS = new Package(result.getString("[PACKAGE_TRACKING_NUMBER]"), result.getString("[PACKAGE_SHIPPING_DATE]"), result.getString("[PACKAGE_POST_IT]"));
			 	    	JOptionPane.showMessageDialog(new JFrame(), packS.toString(), "Résultat recherche", 1, new ImageIcon(image2));
			 	      }
			 	     JOptionPane.showMessageDialog(new JFrame(), "Package inexistant", "Résultat recherche", 1, new ImageIcon(image2));
			 	    	
			 	      
		 	       }
	 		  
	 	  }
}

