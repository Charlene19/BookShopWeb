package model.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
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
public class Address implements Serializable {

    private Collection<Carrier> carrierCollection;

    private static final long serialVersionUID = 1L;
    private Long addressId;
    private String addressCompanyName;
    private String addressLName;
    private String addressFName;
    private String addressStreet;
    private String addressStreetExtra;
    private String addressPostcode;
    private String addressCity;
    private String addressPhone;
    private String addressPhoneExtra;
    private Collection<Customer> customerCollection;
    private Collection<Customer> customerCollection1;
    private Connection connection;
    private ResultSet result;
    private Statement state;
    private String query;
    ResultSetMetaData resultMeta;
    PreparedStatement prepare;
    private String url = "jdbc:sqlserver://localhost;databaseName=BookShop;";
    private String username = "sa";
    private String password = "sa";
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

    public Address(String addressStreet, String addressPostcode, String addressCity) {

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
        query = "SELECT * from Address where Address_Id = '" + id + "'";
        state = connection.createStatement();

        connection.createStatement();
        result = state.executeQuery(query);

        if (result.next()) {

            a1 = new Address(result.getLong("Address_ID"), result.getString("ADDRESS_COMPANY_NAME"), result.getString("ADDRESS_L_NAME"),
                     result.getString("ADDRESS_F_NAME"), result.getString("ADDRESS_STREET"),
                     result.getString("ADDRESS_STREET_EXTRA"),
                     result.getString("ADDRESS_POSTCODE"),
                     result.getString("ADDRESS_CITY"), result.getString("ADDRESS_PHONE"), result.getString("ADDRESS_PHONE_EXTRA"));

        } else {
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
