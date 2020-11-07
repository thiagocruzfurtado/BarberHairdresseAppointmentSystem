
package barberhairdresseappointmentsystem;

import barberhairdresseappointmentsystem.login.*;
import barberhairdresseappointmentsystem.login.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

    View view;
    User loggedUser;
    LoginController loginController;
    
    
    public Controller(){
        this.view = new View(this);
       // this.model = new Model();
        loginController = new LoginController();
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        loginController.show();
        
      
                
       // boolean result = model.login(user);
        
//        String resultMessage = "Try again with valid credentials";
//        
//        if(result){
//            resultMessage = "Welcome in";
//        }
//        
       // view.setResult(resultMessage);
    }
    

}
