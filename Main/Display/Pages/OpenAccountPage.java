package Main.Display.Pages;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Main.Accounts.CheckingsAccount;
import Main.Accounts.ClientAccount;
import Main.Accounts.SavingsAccount;
import Main.Currencies.Dollar;
import Main.Requests.AccountOpening;
import Main.Users.Client;

public class OpenAccountPage extends Page {
	
	private Client client;
	private JButton goButton;
	private LabeledTextField amountBox;
    private JComboBox accountType;

	
	public OpenAccountPage() {
		this(null);
	}
	
	public OpenAccountPage(Client client) {
		super();
		this.client = client;
		goButton = new JButton("Go");
		amountBox = new LabeledTextField("Starting amount: ", 5);
		accountType = new JComboBox(new String[] {"Checking", "Savings"});
		goButton.addActionListener(this);
		display();
	}
	
	private ClientAccount getSelectedAccount() {
		String selection = accountType.getSelectedItem().toString();
		if(selection.equals("Checking")) {
			return new CheckingsAccount();
		}
		else if(selection.equals("Savings")) {
			return new SavingsAccount();
		}
		else {
			return null;
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if(s.equals("Go")) {
			String amountString = amountBox.getText();
			double amount = 0;
			try {
				amount = Double.parseDouble(amountString);
			}
			catch(Exception ex) {
				return;
			}
			AccountOpening open = new AccountOpening();
			open.setClient(client);
			open.setAccountToOpen(getSelectedAccount());
			open.setStartingAmount(new Dollar(amount));
			setCurrentRequest(open);
		}

	}

	@Override
	public void display() {
		this.add(goButton);
		this.add(amountBox);
		this.add(accountType);
	}

}
