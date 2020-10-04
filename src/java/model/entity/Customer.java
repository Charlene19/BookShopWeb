package model.entity;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import model.entity.Address;

/**
 *
 * @author cda611
 */
public class Customer implements Serializable {

    
    private Connection connection;
    private ResultSet result;
    private Statement state;
    private String query;
    ResultSetMetaData resultMeta;
    PreparedStatement prepare;
    private String url = "jdbc:sqlserver://localhost;databaseName=BookShop;";
    private String username = "sa";
    private String password = "sa";
    private Customer c1;

    private static final long serialVersionUID = 1L;
    private Long customerId;
    private String customerLName;
    private String customerFName;
    private String customerEmail;
    private String customerUsername;
    private String customerPassword;
    private String customerPostIt;
    private Date clientDate;
    private Collection<Address> addressCollection;
    private Collection<Address> addressCollection1;
    private String clDate;

    public Customer() {
    }

    public Customer(Long customerId) {
        this.customerId = customerId;
    }

    public Customer(Long customerId, String customerLName, String customerFName, String customerEmail, String customerUsername, String customerPassword, String customerPostIt, String clDate) {
        this.customerId = customerId;
        this.customerLName = customerLName;
        this.customerFName = customerFName;
        this.customerEmail = customerEmail;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
        this.customerPostIt = customerPostIt;
        this.clDate = clDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLName() {
        return customerLName;
    }

    public void setCustomerLName(String customerLName) {
        this.customerLName = customerLName;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPostIt() {
        return customerPostIt;
    }

    public void setCustomerPostIt(String customerPostIt) {
        this.customerPostIt = customerPostIt;
    }

    public Date getClientDate() {
        return clientDate;
    }

    public void setClientDate(Date clientDate) {
        this.clientDate = clientDate;
    }

    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public Collection<Address> getAddressCollection1() {
        return addressCollection1;
    }

    public void setAddressCollection1(Collection<Address> addressCollection1) {
        this.addressCollection1 = addressCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    public Customer getClientById(int id) throws SQLException {

        connection = DriverManager.getConnection(url, username, password);
        query = "SELECT * from Customer where Customer_Id = '" + id + "'";
        state = connection.createStatement();

        connection.createStatement();
        result = state.executeQuery(query);

        if (result.next()) {

            c1 = new Customer(result.getLong("CUSTOMER_ID"), result.getString("CUSTOMER_L_NAME"), result.getString("CUSTOMER_F_NAME"), result.getString("CUSTOMER_EMAIL"), result.getString("CUSTOMER_USERNAME"), result.getString("CUSTOMER_PASSWORD"), result.getString("CUSTOMER_POST_IT"), result.getString("CLIENT_DATE"));

        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Client inexistant");
        }
        return c1;

    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return !((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId)));
    }

    @Override
    public String toString() {
        return "librairie.Customer[ customerId=" + customerId + " ]";
    }

}
