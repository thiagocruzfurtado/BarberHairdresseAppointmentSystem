package pages;

import DAO.LoginDao;
import DAO.RegistrationDao;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerRegistration
        extends JFrame {
    private JLabel fullNameJLabel,phoneNumberJLabel,emailJLabel,passwordJLabel;
    private JTextField fullNameJTextField, emailJTextField;
    private JTextField mobileNumberJTextField,passwordTextField;
    private JButton registrationJButton;
    private JPanel panel;

    CustomerRegistration() {
        // Username Label
        fullNameJLabel = new JLabel();
        fullNameJLabel.setText("Enter Full Name ");

        phoneNumberJLabel = new JLabel();
        phoneNumberJLabel.setText("Enter Phone Number");

        emailJLabel = new JLabel();
        emailJLabel.setText("Enter Email");

        passwordJLabel = new JLabel();
        passwordJLabel.setText("Enter Password");

        mobileNumberJTextField = new JTextField();
        mobileNumberJTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        passwordTextField = new JTextField();
        passwordTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N


        fullNameJTextField = new JTextField();
        fullNameJTextField.setFont(new java.awt.Font("Ubuntu", 1, 18));

        emailJTextField = new JTextField();
        emailJTextField.setFont(new java.awt.Font("Ubuntu", 1, 18));

        registrationJButton = new JButton();
        registrationJButton.setBackground(new java.awt.Color(164, 152, 152));
        registrationJButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        registrationJButton.setForeground(new java.awt.Color(0, 0, 0));
        registrationJButton.setText("Register");
        registrationJButton.setActionCommand("ButtonEntrar");
        registrationJButton.setHorizontalAlignment(SwingConstants.CENTER);

        panel = new JPanel(new GridLayout(5, 3));
        panel.add(fullNameJLabel);
        panel.add(fullNameJTextField);

        panel.add(phoneNumberJLabel);
        panel.add(mobileNumberJTextField);

        panel.add(emailJLabel);
        panel.add(emailJTextField);

        panel.add(passwordJLabel);
        panel.add(passwordTextField);

        panel.add(registrationJButton);

        registrationJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fullName,phoneNumber,email,password,location = "teste";

                fullName = fullNameJTextField.getText();
                phoneNumber = mobileNumberJTextField.getText();
                email = emailJTextField.getText();
                password = passwordTextField.getText();


                if (phoneNumber != null || email != null || fullName != null || password != null){
                    RegistrationDao registrationDao = new RegistrationDao();
                    registrationDao.customerRegistration(new Customer(fullName,email,phoneNumber,password,location));
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CustomerLogin().setVisible(true);
                    }
                });
            }
        });


        add(panel, BorderLayout.CENTER);
        setTitle("Welcome Please Login/Register here");
        setSize(450,350);
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerRegistration().setVisible(true);
            }
        });
    }
}
