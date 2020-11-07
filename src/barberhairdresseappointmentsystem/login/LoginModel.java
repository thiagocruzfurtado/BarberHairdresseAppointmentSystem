
package barberhairdresseappointmentsystem.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {

    public User login(User user) {
        User loggedUser = null;
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/Thiago_2018259?useSSL=false";
            String dbUser = "Thiago_2018259";
            String dbPassword = "2018259";
            String query
                    = "SELECT * FROM UserAccount "
                    + "WHERE email = '" + user.getEmail()
                    + "' AND password = '" + user.getPassword()
                    + "';";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            if (rs.next()) {

                loggedUser = new User(
                        rs.getInt("Id"),
                        rs.getInt("UserAccountTypeId"),
                        rs.getString("FullName"),
                        rs.getString("Mobile"),
                        rs.getString("Email"),
                        rs.getString("Location"),
                        ""
                );
            }
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return loggedUser;
    }
}
