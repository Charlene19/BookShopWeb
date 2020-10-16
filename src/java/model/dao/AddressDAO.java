package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Address;

public class AddressDAO {

// Afficher Adresse de livraison pour un client donné   
    public static List<Address> listDeliveryAddressByIdCustomer(int a) throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();

        String viewAddressByIdCustomer = "select ADDRESS.* from dbo.ASSOC_CUSTOMER_DELIVERY_ADDRESS inner join"
                + " ADDRESS on dbo.ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID=ADDRESS.ADDRESS_ID"
                + " where CUSTOMER_ID=?";

        Connection db = Database.getInstance().getConnection();

        PreparedStatement pstmt = db.prepareStatement(viewAddressByIdCustomer);
        pstmt.setInt(1, a);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"));
            result.add(address);
        }
        return result;
    }

// Afficher Adresse de facturation pour un client donné   
    public static List<Address> listBillingAddressByIdCustomer(int a) throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();

        String viewAddressByIdCustomer = "select ADDRESS.* from dbo.ASSOC_CUSTOMER_BILLING_ADDRESS inner join"
                + " ADDRESS on dbo.ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID=ADDRESS.ADDRESS_ID"
                + " where CUSTOMER_ID=?";

        Connection db = Database.getInstance().getConnection();

        PreparedStatement pstmt = db.prepareStatement(viewAddressByIdCustomer);
        pstmt.setInt(1, a);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"));
            result.add(address);
        }
        return result;
    }

//Afficher Address vides    
    public static List<Address> listAddressByIdCustomer(int a) throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();

        String viewAddressByIdCustomer = "select * from ADDRESS inner join\n"
                + "ASSOC_CUSTOMER_DELIVERY_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID inner join\n"
                + "CUSTOMER on ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID\n"
                + "where CUSTOMER.CUSTOMER_ID=? and ADDRESS_PHONE_EXTRA='active'";

        Connection db = Database.getInstance().getConnection();

        PreparedStatement pstmt = db.prepareStatement(viewAddressByIdCustomer);
        pstmt.setInt(1, a);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"));
            result.add(address);
        }
        return result;
    }
//chercher si telle addresse existe   

    public static List<Address> listAddressIdem(String a, String b, String c, String d,
            String e, String f, String g, String h, String i) throws SQLException, NamingException {
        List<Address> results = new ArrayList<Address>();

        String addressIdem = "select * from ADDRESS where ADDRESS_COMPANY_NAME=? and ADDRESS_L_NAME=? and ADDRESS_F_NAME=? "
                + "and ADDRESS_STREET=? and ADDRESS_STREET_EXTRA=? and ADDRESS_POSTCODE=? and ADDRESS_CITY=? "
                + "and ADDRESS_PHONE=? and ADDRESS_PHONE_EXTRA=? ";
        Connection db = Database.getInstance().getConnection();

        PreparedStatement pstmt = db.prepareStatement(addressIdem);

        pstmt.setString(1, a);
        pstmt.setString(2, b);
        pstmt.setString(3, c);
        pstmt.setString(4, d);
        pstmt.setString(5, e);
        pstmt.setString(6, f);
        pstmt.setString(7, g);
        pstmt.setString(8, h);
        pstmt.setString(9, i);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"),
                    rs.getString("ADDRESS_PHONE_EXTRA"));
            results.add(address);
        }

        return results;

    }

// 
    public static List<Address> listAllAddress() throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();

        String viewAddress = "select * from ADDRESS ";
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(viewAddress);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address addresse = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"),
                    rs.getString("ADDRESS_PHONE_EXTRA"));
            result.add(addresse);
        }
        return result;
    }

// Inserer addresse    
    public static final String insertion = "insert into ADDRESS (ADDRESS_COMPANY_NAME,ADDRESS_L_NAME,ADDRESS_F_NAME,"
            + "ADDRESS_STREET,ADDRESS_STREET_EXTRA,ADDRESS_POSTCODE,ADDRESS_CITY,ADDRESS_PHONE,ADDRESS_PHONE_EXTRA)\n"
            + "values(?,?,?,?,?,?,?,?,?)";

    public static void insertAddress(String a, String b, String c, String d,
            String e, String f, String g, String h, String i) throws SQLException, NamingException {
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(insertion);

        pstmt.setString(1, a);
        pstmt.setString(2, b);
        pstmt.setString(3, c);
        pstmt.setString(4, d);
        pstmt.setString(5, e);
        pstmt.setString(6, f);
        pstmt.setString(7, g);
        pstmt.setString(8, h);
        pstmt.setString(9, i);
        pstmt.executeUpdate();
        db.close();
    }
//effacer addresse
    public static final String deletion = "delete from ADDRESS where ADDRESS_ID=?;";

    public static void deleteAddress(int id) throws SQLException, NamingException {
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(deletion);

        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
// Mise à jour de l'addresse
    public static final String updates = "update ADDRESS set ADDRESS_COMPANY_NAME=?,ADDRESS_L_NAME=?,"
            + "ADDRESS_F_NAME=?,ADDRESS_STREET=?,ADDRESS_STREET_EXTRA=?,ADDRESS_POSTCODE=?,"
            + "ADDRESS_CITY=?,ADDRESS_PHONE=?,ADDRESS_PHONE_EXTRA=? where ADDRESS_ID=?;";

    public static void updateAddressById(String companyName, String lastName,
            String firstName, String street, String streetExtra, String postcode,
            String city, String phone, String phoneExtra, int id) throws SQLException, NamingException {
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(updates);
        pstmt.setString(1, companyName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, firstName);
        pstmt.setString(4, street);
        pstmt.setString(5, streetExtra);
        pstmt.setString(6, postcode);
        pstmt.setString(7, city);
        pstmt.setString(8, phone);
        pstmt.setString(9, phoneExtra);
        pstmt.setInt(10, id);
        pstmt.executeUpdate();
    }
//afficher les doublons

    public static List<Address> listAddressDoublon() throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();
        String doublon = "select count(*) as nbeDoublon, ADDRESS_COMPANY_NAME,ADDRESS_L_NAME,ADDRESS_F_NAME,ADDRESS_STREET,ADDRESS_STREET_EXTRA,"
                + "ADDRESS_POSTCODE,ADDRESS_CITY,ADDRESS_PHONE,ADDRESS_PHONE_EXTRA from ADDRESS \n"
                + "group by ADDRESS_COMPANY_NAME,ADDRESS_L_NAME,ADDRESS_F_NAME,ADDRESS_STREET,ADDRESS_STREET_EXTRA,ADDRESS_POSTCODE,ADDRESS_CITY,"
                + "ADDRESS_PHONE,ADDRESS_PHONE_EXTRA having count(*)>1;";
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(doublon);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Address addresse = new Address(
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"),
                    rs.getString("ADDRESS_PHONE_EXTRA"));
            result.add(addresse);
        }

        return result;

    }
// Mise à jour de l'addresse
    public static final String desactivation = "update ADDRESS set ADDRESS_PHONE_EXTRA='inactive' from ADDRESS\n"
            + "inner join ASSOC_CUSTOMER_DELIVERY_ADDRESS \n"
            + "on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID inner join\n"
            + "CUSTOMER on ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID where CUSTOMER.CUSTOMER_ID=?;";

    public static void desactivateAddressByIdCustomer(int customerId) throws SQLException, NamingException {
        Connection db = Database.getInstance().getConnection();
        PreparedStatement pstmt = db.prepareStatement(desactivation);

        pstmt.setInt(1, customerId);
        pstmt.executeUpdate();
    }

    /*
    public static final String viewAddressDelivryByIdCustomer="select * from ADDRESS inner join\n" +
        "ASSOC_CUSTOMER_DELIVERY_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n" +
        "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=? and ADDRESS_PHONE_EXTRA='active'";*/
    public static final String viewAddressDelivryByIdCustomer = "select * from ADDRESS inner join\n"
            + "ASSOC_CUSTOMER_DELIVERY_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n"
            + "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=?";

    public static List<Address> listAddressDelivryByIdCustomer(int a) throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();
        Database database = Database.getInstance();
        Connection connection;
        connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(viewAddressDelivryByIdCustomer);
        statement.setInt(1, a);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"),
                    rs.getString("ADDRESS_PHONE_EXTRA"));
            result.add(address);
        }
        return result;
    }
    public static final String viewAddressBillingByIdCustomer = "select * from ADDRESS inner join\n"
            + "ASSOC_CUSTOMER_BILLING_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID\n"
            + "where ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=?";
    /*
      public static final String viewAddressBillingByIdCustomer="select * from ADDRESS inner join\n" +
        "ASSOC_CUSTOMER_BILLING_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID\n" +
        "where ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=? and ADDRESS_PHONE_EXTRA='active'";*/
    public static List<Address> listAddressBillingByIdCustomer(int a) throws SQLException, NamingException {
        List<Address> result = new ArrayList<Address>();
        Database database = Database.getInstance();
        Connection connection;
        connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(viewAddressBillingByIdCustomer);
        statement.setInt(1, a);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("ADDRESS_ID"),
                    rs.getString("ADDRESS_COMPANY_NAME"),
                    rs.getString("ADDRESS_L_NAME"),
                    rs.getString("ADDRESS_F_NAME"),
                    rs.getString("ADDRESS_STREET"),
                    rs.getString("ADDRESS_STREET_EXTRA"),
                    rs.getString("ADDRESS_POSTCODE"),
                    rs.getString("ADDRESS_CITY"),
                    rs.getString("ADDRESS_PHONE"),
                    rs.getString("ADDRESS_PHONE_EXTRA"));
            result.add(address);
        }
        return result;
    }

    public static final String insertionAssocDelivry = "insert into ASSOC_CUSTOMER_DELIVERY_ADDRESS\n"
            + "values(?,?)";

    public static void insertAddressDelivry(String idCustomer, String idAddress) throws SQLException, NamingException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(insertionAssocDelivry);

        pstmt.setString(1, idCustomer);
        pstmt.setString(2, idAddress);
        pstmt.executeUpdate();

    }
    public static final String insertionAssocBilling = "insert into ASSOC_CUSTOMER_BILLING_ADDRESS\n"
            + "values(?,?)";

    public static void insertAddressBilling(String idCustomer, String idAddress) throws SQLException, NamingException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(insertionAssocBilling);

        pstmt.setString(1, idCustomer);
        pstmt.setString(2, idAddress);
        pstmt.executeUpdate();

    }

    public static int LastId() throws SQLException, NamingException {
        int result = -1;
        String viewLastID = "select @@IDENTITY";
        Database database = Database.getInstance();
        Connection connection;
        connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(viewLastID);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            result = rs.getInt(1);
        }

        return result;
    }
    public static final String desactivationDelivryAddress = "update ADDRESS set ADDRESS_PHONE_EXTRA='inactive' from ADDRESS\n"
            + "inner join ASSOC_CUSTOMER_DELIVERY_ADDRESS \n"
            + "on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n"
            + "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=?;";

    public static void desactivateDelivryAddressByIdCustomer(int customerId) throws SQLException, NamingException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(desactivationDelivryAddress);
        pstmt.setInt(1, customerId);
        pstmt.executeUpdate();
    }
    public static final String desactivationBillingAddress = "update ADDRESS set ADDRESS_PHONE_EXTRA='inactive' from ADDRESS\n"
            + "inner join ASSOC_CUSTOMER_BILLING_ADDRESS \n"
            + "on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID\n"
            + "where ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=?;";

    public static void desactivateBillingAddressByIdCustomer(int customerId) throws SQLException, NamingException {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(desactivationBillingAddress);
        pstmt.setInt(1, customerId);
        pstmt.executeUpdate();
    }
}
