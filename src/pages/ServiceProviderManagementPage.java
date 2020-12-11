package pages;

import models.ServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceProviderManagementPage extends JFrame {
    private JButton respondToBookingRequestsJButton;
    private JButton viewBookingsJButton;
    private JPanel jPanel;
    private ServiceProvider serviceProvider;

    public ServiceProviderManagementPage(ServiceProvider serviceProvider) throws HeadlessException {
        this.serviceProvider = serviceProvider;
           setSize(800, 800);
        
        respondToBookingRequestsJButton = new JButton();
        respondToBookingRequestsJButton.setText("Respond To Bookings");
        respondToBookingRequestsJButton.setBackground(new java.awt.Color(164, 152, 152));
        respondToBookingRequestsJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        respondToBookingRequestsJButton.setForeground(new java.awt.Color(0, 0, 0));

        viewBookingsJButton = new JButton();
        viewBookingsJButton.setText("View Bookings");
        viewBookingsJButton.setBackground(new java.awt.Color(164, 152, 152));
        viewBookingsJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        viewBookingsJButton.setForeground(new java.awt.Color(0, 0, 0));
        viewBookingsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new BookingsList().setVisible(true);
                    }
                });
            }
        });
        
        jPanel = new JPanel(new GridLayout(3,1));
        jPanel.add(respondToBookingRequestsJButton);

        jPanel = new JPanel(new GridLayout(3,1));
        jPanel.add(viewBookingsJButton);
        
        
        
        getContentPane().add(jPanel);
    }
}
