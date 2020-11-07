
package barberhairdresseappointmentsystem.register;

import barberhairdresseappointmentsystem.DbConnection.DbConnection;
import barberhairdresseappointmentsystem.login.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterModel {

    public User login(User user) {
        User loggedUser = null;
        try {
            DbConnection conn = new DbConnection();
            String query
                    = "SELECT * FROM UserAccount "
                    + "WHERE email = '" + user.getEmail()
                    + "' AND password = '" + user.getPassword()
                    + "';";
            
            // Execute the query
            ResultSet rs = conn.executeQuery(query);

            // check if user was found
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
            // close all opened connections
            conn.dispose();
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
