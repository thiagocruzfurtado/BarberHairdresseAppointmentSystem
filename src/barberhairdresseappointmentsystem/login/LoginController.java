
package barberhairdresseappointmentsystem.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController implements ActionListener {

    LoginView view;
    private LoginModel model;

    public LoginController() {
    }

    public void show() {
        this.view = new LoginView(this);
        this.model = new LoginModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String un = view.getValueOne();
        String pw = view.getValueTwo();

        User user = new User(un, pw);

        User result = getModel().login(user);

        if (result != null) {
            view.close("");
        } else {
            view.setResult("User or password invalid");
        }
    }

    /**
     * @return the model
     */
    public LoginModel getModel() {
        return model;
    }

}
