package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {
    private JPanel jPanel;
    private JLabel customersLabel;
    private JLabel providersLabel;
    private JButton customerLoginJButton,providerLoginJButton;
    private JButton customerRegistrationJButton, providerRegistrationJButton;

    public WelcomeScreen() throws HeadlessException {
        setTitle("Welcome");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);

        customersLabel = new JLabel();
        customersLabel.setText("Customer");

        providersLabel = new JLabel();
        providersLabel.setText("Service Providers");

        customerLoginJButton = new JButton();
        customerLoginJButton.setText("Login");
        customerLoginJButton.setBackground(new java.awt.Color(164, 152, 152));
        customerLoginJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        customerLoginJButton.setForeground(new java.awt.Color(0, 0, 0));

        providerLoginJButton = new JButton();
        providerLoginJButton.setText("Login");
        providerLoginJButton.setBackground(new java.awt.Color(164, 152, 152));
        providerLoginJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        providerLoginJButton.setForeground(new java.awt.Color(0, 0, 0));

        customerRegistrationJButton = new JButton();
        customerRegistrationJButton.setText("Register");
        customerRegistrationJButton.setBackground(new java.awt.Color(164, 152, 152));
        customerRegistrationJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        customerRegistrationJButton.setForeground(new java.awt.Color(0, 0, 0));

        providerRegistrationJButton = new JButton();
        providerRegistrationJButton.setText("Register");
        providerRegistrationJButton.setBackground(new java.awt.Color(164, 152, 152));
        providerRegistrationJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        providerRegistrationJButton.setForeground(new java.awt.Color(0, 0, 0));

        customerLoginJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CustomerLogin().setVisible(true);
                    }
                });
            }
        });

        customerRegistrationJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CustomerRegistration().setVisible(true);
                    }
                });
            }
        });

        providerLoginJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ServiceProviderLogin().setVisible(true);
                    }
                });
            }
        });

        providerRegistrationJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ServiceProviderRegistration().setVisible(true);
                    }
                });
            }
        });

        jPanel = new JPanel(new GridLayout(6,1,5,5));
        jPanel.add(customersLabel);
        jPanel.add(customerLoginJButton);
        jPanel.add(customerRegistrationJButton);
        jPanel.add(providersLabel);
        jPanel.add(providerLoginJButton);
        jPanel.add(providerRegistrationJButton);
        //set welcome page
        add(jPanel, BorderLayout.CENTER);
        setTitle("Welcome Please Login/Register Here");
        setSize(300,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeScreen().setVisible(true);
            }
        });
    }
}
