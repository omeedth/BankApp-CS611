package Main.Display.Pages;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Main.Currencies.Currency;
import Main.Requests.LoanApplication;
import Main.Users.Client;
import Main.Users.User;

public class LoanApplicationPage extends Page {

    private JTextField amountInput, collateralInput;
    private JComboBox currencyInput;
    private JButton applyButton;
    private JLabel description;

	public LoanApplicationPage() {
        amountInput = new JTextField(5);
        collateralInput = new JTextField(5);
        currencyInput = new JComboBox(Currency.usableCurrencies) ;
        applyButton = new JButton("Apply for Loan");
        description = new JLabel("You may apply for a loan here!");
        applyButton.addActionListener(this);
        display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String amountStr = amountInput.getText(),
				collateralStr = collateralInput.getText(),
				currencyStr = currencyInput.getSelectedItem().toString();
		LoanApplication application = new LoanApplication();
		application.setCurrencyRepresentation(amountStr);
		application.setCurrencyName(currencyStr);
		application.setCollateral(collateralStr);
		application.setClient(new Client());
		this.setCurrentRequest(application);
	}

	@Override
	public void display() {
        this.add(this.amountInput);
        this.add(this.collateralInput);
        this.add(this.currencyInput);
        this.add(this.applyButton);
        this.add(this.description); 
	}

}
