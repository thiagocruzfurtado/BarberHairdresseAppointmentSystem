
package barberhairdresseappointmentsystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {

    //  Text fields must be class members so all methods can access them
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;

        // We encapsulated the building process of the window
        attributesSetter();
        components();
        validation();
    }

    // Setting attributes
    private void attributesSetter() {
        this.setVisible(true);
        this.setSize(800, 600);
        this.setTitle("Main window");
    }

    // Organising components
    private void components() {
        JPanel p = new JPanel();
        this.add(p);
        JButton button = new JButton("Log in");
        button.addActionListener(this.controller);

        p.add(button);
    }

    // Validation and repainting
    private void validation() {
        this.validate();
        this.repaint();
    }

}
