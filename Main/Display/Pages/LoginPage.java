package Main.Display.Pages;

import javax.swing.JButton;
import javax.swing.JTextField;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the login page
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;

/* Internal Imports */
// import Main.FancyATM;
import Main.Requests.*;

public class LoginPage extends Page {
    
    /* Static/Final Members */
    private static final long serialVersionUID = 6171384018996908597L;

    /* Data Members */
    // TODO: Username InputBox
    // TODO: Password InputBox
    // TODO: Login    Button
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton login;

    /* Constructors */

    public LoginPage() {
        usernameInput = new JTextField("Username");

        passwordInput = new JTextField("Password");

        login = new JButton("Login");
        this.init();
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

    public void init() {
        /* Initialize the listeners */
        // this.usernameInput.addActionListener(this);
        // this.passwordInput.addActionListener(this);
        this.login.addActionListener(this);   
        display();    
    }

    public void waitForRequestCompletion() {

        /* Start running */

        /* While flag is not 0 */
        while (this.getCurrentRequest() != null && this.getCurrentRequest().getFlag() != 0) {
            
        }

    }

    // if the button is pressed 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        System.out.println("Action Command: " + s);
        if (s.equals("Login")) { 
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            this.setCurrentRequest(new Login(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } 
    }

    @Override
    public void display() {
        /* Add all components onto this Page object */
        this.add(this.usernameInput);
        this.add(this.passwordInput);
        this.add(this.login); 
    }
    
}
