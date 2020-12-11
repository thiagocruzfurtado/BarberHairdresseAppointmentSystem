package pages;

import DAO.LoginDao;
import models.ServiceProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceProviderLogin extends JFrame {
    private JLabel miniTitleForm,usernameLabel,passwordLabel;
    private JTextField usernameTextField,passwordTextField;
    private JButton loginButton;


    public ServiceProviderLogin() {
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
        passwordTextField = new JTextField();
        loginButton = new JButton();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        miniTitleForm.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        miniTitleForm.setText("Service Provider Login");
        miniTitleForm.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        usernameLabel.setText("Username");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
//        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                TextUsuarioActionPerformed(evt);
//            }
//        });

        passwordLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setText("Password");

        passwordTextField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        passwordTextField.setHorizontalAlignment(SwingConstants.CENTER);
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
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
//        loginButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ButtonEntrarActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                .addComponent(passwordTextField)
                                                .addComponent(usernameTextField))
                                        .addComponent(usernameLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(139, Short.MAX_VALUE)
                                .addComponent(miniTitleForm)
                                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(65, Short.MAX_VALUE)
                                .addComponent(miniTitleForm)
                                .addGap(34, 34, 34)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String email,password;
                email = usernameTextField.getText();
                password = passwordTextField.getText();

                if (email != null || password != null){
                    LoginDao loginDao = new LoginDao();
                    ServiceProvider serviceProvider = loginDao.performProviderLogin(new ServiceProvider(email,password));

                    if (serviceProvider != null){
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new ServiceProviderManagementPage(serviceProvider).setVisible(true);
                            }
                        });
                    }else {
                        System.out.println("Service provider not found");
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceProviderLogin().setVisible(true);
            }
        });
    }
}
