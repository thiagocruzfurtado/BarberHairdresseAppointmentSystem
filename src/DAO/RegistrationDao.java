package DAO;

import models.Customer;
import models.ServiceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationDao {
    public void customerRegistration(Customer customer){
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        PreparedStatement pStmt = null;

        String sql = "INSERT INTO UserAccount(fullName,mobile,email,password,location,UserAccountTypeId) VALUES(?,?,?,?,?,?)";

        try {
            pStmt = c.prepareStatement(sql);
            pStmt.setString(1,customer.getName());
            pStmt.setString(2,customer.getMobile());
            pStmt.setString(3,customer.getEmail());
            pStmt.setString(4,customer.getPassword());
            pStmt.setString(5,customer.getLocation());
            pStmt.setString(6,"1");
            pStmt.executeUpdate();

            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
    }

    public int providerRegistration(ServiceProvider serviceProvider){
        int inputStatus = 0;
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "INSERT INTO UserAccount(fullName,mobile,email,password,location,UserAccountTypeId) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,serviceProvider.getName());
            pStmt.setString(2,serviceProvider.getMobileNumber());
            pStmt.setString(3, serviceProvider.getEmail());
            pStmt.setString(4,serviceProvider.getPassword());
            pStmt.setString(5,serviceProvider.getLocation());
            pStmt.setString(6, "2");

            inputStatus =  pStmt.executeUpdate();
            pStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return inputStatus;
    }
}
