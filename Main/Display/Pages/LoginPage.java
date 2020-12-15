package Main.Display.Pages;



/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the login page
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

//
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
// import bank.SpringUtilities;
import javax.swing.Spring;
import javax.swing.SpringLayout;

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
    // trying design
    private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField fNAmeTextField;
	private JTextField lNameTextField;	
	private JButton newButton;
	private JButton loginManagerButton;
	private JLabel msgLabel;
	private JLabel headerLabel;
	

    /* Constructors */

    public LoginPage() {
        usernameInput = new JTextField("Username");

        passwordInput = new JTextField("Password");

        login = new JButton("Login");
        //
        headerLabel = new JLabel("Please log in");
		emailLabel = new JLabel("First Name", JLabel.TRAILING);		
		fNAmeTextField = new JTextField(20);
		emailLabel.setLabelFor(fNAmeTextField);
		passwordLabel = new JLabel("Last Name", JLabel.TRAILING);
		lNameTextField = new JTextField(20);
		passwordLabel.setLabelFor(lNameTextField);
		// loginButton = new JButton("Sign In");
		newButton = new JButton("Sign Up New User");
		loginManagerButton = new JButton("Login Manager");
		msgLabel = new JLabel("");
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
        JPanel jp = new JPanel(new SpringLayout());
        this.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        jp.add(emailLabel);		
		jp.add(fNAmeTextField);
		jp.add(passwordLabel);
		jp.add(lNameTextField);
		//jp.add(loginButton);
		//jp.add(msgLabel);
		
		//this.add(calcPanel);
		
		// SpringUtilities.makeCompactGrid(jp, 2, 2, //rows, cols
		//         6, 6, //initX, initY
		//         6, 6); //xPad, yPad
		this.add(headerLabel, gbc);
		this.add(jp, gbc);
		this.add(msgLabel, gbc);
		this.add(login,gbc);
		this.add(newButton,gbc);
		this.add(loginManagerButton,gbc);
    }
    
}
