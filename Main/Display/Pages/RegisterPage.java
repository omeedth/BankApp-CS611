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
// import Main.FancyATM;

public class RegisterPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = -8520895720528101151L;

    /* Data Members */
    private JTextField usernameInput;
    private JTextField passwordInput;
    private JButton register;

    /* Constructors */

    public RegisterPage() {
        this.usernameInput = new JTextField("Username");

        this.passwordInput = new JTextField("Password");

        this.register = new JButton("Register");
        this.init();
    }

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    /**
     * Initializes all listeners, and other necessary variables for the display
     */
    public void init() {
        /* Initialize the listeners */
        this.register.addActionListener(this);

        /* Add all components onto this Page object */
        this.add(this.usernameInput);
        this.add(this.passwordInput);
        this.add(this.register);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
}
