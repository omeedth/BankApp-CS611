package Main.Display.Pages;

import javax.swing.*;

import Main.Accounts.CheckingsAccount;
import Main.Users.User;

public class CheckingPage extends DepositAccountPage {
	

	public CheckingPage() {
		this(null);
	}
	
	public CheckingPage(CheckingsAccount account) {
		super(account);
	}

}
