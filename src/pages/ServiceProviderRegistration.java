package pages;

import DAO.RegistrationDao;
import models.ServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceProviderRegistration extends JFrame {
    private JLabel fullNameJLabel,phoneNumberJLabel,emailJLabel,passwordJLabel;
    private JTextField fullNameJTextField, emailJTextField;
    private JTextField mobileNumberJTextField,passwordTextField;
    private JButton registrationJButton;

    JPanel panel;

    ServiceProviderRegistration() {
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
                String phoneNumber, email, fullName, password;

                phoneNumber = mobileNumberJTextField.getText();
                email = emailJTextField.getText();
                fullName = fullNameJTextField.getText();
                password = passwordTextField.getText();

                if (phoneNumber != null || email != null || fullName != null || password != null){
                    RegistrationDao registrationDao = new RegistrationDao();
                    registrationDao.providerRegistration(new ServiceProvider(fullName,email,phoneNumber,password));
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new ServiceProviderLogin().setVisible(true);
                        }
                    });
                }
            }
        });

        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(450,350);
        setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceProviderRegistration().setVisible(true);
            }
        });
    }
}
