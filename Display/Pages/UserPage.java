package Main.Display.Pages;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
import javax.swing.JLabel;

import Main.Accounts.Account;
import Main.Accounts.ClientAccount;
import Main.Requests.JumpToAccount;
import Main.Requests.Login;
import Main.Requests.PageChange;
/* Internal Imports */
import Main.Users.*;

public class UserPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = 3627423803935650519L;

    /* Data Members */
    private Client client;
    private JButton loanRequestButton, logoutButton, goToAccount, openAccount;
    private JTextField targetAccountBox;
    private ArrayList<JLabel>accountInfo;

    /* Constructors */
    public UserPage() {
    	this(null);
    }

    public UserPage(Client client) {
    	super();
        this.client = client;
        loanRequestButton = new JButton("Request Loan");
        logoutButton = new JButton("Logout");
        goToAccount = new JButton("Go to Account");
        openAccount = new JButton("Open Account");
        targetAccountBox = new JTextField(5);
        loanRequestButton.addActionListener(this);
        logoutButton.addActionListener(this);
        goToAccount.addActionListener(this);
        openAccount.addActionListener(this);
        writeAccountInfo();
        display();
    }
    
    public void writeAccountInfo() {
    	accountInfo = new ArrayList<JLabel>();
    	for(Account account : client.getAccounts()) {
    		String info = "Account Type: " + account.getAccountType() + "    Account ID: " + String.valueOf(account.getAccountID());
    		accountInfo.add(new JLabel(info));
    	}
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
    	else if(s.equals("Go to Account")) {
    		String accountStr = targetAccountBox.getText();
    		setCurrentRequest(new JumpToAccount(client, accountStr));
    	}
    	else if(s.equals("Open Account")) {
    		setCurrentRequest(new PageChange(new OpenAccountPage(client)));
    	}
    }

    @Override
    public void display() {
    	add(loanRequestButton);
    	add(logoutButton);
    	add(goToAccount);
    	add(targetAccountBox);
    	add(openAccount);
    	for(JLabel label : accountInfo) {
    		add(label);
    	}
    }
    
}
