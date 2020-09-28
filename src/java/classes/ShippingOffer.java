/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/*import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;*/
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cda611
 */
/*
 * @Entity
 * 
 * @Table(name = "SHIPPING_OFFER")
 * 
 * @NamedQueries({
 * 
 * @NamedQuery(name = "ShippingOffer.findAll", query =
 * "SELECT s FROM ShippingOffer s"),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferId", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferId = :shippingOfferId"),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferName", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferName = :shippingOfferName"
 * ),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferDetails", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferDetails = :shippingOfferDetails"
 * ),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferConditions", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferConditions = :shippingOfferConditions"
 * ),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferHtPrice", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferHtPrice = :shippingOfferHtPrice"
 * ),
 * 
 * @NamedQuery(name = "ShippingOffer.findByShippingOfferPostIt", query =
 * "SELECT s FROM ShippingOffer s WHERE s.shippingOfferPostIt = :shippingOfferPostIt"
 * )})
 */

public class ShippingOffer implements Serializable {
	
	
	  private Connection connection;
	 	private ResultSet result;
	 	private Statement state;
	 	private String query;
	 	ResultSetMetaData resultMeta;
	 	PreparedStatement prepare;
		private  String url = "jdbc:sqlserver://CHARLèNE-PC;databaseName=BookShop;"; 
	    private  String username = "cha"; 
	    private  String password = "eminem"; 
    private static final long serialVersionUID = 1L;
	/*
	 * @Id
	 * 
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "SHIPPING_OFFER_ID")
	 */
    private Long shippingOfferId;
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "SHIPPING_OFFER_NAME")
	 */
    private String shippingOfferName;
   // @Column(name = "SHIPPING_OFFER_DETAILS")
    private String shippingOfferDetails;
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "SHIPPING_OFFER_CONDITIONS")
	 */
    private String shippingOfferConditions;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "SHIPPING_OFFER_HT_PRICE")
	 */
    private double shippingOfferHtPrice;
    //@Column(name = "SHIPPING_OFFER_POST_IT")
    private String shippingOfferPostIt;
	/*
	 * @JoinColumn(name = "CARRIER_ID", referencedColumnName = "CARRIER_ID")
	 * 
	 * @ManyToOne(optional = false) private Carrier carrierId;
	 */
    ShippingOffer sO; 

    public ShippingOffer() {
    }

    public ShippingOffer(Long shippingOfferId) {
        this.shippingOfferId = shippingOfferId;
    }

    public ShippingOffer(Long shippingOfferId, String shippingOfferName, String shippingOfferConditions, double shippingOfferHtPrice) {
        this.shippingOfferId = shippingOfferId;
        this.shippingOfferName = shippingOfferName;
        this.shippingOfferConditions = shippingOfferConditions;
        this.shippingOfferHtPrice = shippingOfferHtPrice;
    }

    public Long getShippingOfferId() {
        return shippingOfferId;
    }

    public void setShippingOfferId(Long shippingOfferId) {
        this.shippingOfferId = shippingOfferId;
    }

    public String getShippingOfferName() {
        return shippingOfferName;
    }

    public void setShippingOfferName(String shippingOfferName) {
        this.shippingOfferName = shippingOfferName;
    }

    public String getShippingOfferDetails() {
        return shippingOfferDetails;
    }

    public void setShippingOfferDetails(String shippingOfferDetails) {
        this.shippingOfferDetails = shippingOfferDetails;
    }

    public String getShippingOfferConditions() {
        return shippingOfferConditions;
    }

    public void setShippingOfferConditions(String shippingOfferConditions) {
        this.shippingOfferConditions = shippingOfferConditions;
    }

    public double getShippingOfferHtPrice() {
        return shippingOfferHtPrice;
    }

    public void setShippingOfferHtPrice(double shippingOfferHtPrice) {
        this.shippingOfferHtPrice = shippingOfferHtPrice;
    }

    public String getShippingOfferPostIt() {
        return shippingOfferPostIt;
    }

    public void setShippingOfferPostIt(String shippingOfferPostIt) {
        this.shippingOfferPostIt = shippingOfferPostIt;
    }

	/*
	 * public Carrier getCarrierId() { return carrierId; }
	 * 
	 * public void setCarrierId(Carrier carrierId) { this.carrierId = carrierId; }
	 */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shippingOfferId != null ? shippingOfferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingOffer)) {
            return false;
        }
        ShippingOffer other = (ShippingOffer) object;
        if ((this.shippingOfferId == null && other.shippingOfferId != null) || (this.shippingOfferId != null && !this.shippingOfferId.equals(other.shippingOfferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "librairie.ShippingOffer[ shippingOfferId=" + shippingOfferId + " ]";
    }
    public ShippingOffer getShippingById(int id) throws SQLException {
    	
  	  connection = DriverManager.getConnection(url, username, password); 
  	   query = "SELECT * from SHIPPING_OFFER where SHIPPING_OFFER_ID = '"+ id +"'";
  	   state = connection.createStatement();
  	  
  	  connection.createStatement();
  	  result = state.executeQuery(query); 
  	
  	  
  	  if (result.next()){
  	  
  	  sO = new ShippingOffer(result.getLong("SHIPPING_OFFER_ID"), result.getString("SHIPPING_OFFER_NAME"), result.getString("SHIPPING_OFFER_CONDITIONS")
  		    ,result.getDouble("SHIPPING_OFFER_HT_PRICE"));
  	  
  	  }else {
  		  JOptionPane.showMessageDialog(new JFrame(), "Transporteur inexistant");
  	  }
		return sO;
  	  
  	
  }
    
    public static void main(String []args) throws SQLException {
    	ShippingOffer  c = new ShippingOffer(); 
    	System.out.println(c.getShippingById(1));
    }
    

}
