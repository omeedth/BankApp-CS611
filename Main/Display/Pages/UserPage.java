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
import javax.swing.JLabel;

import Main.Accounts.CheckingsAccount;
import Main.Accounts.SavingsAccount;
import Main.Requests.AccountOpening;
/* Internal Imports */
import Main.Users.*;

public class UserPage extends Page {

    /* Static/Final Variables */
    private static final long serialVersionUID = 3627423803935650519L;

    /* Data Members */
    private User user;

    // Display
    private JLabel userLabel;
    private JTextField amount;
    private JButton deposit;
    private JButton withdraw;
    private JButton openCheckings;
    private JButton openSavings;

    /* Constructors */

    public UserPage(User user) {
        this.user = user;

        // Display
        userLabel = new JLabel(user.toString());
        amount = new JTextField("Amount");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        openCheckings = new JButton("Open Checkings Account");
        openSavings = new JButton("Open Savings Account");

        this.init();
        
    }

    /* Accessor Methods */

    public User getUser() {
        return user;
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
        display();    
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
            this.setCurrentRequest(new AccountOpening(startAmountVal,CheckingsAccount.class.getSimpleName(),user,"Dollar"));
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
            this.setCurrentRequest(new AccountOpening(startAmountVal,SavingsAccount.class.getSimpleName(),user,"Dollar"));
            // this.setCurrentRequest(new Register(username, password)); // The Front End will change the page itself when it performsRequest(); NOTE: Check Observer Pattern
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
    }
    
}
