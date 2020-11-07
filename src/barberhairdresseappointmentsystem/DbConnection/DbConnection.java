
package barberhairdresseappointmentsystem.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thiago Handle database connection Create a connection execute
 * query/commands and close all related objects
 */
public class DbConnection {

    private final Connection conn;
    private final Statement stmt;
    private ResultSet rs;

    public DbConnection() throws SQLException {
        String dbServer = "jdbc:mysql://apontejaj.com:3306/Thiago_2018259?useSSL=false";
        String dbUser = "Thiago_2018259";
        String dbPassword = "2018259";

        // Get a connection to the database
        conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

        // Get a statement from the connection
        stmt = conn.createStatement();
    }

    /**
     *
     * @param query - select statement
     * @return the result set of query statement
     * @throws SQLException
     */
    public ResultSet executeQuery(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        return rs;
    }

    /**
     *
     * @param query - update statement
     * @return the result set of query statement
     * @throws SQLException
     */
    public void executeUpdate(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public void dispose() throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }
}
