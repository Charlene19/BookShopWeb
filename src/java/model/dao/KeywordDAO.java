package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Keyword;

/**
 *
 * @author zvr
 */
public class KeywordDAO implements DAO<Keyword, Integer> {

    public final String TABLE_KEYWORD = "KEYWORD";

    public final String QUERY_SELECT_ALL_KEYWORD = "SELECT * FROM KEYWORD";
    public final String QUERY_SELECT_KEYWORD
            = "SELECT * FROM KEYWORD "
            + "WHERE KEYWORD_ID = ?";

    @Override
    public void add(Keyword object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Keyword> getAll() throws NamingException, SQLException {

        List<Keyword> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_KEYWORD);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Keyword object = null;

        while (resultSet.next()) {

            object = new Keyword();
            object.setId(resultSet.getInt(1));
            object.setName(resultSet.getString(2));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Keyword getById(Integer id) throws NamingException, SQLException {

        Keyword keyword = new Keyword();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_KEYWORD);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            keyword = new Keyword();
            keyword.setId(resultSet.getInt(1));
            keyword.setName(resultSet.getString(2));
        }

        statement.close();

        return keyword;
    }

    @Override
    public void update(Keyword object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Keyword object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
