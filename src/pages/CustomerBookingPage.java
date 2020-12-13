package pages;

import DAO.BookingsDao;
import models.Customer;
import models.ServiceProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerBookingPage extends JFrame {
    private JLabel chooseBarberJLabel;
    private JComboBox<String> barbersJComboList;
    private JButton bookJButton;
    private JPanel jPanel;
    private Customer loginCustomer;

    public CustomerBookingPage(Customer loginCustomer) throws HeadlessException {
        this.loginCustomer = loginCustomer;
        setSize(800, 800);

        chooseBarberJLabel = new JLabel("Select from available barbers ");

        //initialize JList
        //load JList from fetched list of available barbers
        BookingsDao bookingsDao = new BookingsDao();
        List<ServiceProvider> serviceProviderList = bookingsDao.availableServiceProviders();
        barbersJComboList = new JComboBox<>();
        for (ServiceProvider serviceProvider:serviceProviderList){
            barbersJComboList.addItem(serviceProvider.getId() + "-" + serviceProvider.getName());
        }

        bookJButton = new JButton();
        bookJButton.setText("Book");
        bookJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        bookJButton.setForeground(new java.awt.Color(0, 0, 0));

        JLabel customerName = new JLabel(loginCustomer.getName());
        JLabel customerEmail = new JLabel(loginCustomer.getEmail());

        jPanel = new JPanel(new GridLayout(2,2));
        jPanel.add(chooseBarberJLabel);
        jPanel.add(barbersJComboList);
        jPanel.add(bookJButton);
        jPanel.add(customerName);
        jPanel.add(customerEmail);
        
        getContentPane().add(jPanel);
        bookJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        String selected = String.valueOf(barbersJComboList.getSelectedItem());
                        String[] providerData = selected.split("-");
                        BookingsDao bookingsDao = new BookingsDao();
                        ServiceProvider serviceProvider = new ServiceProvider(Integer.parseInt(providerData[0]), providerData[1]);
                        bookingsDao.createBooking(loginCustomer, serviceProvider);
                    }
                });
            }; 
        });       
    }

}
