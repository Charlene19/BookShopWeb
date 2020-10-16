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

/**
 *
 * @author zvr
 */
public class AuthorDAO implements DAO<Author, Integer> {

    public final String TABLE_AUTHOR = "AUTHOR";

    public final String QUERY_SELECT_ALL_AUTHOR = "SELECT * FROM AUTHOR";
    public final String QUERY_SELECT_AUTHOR
            = "SELECT * FROM AUTHOR "
            + "WHERE AUTHOR_ID = ?";

    @Override
    public void add(Author object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Author> getAll() throws NamingException, SQLException {
        List<Author> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_AUTHOR);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Author object = null;

        while (resultSet.next()) {

            object = new Author();
            object.setId(resultSet.getInt(1));
            object.setFirstName(resultSet.getString(2));
            object.setLastName(resultSet.getString(3));
            object.setPostIt(resultSet.getString(4));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Author getById(Integer id) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        Author author = new Author();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_AUTHOR);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            author = new Author();
            author.setId(resultSet.getInt(1));
            author.setFirstName(resultSet.getString(2));
            author.setLastName(resultSet.getString(3));
            author.setPostIt(resultSet.getString(4));
        }

        statement.close();
        
        return author;
    }

    @Override
    public void update(Author object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Author object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
