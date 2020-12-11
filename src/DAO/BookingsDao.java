package DAO;

import models.Customer;
import models.ServiceProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingsDao {
    public List<ServiceProvider> availableServiceProviders(){
        List<ServiceProvider> fetchedServiceProviderList = new ArrayList<>();

        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT * FROM UserAccount WHERE UserAccountTypeId = 2";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                ServiceProvider serviceProvider = new ServiceProvider(rs.getString("fullName"),rs.getString("location"),rs.getString("mobile"));
                fetchedServiceProviderList.add(serviceProvider);
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();

        return fetchedServiceProviderList;
    }

    public List<Customer> fetchProvidersConfirmedBookings(ServiceProvider serviceProvider){
        List<Customer> fetchedCustomerList = new ArrayList<>();
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT b.customer as customerID,b.bookedProvider as providerID, " +
                "c.fullName as fullName,c.mobileNumber as phone,c.email as email" +
                " FROM confirmed_booking b INNER JOIN provider p ON b.bookedProvider = p.providerID " +
                "INNER JOIN customer c ON c.customerID = b.customer " +
                " WHERE p.mobileNumber = ?";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,serviceProvider.getMobileNumber());
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer(rs.getString("fullName"),rs.getString("email"),rs.getString("phone"));
                fetchedCustomerList.add(customer);
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return fetchedCustomerList;
    }

    private List<Customer> fetchCustomerRequests(ServiceProvider serviceProvider){
        List<Customer> fetchedCustomerList = new ArrayList<>();
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT b.customer as customerID,b.bookedProvider as providerID, " +
                "c.fullName as fullName,c.mobileNumber as phone,c.email as email" +
                " FROM booking b INNER JOIN provider p ON b.bookedProvider = p.providerID " +
                "INNER JOIN customer c ON c.customerID = b.customer " +
                " WHERE p.mobileNumber = ?";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,serviceProvider.getMobileNumber());
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer(rs.getString("fullName"),rs.getString("email"),rs.getString("phone"));
                fetchedCustomerList.add(customer);
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return fetchedCustomerList;
    }

    private void respondToBookingRequest(int status, Customer customer, ServiceProvider serviceProvider){
        if (status == 0){
            declineBookingRequest(customer,serviceProvider);
        }else {
            acceptBookingRequest(customer,serviceProvider);
        }
    }

    private boolean declineBookingRequest(Customer customer, ServiceProvider serviceProvider){
        boolean deleteStatus = false;
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "DELETE FROM booking WHERE customer = ? and bookedProvider = ?";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,customer.getMobile());
            pStmt.setString(2,serviceProvider.getMobileNumber());
            deleteStatus = pStmt.execute();
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        return deleteStatus;
    }

    private void acceptBookingRequest(Customer customer, ServiceProvider serviceProvider){
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "INSERT INTO confirmedBooking(customerPhone, providerPhone) VALUES(?,?)";
        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setString(1,customer.getMobile());
            pStmt.setString(2,serviceProvider.getMobileNumber());
            pStmt.execute();
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
        declineBookingRequest(customer,serviceProvider);
    }
}