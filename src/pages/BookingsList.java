package pages;

import models.*;
import DAO.BookingsDao;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BookingsList extends JFrame {
    private JList<String> bookingsList;
    private JPanel jPanel;
    private ServiceProvider serviceProvider;

    public BookingsList(ServiceProvider serviceProvider) throws HeadlessException {
        this.serviceProvider = serviceProvider;
        BookingsDao bookingsDao = new BookingsDao();
        List<Customer> customers = bookingsDao.fetchBookings(this.serviceProvider);
        jPanel = new JPanel(new GridLayout(2, 2));
        setSize(500, 500);
        setTitle("Bookings");
        DefaultListModel listModel = new DefaultListModel();
        for(Customer customer : customers) {
            listModel.addElement(customer.getName());
        }
        bookingsList = new JList<>(listModel);

        jPanel.add(bookingsList);
        
        getContentPane().add(jPanel);
    }
}
