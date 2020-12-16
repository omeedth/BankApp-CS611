package Main.Display.Pages;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the register page
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;


/* Internal Imports */
import Main.Requests.*;

// import Main.FancyATM;

public class RegisterPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = -8520895720528101151L;

    /* Data Members */
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton register;
    private JButton back;

    /* Constructors */

    public RegisterPage() {
        this.usernameInput = new JTextField("Username");

        this.passwordInput = new JTextField("Password");

        this.register = new JButton("Register");
        
        this.back = new JButton("Back");
        this.init();
    }

    /* Accessor Methods */
    public JTextField getUsernameInput() {
        return usernameInput;
    }

    public JTextField getPasswordInput() {
        return passwordInput;
    }

    public JButton getRegister() {
        return register;
    }

    public JButton back() {
        return back;
    }
    /* Mutator Methods */

    /* Logic Methods */

    /**
     * Initializes all listeners, and other necessary variables for the display
     */
    public void init() {
        /* Initialize the listeners */
        this.register.addActionListener(this);
        this.back.addActionListener(this);
        /* Add all components onto this Page object */
       display();
    }

    // if the button is pressed 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        System.out.println("Action Command: " + s);
        if (s.equals("Register")) { 
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            this.setCurrentRequest(new Register(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        }else if (s.equals("Back")){
            /* Back to login page */
            System.out.println("change request to login!");
            this.setCurrentRequest(new Login()); // change page back to Login
        }
    }

    @Override
    public void display() {
        /* Add all components onto this Page object */
        this.add(this.usernameInput);
        this.add(this.passwordInput);
        this.add(this.register); 
        this.add(this.back);
    }
    
}
