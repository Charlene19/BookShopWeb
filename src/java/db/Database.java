package db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author zvr
 */
public class Database {

    private final String CONTEXT_NAME = "jdbc/bookshop";

    private static Database instance;

    private Connection connection;

    private Database() {

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() throws NamingException, SQLException {

        // Opens a new connection if this one is close or null
        if (connection == null || connection.isClosed()) {
            DataSource ds = null;

            InitialContext context = new InitialContext();

            ds = (DataSource) context.lookup(CONTEXT_NAME);
            connection = ds.getConnection();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        closeConnection();
    }
}
