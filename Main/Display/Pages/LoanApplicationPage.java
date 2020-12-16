package Main.Display.Pages;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Main.Currencies.Currency;
import Main.Requests.LoanApplication;
import Main.Requests.PageChange;
import Main.Users.Client;
import Main.Users.User;

public class LoanApplicationPage extends Page {

    private LabeledTextField amountInput, collateralInput;
    private JComboBox currencyInput;
    private JButton applyButton, backButton;
    private JLabel description;
    private Client client;

	public LoanApplicationPage() {
		this(null);
	}
	
	public LoanApplicationPage(Client client) {
		super();
		this.client = client;
        amountInput = new LabeledTextField("Starting Amount: ", 5);
        collateralInput = new LabeledTextField("Collateral: ", 5);
        currencyInput = new JComboBox(Currency.usableCurrencies) ;
        applyButton = new JButton("Apply for Loan");
        backButton = new JButton("Back");
        description = new JLabel("You may apply for a loan here!");
        applyButton.addActionListener(this);
        backButton.addActionListener(this);
        display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("Apply for Loan")) {
			String amountStr = amountInput.getText(),
					collateralStr = collateralInput.getText(),
					currencyStr = currencyInput.getSelectedItem().toString();
			LoanApplication application = new LoanApplication();
			application.setCurrencyRepresentation(amountStr);
			application.setCurrencyName(currencyStr);
			application.setCollateral(collateralStr);
			application.setClient(client);
			this.setCurrentRequest(application);
		}
		else if(s.equals("Back")) {
			this.setCurrentRequest(new PageChange(new UserPage(client)));
		}
	}

	@Override
	public void display() {
        this.add(this.description); 
        this.add(this.collateralInput);
        this.add(this.amountInput);
        this.add(this.currencyInput);
        this.add(this.applyButton);
        this.add(this.backButton);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
