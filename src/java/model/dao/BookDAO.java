package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import model.entity.Author;
import model.entity.Book;
import model.entity.Category;
import model.entity.Keyword;
import model.entity.Order_Row;
import util.BookSoldComparator;

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
    public final String QUERY_SELECT_BOOK_FROM_ISBN
            = "SELECT * FROM " + TABLE_BOOK + " "
            + "WHERE BOOK_ISBN = ?";

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
    public final String QUERY_QUICK_SEARCH
            = "SELECT DISTINCT book.*\n"
            + "FROM KEYWORD inner join\n"
            + "ASSOC_BOOK_KEYWORD on KEYWORD.KEYWORD_ID = ASSOC_BOOK_KEYWORD.KEYWORD_ID inner join\n"
            + "BOOK on ASSOC_BOOK_KEYWORD.BOOK_ISBN = BOOK.BOOK_ISBN\n"
            + "inner join\n"
            + "ASSOC_BOOK_AUTHOR on BOOK.BOOK_ISBN=ASSOC_BOOK_AUTHOR.BOOK_ISBN\n"
            + "INNER JOIN\n"
            + "AUTHOR ON ASSOC_BOOK_AUTHOR.AUTHOR_ID=AUTHOR.AUTHOR_ID\n"
            + "WHERE BOOK_TITLE like concat ('%', ?, '%')\n"
            + "OR AUTHOR_L_NAME like concat ('%', ?, '%')\n"
            + "OR AUTHOR_F_NAME like concat ('%', ?, '%')\n"
            + "OR BOOK_SUBTITLE like concat ('%', ?, '%')\n"
            + "OR KEYWORD_NAME like concat ('%', ?, '%')\n"
            + "OR BOOK.BOOK_ISBN like concat ('%', ?, '%')";
    
    public final String QUERY_UPDATE_BOOK_QTY =
            "UPDATE "+TABLE_BOOK+" SET "
            + "BOOK_STOCK_QTY = ? "
            + "WHERE BOOK_ISBN = ?";
    
    public final String QUERY_LIST_TITLE = "   select  * from Book where Book.BOOK_TITLE  like concat ('%', ?, '%')";

    public final String QUERY_LIST_ISBN = "   select  * from Book where Book.BOOK_ISBN  like concat ('%', ?, '%')";

    public final String QUERY_LIST_CATEGORY = "SELECT distinct book.* FROM category inner join ASSOC_BOOK_CATEGORY  on CATEGORY.CATEGORY_ID = ASSOC_BOOK_CATEGORY.CATEGORY_ID  inner join BOOK on ASSOC_BOOK_CATEGORY.BOOK_ISBN = BOOK.BOOK_ISBN WHERE category.CATEGORY_NAME like concat ('%', ?, '%')";

    public final String QUERY_LIST_KEYWORD = "SELECT distinct book.* FROM KEYWORD inner join ASSOC_BOOK_KEYWORD  on KEYWORD.KEYWORD_ID = ASSOC_BOOK_KEYWORD.KEYWORD_ID  inner join BOOK on ASSOC_BOOK_KEYWORD.BOOK_ISBN = BOOK.BOOK_ISBN WHERE KEYWORD.KEYWORD_NAME like concat ('%', ?, '%')";

    public final String QUERY_LIST_PRICE = "   select  * from Book where Book.BOOK_HT_PRICE > like concat ('%', ?, '%') and Book.BOOK_HT_PRICE < like concat ('%', ?, '%')";

    public final String QUERY_LIST_MINUS_PRICE = "   select  * from Book where Book.BOOK_HT_PRICE < like concat ('%', ?, '%')";

    public final String QUERY_LIST_MAX_PRICE = "   select  * from Book where Book.BOOK_HT_PRICE > like concat ('%', ?, '%')";

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

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_BOOK_FROM_ISBN);
        statement.setString(1, id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Book object = null;

        if (resultSet.next()) {

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
        }

        statement.close();

        return object;
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

    public List<Book> quickSearch(String searchText) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_QUICK_SEARCH);
        statement.setString(1, searchText);
        statement.setString(2, searchText);
        statement.setString(3, searchText);
        statement.setString(4, searchText);
        statement.setString(5, searchText);
        statement.setString(6, searchText);
        resultSet = statement.executeQuery();

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

    public List<Book> categorySearch(String searchText) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_CATEGORY);
        statement.setString(1, searchText);
        resultSet = statement.executeQuery();

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

    public List<Book> titleSearch(String searchText) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_TITLE);
        statement.setString(1, searchText);
        resultSet = statement.executeQuery();

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

    public List<Book> keywordSearch(String searchText) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_KEYWORD);
        statement.setString(1, searchText);
        resultSet = statement.executeQuery();

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

    public List<Book> isbnSearch(String searchText) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_ISBN);
        statement.setString(1, searchText);
        resultSet = statement.executeQuery();

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

    public List<Book> priceSearch(Double searchPrice, Double searchEPrice) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_PRICE);
        statement.setDouble(1, searchPrice);
        statement.setDouble(2, searchEPrice);

        resultSet = statement.executeQuery();

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

    public List<Book> priceSearchMin(Double searchPrice) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_MINUS_PRICE);
        statement.setDouble(1, searchPrice);

        resultSet = statement.executeQuery();

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

    public List<Book> priceSearchMax(Double searchPrice) throws NamingException, SQLException {

        List<Book> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Book object = null;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_LIST_MAX_PRICE);
        statement.setDouble(1, searchPrice);

        resultSet = statement.executeQuery();

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
    
    // Reduces book's stock quantity by the given quantity
    public void reduceQuantity(String isbn, int quantity) throws NamingException, SQLException, Exception{
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        int newQuantity;
 
        connection = database.getConnection();
        
        newQuantity = getById(isbn).getQuantity() - quantity;
        
        // Safeguard trigger
        if(newQuantity < 0){
            throw new Exception("Not enough books in stock");
        }
        
        statement = connection.prepareStatement(QUERY_UPDATE_BOOK_QTY);
        
        statement.setInt(1, newQuantity);
        statement.setString(2, isbn);
        
        statement.executeUpdate();

        statement.close();
        connection.close();
    }
    
    // Gets the best sales of all time
    public List<Book> getBestSales() throws SQLException, NamingException, Exception{
        
        Map<String,Integer> isbnSales;
        List<Book> bookSales;
        List<Order_Row> orderRows; 
        
        isbnSales = new HashMap<>();
        bookSales = new ArrayList<>();
        orderRows = new Order_RowDAO(0).getAll();
        
        
        for(Order_Row orderRow : orderRows){
            
            String isbn = orderRow.getBookIsbn();
            if(!isbnSales.containsKey(isbn)){
                isbnSales.put(isbn, 0);
            }
            isbnSales.replace(isbn, isbnSales.get(isbn) + orderRow.getOrderQuantity());
        }
        
        Book book = null;
        for(String key : isbnSales.keySet()){
            book = getById(key);
            book.setSoldQuantity(isbnSales.get(key));
            bookSales.add(book);
        }
        
        // Sorts the list
        bookSales.sort(new BookSoldComparator(true));
        
        // Debug code START
        for(Book b : bookSales){
            System.out.println(" book : "+b.getTitle()+" - "+b.getSoldQuantity());
        }
        
        return bookSales;
    }
}
