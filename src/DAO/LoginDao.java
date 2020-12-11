package DAO;

import models.Customer;
import models.ServiceProvider;

import java.sql.*;

public class LoginDao {

    public Customer performCustomerLogin(Customer customer){
        Customer fetchedCustomer = null;
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        Statement st = null;
        String sql = "SELECT * FROM UserAccount WHERE Email = ? AND Password = ? AND UserAccountTypeId = 1";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,customer.getEmail());
            pStmt.setString(2,customer.getPassword());

            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                fetchedCustomer = new Customer(rs.getString("fullName"),rs.getString("email"),rs.getString("mobile"),rs.getString("password"),rs.getString("location"));
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return fetchedCustomer;
    }

    public ServiceProvider performProviderLogin(ServiceProvider serviceProvider){
        ServiceProvider fetchedServiceProvider = null;
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT * FROM UserAccount WHERE Email = ? AND Password = ? AND UserAccountTypeId = 2";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1, serviceProvider.getEmail());
            pStmt.setString(2, serviceProvider.getPassword());
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                fetchedServiceProvider = new ServiceProvider(rs.getString("fullName"),rs.getString("location"),rs.getString("mobile"));
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return fetchedServiceProvider;
    }
}
