package pages;

import DAO.LoginDao;
import models.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLogin extends JFrame {
    private JLabel miniTitleForm,usernameLabel,passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private Customer loginCustomer;


    public CustomerLogin() {
        initComponents();
        setTitle("BarberShop");
//        controller = new LoginController(this);
//        Banco.inicia();
    }


    private void initComponents(){
        miniTitleForm = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginButton = new JButton();

//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        miniTitleForm.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        miniTitleForm.setText("Customer Login");

        usernameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        usernameLabel.setText("Username");

        usernameTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
//        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                TextUsuarioActionPerformed(evt);
//            }
//        });

        passwordLabel.setText("Password");

        passwordTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
//        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                TextSenhaActionPerformed(evt);
//            }
//        });

        loginButton.setBackground(new java.awt.Color(164, 152, 152));
        loginButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(0, 0, 0));
        loginButton.setText("Login");
        loginButton.setActionCommand("ButtonEntrar");
//        loginButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ButtonEntrarActionPerformed(evt);
//            }
//        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                .addComponent(passwordTextField)
                                                .addComponent(usernameTextField))
                                        .addComponent(usernameLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(139, Short.MAX_VALUE)
                                .addComponent(miniTitleForm)
                                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(65, Short.MAX_VALUE)
                                .addComponent(miniTitleForm)
                                .addGap(34, 34, 34)
                                .addComponent(usernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //perform login
                String email, password;

                email = usernameTextField.getText();
                password = passwordTextField.getText();

                LoginDao loginDao = new LoginDao();
                loginCustomer = loginDao.performCustomerLogin(new Customer(email,password));
                if (loginCustomer == null){
                    System.out.println("User does not exist");
                }else {
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new CustomerBookingPage(loginCustomer).setVisible(true);
                        }
                    });
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerLogin().setVisible(true);
            }
        });
    }
}
