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

import Main.Accounts.CheckingsAccount;
import Main.Accounts.SavingsAccount;
import Main.Requests.AccountOpening;
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
    private LabeledTextField targetAccountBox;
    private ArrayList<JLabel>accountInfo;

    // Display
    private JLabel userLabel;
    private JTextField amount;
    private JButton deposit;
    private JButton withdraw;
    private JButton openCheckings;
    private JButton openSavings;

    /* Constructors */
    public UserPage() {
    	this(null);
    }
        
    public UserPage(Client client) {
        super();
        
        // Alex
        userLabel = new JLabel(client.toString());
        amount = new JTextField("Amount");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        openCheckings = new JButton("Open Checkings Account");
        openSavings = new JButton("Open Savings Account");

        this.init();

        // Rohit
        this.client = client;
        loanRequestButton = new JButton("Request Loan");
        logoutButton = new JButton("Logout");
        goToAccount = new JButton("Go to Account");
        openAccount = new JButton("Open New Account");
        targetAccountBox = new LabeledTextField("Account ID: ", 5);
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

    public void init() {
        /* Initialize the listeners */
        // this.usernameInput.addActionListener(this);
        // this.passwordInput.addActionListener(this);
        this.deposit.addActionListener(this);   
        this.withdraw.addActionListener(this);
        this.openCheckings.addActionListener(this);
        this.openSavings.addActionListener(this);
        // this.register.addActionListener(this);
        // display();    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand(); 
        System.out.println("Action Command: " + s);
        if (s.equals("Deposit")) { 
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String depositAmount = amount.getText();
            System.out.println("Deposit Amount: " + depositAmount);          
            // this.setCurrentRequest(new Login(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } else if (s.equals("Withdraw")) {
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String withdrawAmount = amount.getText();      
            System.out.println("Withdraw Amount: " + withdrawAmount);      
            // this.setCurrentRequest(new Register(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } else if (s.equals("Open Checkings Account")) {
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String startAmount = amount.getText();      
            double startAmountVal = 0;

            try {
                startAmountVal = Double.parseDouble(startAmount);
            } catch(Exception exception) {

            }

            System.out.println("Checkings Start Amount: " + startAmountVal);      
            this.setCurrentRequest(new AccountOpening(startAmountVal,CheckingsAccount.class.getSimpleName(),client,"Dollar"));
            // this.setCurrentRequest(new Register(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } else if (s.equals("Open Savings Account")) {
            /* Gets the username text, and the password text -> Calls FancyATM to login */
            String startAmount = amount.getText();      
            double startAmountVal = 0;

            try {
                startAmountVal = Double.parseDouble(startAmount);
            } catch(Exception exception) {

            }

            System.out.println("Savings Start Amount: " + startAmountVal);      
            this.setCurrentRequest(new AccountOpening(startAmountVal,SavingsAccount.class.getSimpleName(),client,"Dollar"));
            // this.setCurrentRequest(new Register(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
        } else if(s.equals("Request Loan")) {
    		setCurrentRequest(new PageChange(new LoanApplicationPage(client)));
    	}
    	else if(s.equals("Logout")) {
    		setCurrentRequest(new PageChange(new LoginPage()));
    	}
    	else if(s.equals("Go to Account")) {
    		String accountStr = targetAccountBox.getText();
    		setCurrentRequest(new JumpToAccount(client, accountStr));
    	}
    	else if(s.equals("Open New Account")) {
    		setCurrentRequest(new PageChange(new OpenAccountPage(client)));
    	}
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        this.add(userLabel);
        this.add(amount);
        this.add(deposit);
        this.add(withdraw);
        this.add(openCheckings);
        this.add(openSavings);
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
