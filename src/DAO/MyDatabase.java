package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDatabase {
    private Connection conn = null;
    private boolean isConnected = false;

    public Connection openConnection() {

        if (false == isConnected) {

            try {
                // STEP: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // STEP: Open a connection
                String dbServer = "jdbc:mysql://apontejaj.com:3306/Thiago_2018259?useSSL=false";
                String dbUser = "Thiago_2018259";
                String dbPassword = "2018259";

                // STEP: Get a connection to the database
                conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);
                
                isConnected = true;
                System.out.println("connection success");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

        }
        return conn;
    }

    public void closeConnection() {
        if (true == isConnected) {
            try {
                // STEP: Close connection
                conn.close();

                isConnected = false;
                System.out.println("close success");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

        }
    }
}
