/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.entity.Comment;

/**
 *
 * @author cda611
 */
public class CommentDAO implements DAO<Comment, Long> {

    public boolean authorisation;
    public final String QUERY_INSERT_COMMENT
            = "INSERT INTO INSERT INTO [dbo].[COMMENT]([CUSTOMER_ID]  ,[ORDER_ROW_ID]  ,[BOOK_ISBN] ,[COMMENT_TITLE] ,[COMMENT_RATING] ,[COMMENT_TEXT],[COMMENT_DATE] ,[COMMENT_USER_IP])"
            + " values" + "(?,?,?,?,?,?,?,?)";

    public final String QUERY_SELECT_COMMENT = "SELECT * FROM Comment WHERE CUSTOMER_ID = ?";

    public void add(Comment object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        int result = -1;

        connection = database.getConnection();
        statement = connection.prepareStatement(QUERY_INSERT_COMMENT);

        statement.setLong(1, object.getCommId());
        statement.setLong(2, object.getCustomerId());
        statement.setLong(3, object.getOrderId());
        statement.setString(4, object.getIsbnBook());
        statement.setString(5, object.getCommTitre());
        statement.setInt(6, object.getCommNote());
        statement.setString(7, object.getCommTxt());
        statement.setString(8, object.getCommDate());

        result = statement.executeUpdate();

        statement.close();
        connection.close();

    }

    public boolean autorise(String customerId, String isbn) throws SQLException {

        //
        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = "select book_isbn from order_row where order_row.order_id in (Select order_id from [order] where dbo.[order].Customer_id = "+ customerId +" and order_row.book_isbn="+ isbn + " );";
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            authorisation = true;
        }
        connexion.close();
        return authorisation;
    }

    @Override
    public List<Comment> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment getById(Long id) throws Exception {
        Comment comment = null;

        DataSource ds = null;
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("jdbc/bookshop");
        } catch (NamingException ex) {
            System.out.println(">>>Oops:Naming:" + ex.getMessage());
        }

        Connection connexion = null;

        connexion = ds.getConnection();
        String query = QUERY_SELECT_COMMENT;
        Statement stmt = connexion.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            comment = new Comment();
            comment.setCommId(rs.getLong("COMMENT_ID"));
            comment.setCustomerId(rs.getLong("CUSTOMER_ID"));
            comment.setOrderId(rs.getLong("ORDER_ROW_ID"));
            comment.setIsbnBook(rs.getString("BOOK_ISBN"));
            comment.setCommTitre(rs.getString("COMMENT_TITLE"));
            comment.setCommNote(rs.getInt("COMMENT_RATING"));
            comment.setCommTxt(rs.getString("COMMENT_TEXT"));
            comment.setCommDate("COMMENT_DATE");
            comment.setCommIp("COMMENT_USER_IP");
        }
        connexion.close();
        return comment;
    }

    @Override
    public void update(Comment object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comment object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
