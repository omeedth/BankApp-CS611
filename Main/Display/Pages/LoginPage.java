package Main.Display.Pages;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the login page
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Internal Imports */
import Main.FancyATM;
import Main.Requests.*;

public class LoginPage extends Page implements ActionListener {
    
    /* Data Members */
    // TODO: Username InputBox
    // TODO: Password InputBox
    // TODO: Login    Button
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton login;

    /* Constructors */

    public LoginPage() {
    }

    /* Accessor Methods */

    public JTextField getUsernameInput() {
        return usernameInput;
    }

    public JTextField getPasswordInput() {
        return passwordInput;
    }

    public JButton getLogin() {
        return login;
    }

    /* Mutator Methods */

    /* Logic Methods */
    
    public void loadPage() {
    }

    public void waitForRequestCompletion() {

        /* Start running */

        /* While flag is not 0 */
        while (this.getCurrentRequest() != null && this.getCurrentRequest().getFlag() != 0) {
            
        }

    }

    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        if (s.equals("Login")) { 
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            this.setCurrentRequest(new Login(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } 
    } 
    
}
