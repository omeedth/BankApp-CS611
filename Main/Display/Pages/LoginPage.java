package Main.Display.Pages;



import java.awt.Dimension;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the login page
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

//
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
// import bank.SpringUtilities;
// import javax.swing.Spring;
// import javax.swing.SpringLayout;

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
    private JButton register;
    // trying design
	private JButton loginManagerButton;
    private JLabel headerLabel;
	

    /* Constructors */

    public LoginPage() {
    	super();
        usernameInput = new JTextField("Username");
        usernameInput.setMaximumSize(new Dimension(200,30));

        passwordInput = new JTextField("Password");
        passwordInput.setMaximumSize(new Dimension(200,30));

        login = new JButton("Login");
        //
        headerLabel = new JLabel("Welcome! Please log in!");
		register = new JButton("Sign Up New User");
        loginManagerButton = new JButton("Login Manager");
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
        this.register.addActionListener(this);
        this.loginManagerButton.addActionListener(this);
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
        } else if (s.equals("Sign Up New User")) {
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            // String username = usernameInput.getText();
            // String password = passwordInput.getText();
            this.setCurrentRequest(new Register()); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } else if(s.equals("Login Manager")) {
        	this.setCurrentRequest(new OpenManagerPage()); //TODO: This is a catastrophe
        }
    }

    @Override
    public void display() {
        /* Add all components onto this Page object */
    	this.setLayout(new BoxLayout(this, 1));
        this.add(this.headerLabel);
        this.add(this.usernameInput);
        this.add(this.passwordInput);
        this.add(this.login); 
        // JPanel jp = new JPanel(new SpringLayout());
        // this.setLayout(new GridBagLayout());
	    // GridBagConstraints gbc = new GridBagConstraints();
	    // gbc.gridwidth = GridBagConstraints.REMAINDER;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.register);
        this.add(this.loginManagerButton);
    }
    
}
