package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Category;

/**
 *
 * @author zvr
 */
public class CategoryDAO implements DAO<Category, Integer> {

    public final String TABLE_CATEGORY = "CATEGORY";
    public final String TABLE_ASSOC_CATEGORY_CATEGORY = "ASSOC_CATEGORY_CATEGORY";

    public final String QUERY_SELECT_ALL_CATEGORY = "SELECT * FROM CATEGORY";
    public final String QUERY_SELECT_CATEGORY
            = "SELECT * FROM CATEGORY "
            + "WHERE CATEGORY_ID = ?";

    public final String QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY
            = "SELECT * FROM " + TABLE_ASSOC_CATEGORY_CATEGORY;

    public final String QUERY_SELECT_ALL_ASSOC_WHERE_ID
            = QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY + " "
            + "WHERE CATEGORY_PARENT_ID = ?";

    @Override
    public void add(Category object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Category> getAll() throws NamingException, SQLException {
        
        List<Category> categories = new ArrayList<>();
        List<int[]> associations = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_SELECT_ALL_CATEGORY);
        resultSet = statement.executeQuery();

        Category category = null;
        while (resultSet.next()) {

            category = new Category();
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));

            categories.add(category);
        }

        statement = connection.prepareStatement(
                QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY
        );
        resultSet = statement.executeQuery();

        while (resultSet.next()) {

            int[] association = new int[2];
            association[0] = resultSet.getInt(1);
            association[1] = resultSet.getInt(2);

            associations.add(association);
        }

        for (int[] association : associations) {
            for (Category cParent : categories) {
                if (cParent.getId() == association[0]) {
                    for (Category cEnfant : categories) {
                        if (cEnfant.getId() == association[1]) {
                            cParent.getCategories().add(cEnfant);
                        }
                    }
                }
            }
        }

        statement.close();

        return categories;
    }

    @Override
    public Category getById(Integer id) throws NamingException, SQLException{

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        Category category = new Category();

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_CATEGORY);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            category = new Category();
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
        }

        statement.close();

        return category;
    }

    @Override
    public void update(Category object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Category object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
