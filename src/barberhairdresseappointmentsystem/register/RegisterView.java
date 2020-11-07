
package barberhairdresseappointmentsystem.register;

import barberhairdresseappointmentsystem.login.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterView extends JDialog {

    // Text fields must be class members so all methods can access them
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JLabel lblResult;

    RegisterController controller;

    public RegisterView(RegisterController controller) {

        this.controller = controller;

        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }


    // Setting attributes
    private void attributesSetter() {
        this.setVisible(true);
        this.setSize(400, 400);
        this.setTitle("Log in");
    }

    // Organising components
    private void components() {
        JPanel p = new JPanel();
        this.add(p);

        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        tf3 = new JTextField(20);
        lblResult = new JLabel();
        JButton button = new JButton("Login");
        button.addActionListener(controller);

        JButton register = new JButton("Register");
        button.addActionListener(controller);

        tf1.setText("cust@one.com");
        tf2.setText("1234");

        p.add(tf1);
        p.add(tf2);
        p.add(tf3);
        p.add(lblResult);

        p.add(button);

    }

    // Validation and repainting
    private void validation() {
        this.validate();
        this.repaint();
    }

    // Getters for username and password
    public String getValueOne() {
        return tf1.getText();
    }

    public String getValueTwo() {
        return tf2.getText();
    }

    public void setResult(String result) {
        tf3.setText(result);
    }

    public void close(String result) {
        this.dispose();
    }
}
