package Main.Display.Pages;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Main.Accounts.Account;
import Main.Accounts.ClientAccount;
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;
import Main.Requests.Deposit;
import Main.Requests.PageChange;
import Main.Requests.Withdraw;
import Main.Users.User;

public abstract class DepositAccountPage extends Page {
	
	private DepositAccount account;
	private JLabel balance;
    private JTextField depositInput, withdrawalInput;
    private JButton depositButton, withdrawalButton, backButton;
	public DepositAccountPage() {
		this(null);
	}

	public DepositAccountPage(DepositAccount account) {
		super();
		this.account = account;
		balance = new JLabel("Account balance: " + account.getAccountBalance().getQuantity());
		depositButton = new JButton("Deposit");
		depositInput = new JTextField(5);
		withdrawalButton = new JButton("Withdraw");
		withdrawalInput = new JTextField(5);
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		depositButton.addActionListener(this);
		withdrawalButton.addActionListener(this);
		display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Back")) {
			setCurrentRequest(new PageChange(new UserPage(account.getAccountHolder())));
		}
		else if(s.equals("Deposit")) {
			String input = depositInput.getText();
			double amount = 0;
			try{
				amount = Double.parseDouble(input);
			}
			catch(Exception ex) {
				return;
			}
			Currency c = account.getAccountBalance().duplicate();
			c.setQuantity(amount);
			setCurrentRequest(new Deposit(account, c));
		}
		else if(s.equals("Withdraw")) {
			String input = withdrawalInput.getText();
			double amount = 0;
			try{
				amount = Double.parseDouble(input);
			}
			catch(Exception ex) {
				return;
			}
			Currency c = account.getAccountBalance().duplicate();
			c.setQuantity(amount);
			setCurrentRequest(new Withdraw(account, c));
		}
	}

	@Override
	public void display() {
		this.add(balance);
		this.add(depositButton);
		this.add(depositInput);
		this.add(withdrawalButton);
		this.add(withdrawalInput);
		this.add(backButton);
	}
	
}
