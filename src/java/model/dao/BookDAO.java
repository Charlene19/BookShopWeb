package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Author;
import model.entity.Book;
import model.entity.Category;
import model.entity.Keyword;

/**
 *
 * @author zvr
 */
public class BookDAO implements DAO<Book, String> {

    public final String TABLE_BOOK = "BOOK";
    public final String TABLE_ASSOC_BOOK_STATUS = "ASSOC_STATUS_BOOK";
    public final String TABLE_ASSOC_BOOK_KEYWORD = "ASSOC_BOOK_KEYWORD";
    public final String TABLE_ASSOC_BOOK_AUTHOR = "ASSOC_BOOK_AUTHOR";
    public final String TABLE_ASSOC_BOOK_CATEGORY = "ASSOC_BOOK_CATEGORY";

    public final String QUERY_SELECT_ALL_BOOK
            = "SELECT * FROM " + TABLE_BOOK;

    public final String QUERY_SELECT_ASSOC_BOOK_STATUS
            = "SELECT BOOK_STATUS_ID, ASSOC_STATUS_BOOK_DATE, ASSOC_STATUS_BOOK_POST_IT "
            + "FROM " + TABLE_ASSOC_BOOK_STATUS + " "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_KEYWORD
            = "SELECT KEYWORD_ID FROM " + TABLE_ASSOC_BOOK_KEYWORD + " "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_AUTHOR
            = "SELECT AUTHOR_ID FROM " + TABLE_ASSOC_BOOK_AUTHOR + " "
            + "WHERE BOOK_ISBN = ?";
    public final String QUERY_SELECT_ASSOC_BOOK_CATEGORY
            = "SELECT CATEGORY_ID FROM " + TABLE_ASSOC_BOOK_CATEGORY + " "
            + "WHERE BOOK_ISBN = ?";

    @Override
    public void add(Book object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Book> getAll() throws NamingException, SQLException {
        
        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_BOOK);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Book object = null;

        while (resultSet.next()) {

            object = new Book();
            object.setIsbn(resultSet.getString(1));

            // Obtains the publisher matching the ID
            object.setPublisher(new PublisherDAO().getById(resultSet.getInt(2)));
            // Obtains the VAT matching the ID
            object.setVat(new VatDAO().getById(resultSet.getInt(3)));
            object.setTitle(resultSet.getString(4));
            object.setSubTitle(resultSet.getString(5));
            object.setPrice(resultSet.getFloat(6));
            object.setCoverURL(resultSet.getString(7));
            object.setSummary(resultSet.getString(8));
            object.setQuantity(resultSet.getInt(9));
            object.setShelf(resultSet.getString(10));
            object.setPostIt(resultSet.getString(11));

            object.setCategories(getCategories(object.getIsbn()));
            object.setKeywords(getKeywords(object.getIsbn()));
            object.setAuthors(getAuthors(object.getIsbn()));
            object.setStatuses(getStatuses(object.getIsbn()));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Book getById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Book object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Book object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<Keyword> getKeywords(String bookISBN) throws NamingException, SQLException {

        List<Keyword> keywords = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_KEYWORD);
        statement.setString(1, bookISBN);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            keywords.add(new KeywordDAO().getById(resultSet.getInt(1)));
        }

        statement.close();
        
        return keywords;
    }

    private List<Author> getAuthors(String bookISBN) throws NamingException, SQLException {
        
        List<Author> authors = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_AUTHOR);
        statement.setString(1, bookISBN);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            authors.add(new AuthorDAO().getById(resultSet.getInt(1)));
        }

        statement.close();
        
        return authors;
    }

    private List<Category> getCategories(String bookISBN) throws NamingException, SQLException {
        
        List<Category> categories = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_CATEGORY);
        statement.setString(1, bookISBN);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            categories.add(new CategoryDAO().getById(resultSet.getInt(1)));
        }

        statement.close();

        return categories;
    }

    private List<Book.BookStatusAssoc> getStatuses(String bookISBN) throws NamingException, SQLException {
        
        List<Book.BookStatusAssoc> statuses = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ASSOC_BOOK_STATUS);
        statement.setString(1, bookISBN);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {

            Book.BookStatusAssoc assoc = new Book.BookStatusAssoc(
                    new BookStatusDAO().getById(resultSet.getInt(1))
            );
            assoc.setAssocDate(resultSet.getString(2));
            assoc.setAssocPostIt(resultSet.getString(3));
            statuses.add(assoc);
        }

        statement.close();

        return statuses;
    }
}
