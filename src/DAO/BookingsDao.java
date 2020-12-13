package DAO;

import models.Customer;
import models.ServiceProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingsDao {

    public void createBooking(Customer customer, ServiceProvider serviceProvider) {
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "INSERT INTO Booking (barber_id,customer_id) VALUES (?,?)";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setInt(1, serviceProvider.getId());
            pStmt.setInt(2, customer.getId());
            pStmt.executeUpdate();
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();
    }
    public List<ServiceProvider> availableServiceProviders(){
        List<ServiceProvider> fetchedServiceProviderList = new ArrayList<>();

        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT * FROM UserAccount WHERE UserAccountTypeId = 2";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                ServiceProvider serviceProvider = new ServiceProvider(rs.getInt("id"),rs.getString("fullName"),rs.getString("location"),rs.getString("mobile"));
                fetchedServiceProviderList.add(serviceProvider);
            }
            pStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        myDatabase.closeConnection();

        return fetchedServiceProviderList;
    }

    public List<Customer> fetchBookings(ServiceProvider serviceProvider){
        List<Customer> fetchedCustomerList = new ArrayList<>();
        MyDatabase myDatabase = new MyDatabase();
        Connection c = myDatabase.openConnection();

        String sql = "SELECT uc.* FROM UserAccount uc " +
                     "INNER JOIN Booking b ON b.customer_id = uc.id " + 
                     "WHERE b.barber_id = ?;";

        try {
            PreparedStatement pStmt = c.prepareStatement(sql);
            pStmt.setInt(1,serviceProvider.getId());
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer(rs.getString("fullName"),rs.getString("email"),rs.getString("mobile"));
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