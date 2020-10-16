package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.BookStatus;

/**
 *
 * @author zvr
 */
public class BookStatusDAO implements DAO<BookStatus, Integer> {

    public final String TABLE_BOOK_STATUS = "BOOK_STATUS";

    public final String QUERY_SELECT_ALL_BOOK_STATUS
            = "SELECT * FROM " + TABLE_BOOK_STATUS;

    public final String QUERY_SELECT_BOOK_STATUS
            = "SELECT * FROM " + TABLE_BOOK_STATUS + " "
            + "WHERE BOOK_STATUS_ID = ?";

    @Override
    public void add(BookStatus object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BookStatus> getAll() throws NamingException, SQLException {

        List<BookStatus> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_BOOK_STATUS);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        BookStatus object = null;

        while (resultSet.next()) {

            object = new BookStatus();
            object.setId(resultSet.getInt(1));
            object.setName(resultSet.getString(2));
            object.setPostIt(resultSet.getString(3));
            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public BookStatus getById(Integer id) throws NamingException, SQLException {

        BookStatus bookStatus = new BookStatus();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_BOOK_STATUS);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            bookStatus = new BookStatus();
            bookStatus.setId(resultSet.getInt(1));
            bookStatus.setName(resultSet.getString(2));
        }

        statement.close();

        return bookStatus;
    }

    @Override
    public void update(BookStatus object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(BookStatus object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
