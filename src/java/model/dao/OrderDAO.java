/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import db.Database;
import java.text.DateFormat;
import model.entity.Address;
import model.entity.Book;
import model.entity.Customer;
import model.entity.Order;
import model.entity.ShippingOffer;

/**
 *
 * @author cda611
 */
public class OrderDAO implements DAO<Order, Book> {

    public final String QUERY_INSERT_ORDER = "INSERT INTO [dbo].[ORDER]\n"
            + "	([CUSTOMER_ID],[DELIVERY_ADDRESS_ID],[BILLING_ADDRESS_ID],[SHIPPING_OFFER_ID],[ORDER_CREATION_DATE],[ORDER_SHIPPING_TIME_LIMIT],\n"
            + "	[ORDER_USER_IP],[ORDER_COMMENT],[ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE])\n"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public final String QUERY_INSERT_ORDER_ROW = "";
    public final String SELECT_LAST_ID = "SELECT @@IDENTITY as ID";

    ResultSetMetaData resultMeta;
    PreparedStatement prepare;
    boolean exist;
    String query;
    Date packD;
    java.sql.Date sqlDate;
    String nom;
    String prenom;
    Customer c = new Customer();
    ShippingOffer sO = new ShippingOffer();
    Address a = new Address();
    Address b = new Address();
    List<Book> lBook;

    public OrderDAO() {

    }

    //récupere tous les livres d'un client selon une commande du dernier mois par Id client
    public List<Book> getListLast(Long id) throws SQLException, NamingException {

        lBook = new ArrayList();

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();

        String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID =" + id + " and [dbo].[ORDER].ORDER_CREATION_DATE >= '2020-09-12T00:00:00'));";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = null;

        while (rs.next()) {

            book = new Book();
            book.setIsbn(rs.getString(1));

            // Obtains the publisher matching the ID
            // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
            // Obtains the VAT matching the ID
            //object.setVat(new VatDAO().get(rs.getInt(3)));
            book.setTitle(rs.getString(4));
            book.setSubTitle(rs.getString(5));
            book.setPrice(rs.getFloat(6));
            book.setCoverURL(rs.getString(7));
            book.setSummary(rs.getString(8));
            book.setQuantity(rs.getInt(9));
            book.setShelf(rs.getString(10));
            book.setPostIt(rs.getString(11));

            lBook.add(book);

        }
        connexion.close();
        stmt.close();
        return lBook;
    }

    //récupere tous les livres d'un client selon une commande par Id client
    public List<Book> getList(Long id) throws SQLException, NamingException {

        lBook = new ArrayList();

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in(\n" + "Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID = " + id + "));";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = null;

        while (rs.next()) {

            book = new Book();
            book.setIsbn(rs.getString(1));

            // Obtains the publisher matching the ID
            // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
            // Obtains the VAT matching the ID
            //object.setVat(new VatDAO().get(rs.getInt(3)));
            book.setTitle(rs.getString(4));
            book.setSubTitle(rs.getString(5));
            book.setPrice(rs.getFloat(6));
            book.setCoverURL(rs.getString(7));
            book.setSummary(rs.getString(8));
            book.setQuantity(rs.getInt(9));
            book.setShelf(rs.getString(10));
            book.setPostIt(rs.getString(11));

            lBook.add(book);

        }

        connexion.close();
        stmt.close();
        return lBook;
    }

    //récupere tous les livres d'un client selon une commande des 6 derniers mois  par Id client
    public List<Book> getListSixMonth(Long id) throws SQLException, NamingException {

        lBook = new ArrayList();

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = "select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID =" + id + " and [dbo].[ORDER].ORDER_CREATION_DATE >= '2020-09-12T00:00:00'and  [dbo].[ORDER].ORDER_CREATION_DATE <= '2020-04-12T00:00:00' ));";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = null;

        while (rs.next()) {

            book = new Book();
            book.setIsbn(rs.getString(1));

            // Obtains the publisher matching the ID
            // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
            // Obtains the VAT matching the ID
            //object.setVat(new VatDAO().get(rs.getInt(3)));
            book.setTitle(rs.getString(4));
            book.setSubTitle(rs.getString(5));
            book.setPrice(rs.getFloat(6));
            book.setCoverURL(rs.getString(7));
            book.setSummary(rs.getString(8));
            book.setQuantity(rs.getInt(9));
            book.setShelf(rs.getString(10));
            book.setPostIt(rs.getString(11));

            lBook.add(book);

        }

        connexion.close();
        stmt.close();
        return lBook;
    }

// récupere tous les livres d'une commande plus ancienne que 6 mois par id Client 
    public List<Book> getListPast(Long id) throws SQLException, NamingException {

        lBook = new ArrayList();

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = " select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id in( Select Order_id from [dbo].[ORDER] where [dbo].[ORDER].CUSTOMER_ID =" + id + "  and  [dbo].[ORDER].ORDER_CREATION_DATE <= '2020-04-12T00:00:00' ));";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = null;

        while (rs.next()) {

            book = new Book();
            book.setIsbn(rs.getString(1));

            // Obtains the publisher matching the ID
            // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
            // Obtains the VAT matching the ID
            //object.setVat(new VatDAO().get(rs.getInt(3)));
            book.setTitle(rs.getString(4));
            book.setSubTitle(rs.getString(5));
            book.setPrice(rs.getFloat(6));
            book.setCoverURL(rs.getString(7));
            book.setSummary(rs.getString(8));
            book.setQuantity(rs.getInt(9));
            book.setShelf(rs.getString(10));
            book.setPostIt(rs.getString(11));

            lBook.add(book);

        }

        connexion.close();
        stmt.close();
        return lBook;
    }

    //retourne  le nom du statut de la commande
    public List<Order> getStatusOrder(String id) throws SQLException {
        Order order;
        List<Order> lOrder = new ArrayList(); 
        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = "select * from dbo.[ORDER] where [ORDER_ID] in(Select [ORDER_ID] from [dbo].[ASSOC_STATUS_ORDER] where [ORDER_STATUS_ID]= 2 and dbo.[ORDER].CUSTOMER_ID= "+ id+ " );";

        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            order = new Order();
            order.setId(rs.getLong("ORDER_ID"));
            order.setOrderStatus("en cours");
            order.setCommentaire(rs.getString("Order_Comment"));
            order.setDateLivraison(rs.getString("Order_Creation_date"));
            
            lOrder.add(order); 
        }

        connexion.close();
        return lOrder;
    }

    public Order setStatusOrder(Order object) throws SQLException, NamingException {
        Order order = new Order();
   
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        int result = -1;
 
        connection = database.getConnection();
         String query = "INSERT INTO [dbo].[ASSOC_STATUS_ORDER]([ORDER_ID] ,[ORDER_STATUS_ID]  ,[ASSOC_STATUS_ORDER_DATE] ,[ASSOC_STATUS_ORDER_POST_IT])  VALUES   (?,?,?,?);";
      
        statement = connection.prepareStatement(query);
        
        statement.setLong(1, object.getId());
        statement.setInt(2, 2);
        statement.setString(3, object.getDateOrder());
        statement.setString(4, "insertion");
       
        
        result = statement.executeUpdate();

        statement.close();
        connection.close();
 
        
        
       
        return order;
    }

    @Override
    public List<Order> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Order getById(String id) throws Exception {
        Order order = null;

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = "Select * from [dbo].[ORDER] where [dbo].[ORDER].Order_id =" + id + "";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            order = new Order();
            order.setCustomer(new CustomerDAO().getById(rs.getLong("Customer_Id")));
        }
        connexion.close();
        return order;
    }

    public List<Book> getListById(String id) throws SQLException {
        lBook = new ArrayList();

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = "select * from Book where BOOK_ISBN in (Select [BOOK_ISBN] from [dbo].[ORDER_ROW] where Order_id=" + id + ");";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Book book = null;

        while (rs.next()) {

            book = new Book();
            book.setIsbn(rs.getString(1));

            // Obtains the publisher matching the ID
            // object.setPublisher(new PublisherDAO().get(rs.getInt(2)));
            // Obtains the VAT matching the ID
            //object.setVat(new VatDAO().get(rs.getInt(3)));
            book.setTitle(rs.getString(4));
            book.setSubTitle(rs.getString(5));
            book.setPrice(rs.getFloat(6));
            book.setCoverURL(rs.getString(7));
            book.setSummary(rs.getString(8));
            book.setQuantity(rs.getInt(9));
            book.setShelf(rs.getString(10));
            book.setPostIt(rs.getString(11));

            lBook.add(book);

        }
        stmt.close();
        connexion.close();
        return lBook;
    }

    @Override
    public void update(Order object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getById(Book id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Order object) throws Exception {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();
        statement = connection.prepareStatement(QUERY_INSERT_ORDER);

        statement.setLong(1, object.getCustomer().getCustomerId());
        statement.setInt(2, object.getAdresseLivId());
        statement.setInt(3, object.getAdresseBilId());
        statement.setLong(4, object.getShippingId());
        statement.setString(5, DateFormat.getInstance().format(new Date()));
        statement.setString(6, DateFormat.getInstance().format(new Date()));
        statement.setString(7, object.getIpCustomer());
        statement.setString(8, object.getCommentaire());
        statement.setDouble(9, object.getPriceTaxFree());

        object.setId(getLastId());

        statement.executeUpdate();

        //statement.close();
    }

    public Long getLastId() throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Long lastId = -1L;

        connection = database.getConnection();
        statement = connection.prepareStatement(SELECT_LAST_ID);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getLong(1);
        }

        return lastId;
    }

}
