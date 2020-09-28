/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author cda611
 */
@Entity
@Table(name = "ADDRESS")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")})

public class Address implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Carrier> carrierCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private Long addressId;
    @Column(name = "ADDRESS_COMPANY_NAME")
    private String addressCompanyName;
    @Column(name = "ADDRESS_L_NAME")
    private String addressLName;
    @Column(name = "ADDRESS_F_NAME")
    private String addressFName;
    @Basic(optional = false)
    @Column(name = "ADDRESS_STREET")
    private String addressStreet;
    @Column(name = "ADDRESS_STREET_EXTRA")
    private String addressStreetExtra;
    @Basic(optional = false)
    @Column(name = "ADDRESS_POSTCODE")
    private String addressPostcode;
    @Basic(optional = false)
    @Column(name = "ADDRESS_CITY")
    private String addressCity;
    @Column(name = "ADDRESS_PHONE")
    private String addressPhone;
    @Column(name = "ADDRESS_PHONE_EXTRA")
    private String addressPhoneExtra;
    @JoinTable(name = "ASSOC_CUSTOMER_DELIVERY_ADDRESS", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")})
    @ManyToMany
    private Collection<Customer> customerCollection;
    @JoinTable(name = "ASSOC_CUSTOMER_BILLING_ADDRESS", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")})
    @ManyToMany
    private Collection<Customer> customerCollection1;
     private Connection connection;
	 	private ResultSet result;
	 	private Statement state;
	 	private String query;
	 	ResultSetMetaData resultMeta;
	 	PreparedStatement prepare;
		private  String url = "jdbc:sqlserver://CHARLèNE-PC;databaseName=BookShop;"; 
	    private  String username = "cha"; 
	    private  String password = "eminem"; 
	    Address a1;

    public Address() {
    }

    public Address(Long addressId) {
        this.addressId = addressId;
    }

    public Address(Long addressId, String addressCompanyName, String addressLName, String addressFName, String addressStreet, String addressStreetExtra, String addressPostcode, String addressCity, String addressPhone, String addressPhoneExtra) {
        this.addressId = addressId;
        this.addressCompanyName = addressCompanyName;
        this.addressLName = addressLName; 
        this.addressFName = addressFName; 
        this.addressStreet = addressStreet;
        this.addressStreetExtra = addressStreetExtra; 
        this.addressPostcode = addressPostcode;
        this.addressCity = addressCity;
        this.addressPhone = addressPhone;
        this.addressPhoneExtra = addressPhoneExtra; 
    }
    
     public Address( String addressStreet, String addressPostcode, String addressCity) {
       
        this.addressStreet = addressStreet;
        this.addressPostcode = addressPostcode;
        this.addressCity = addressCity;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressCompanyName() {
        return addressCompanyName;
    }

    public void setAddressCompanyName(String addressCompanyName) {
        this.addressCompanyName = addressCompanyName;
    }

    public String getAddressLName() {
        return addressLName;
    }

    public void setAddressLName(String addressLName) {
        this.addressLName = addressLName;
    }

    public String getAddressFName() {
        return addressFName;
    }

    public void setAddressFName(String addressFName) {
        this.addressFName = addressFName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressStreetExtra() {
        return addressStreetExtra;
    }

    public void setAddressStreetExtra(String addressStreetExtra) {
        this.addressStreetExtra = addressStreetExtra;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPhoneExtra() {
        return addressPhoneExtra;
    }

    public void setAddressPhoneExtra(String addressPhoneExtra) {
        this.addressPhoneExtra = addressPhoneExtra;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Collection<Customer> getCustomerCollection1() {
        return customerCollection1;
    }

    public void setCustomerCollection1(Collection<Customer> customerCollection1) {
        this.customerCollection1 = customerCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }
    
      public Address getAdressById(int id) throws SQLException {
    	
  	  connection = DriverManager.getConnection(url, username, password); 
  	   query = "SELECT * from Address where Address_Id = '"+ id +"'";
  	   state = connection.createStatement();
  	  
  	  connection.createStatement();
  	  result = state.executeQuery(query); 
  	
  	  
  	  if (result.next()){
  	  
  	  a1 = new Address(result.getLong("Address_ID"), result.getString("ADDRESS_COMPANY_NAME"), result.getString("ADDRESS_L_NAME")
  		      ,result.getString("ADDRESS_F_NAME"), result.getString("ADDRESS_STREET")
  		    	      ,result.getString("ADDRESS_STREET_EXTRA")
  		    	      ,result.getString("ADDRESS_POSTCODE")
  		    	      ,result.getString("ADDRESS_CITY") ,result.getString("ADDRESS_PHONE") ,result.getString("ADDRESS_PHONE_EXTRA"));
  	  
  	  }else {
  		  JOptionPane.showMessageDialog(new JFrame(), "Adresse inexistante");
  	  }
		return a1;
  	  
  	
  }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        return !((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId)));
    }

    @Override
    public String toString() {
        return "librairie.Address[ addressId=" + addressId + " ]";
    }

    public Collection<Carrier> getCarrierCollection() {
        return carrierCollection;
    }

    public void setCarrierCollection(Collection<Carrier> carrierCollection) {
        this.carrierCollection = carrierCollection;
    }
    
}
