package pages;

import javax.swing.*;
import java.awt.*;

public class BookingsList extends JFrame {
    private JList<String> bookingsList;
    private JPanel jPanel;

    public BookingsList() throws HeadlessException {
        jPanel = new JPanel(new GridLayout(2, 2));
        setSize(500, 500);
       setTitle("Bookings");;
        
        bookingsList = new JList<>(new String[10]);

        jPanel.add(bookingsList);
        
        getContentPane().add(jPanel);
    }
}
