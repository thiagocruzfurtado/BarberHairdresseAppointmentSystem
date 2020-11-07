
package barberhairdresseappointmentsystem.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {

   RegisterView view;

    public RegisterController() {
         
       // this.view = new LoginView(this);
        //this.model = new LoginModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       view = new RegisterView(this);
    }
}
