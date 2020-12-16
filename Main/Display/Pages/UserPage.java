package Main.Display.Pages;

import java.awt.event.ActionEvent;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining User page (client's accounts)
 * 
 */

/* External Imports */
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

import Main.Requests.Login;
import Main.Requests.PageChange;
/* Internal Imports */
import Main.Users.*;

public class UserPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = 3627423803935650519L;

    /* Data Members */
    private Client client;
    private JButton loanRequestButton, logoutButton;

    /* Constructors */
    public UserPage() {
    	this(null);
    }

    public UserPage(Client client) {
        this.client = client;
        loanRequestButton = new JButton("Request Loan");
        logoutButton = new JButton("Logout");
        loanRequestButton.addActionListener(this);
        logoutButton.addActionListener(this);
        display();
    }

    /* Accessor Methods */

    public User getUser() {
        return client;
    }    

    /* Mutator Methods */

    /* Logic Methods */

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	String s = e.getActionCommand();
    	if(s.equals("Request Loan")) {
    		setCurrentRequest(new PageChange(new LoanApplicationPage(client)));
    	}
    	else if(s.equals("Logout")) {
    		setCurrentRequest(new PageChange(new LoginPage()));
    	}
    }

    @Override
    public void display() {
    	add(loanRequestButton);
    	add(logoutButton);
    }
    
}
