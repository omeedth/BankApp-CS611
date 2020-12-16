package Main.Display.Pages;

import Main.Accounts.SavingsAccount;

public class SavingsPage extends DepositAccountPage {

	public SavingsPage() {
		this(null);
	}
	
	public SavingsPage(SavingsAccount account) {
		super(account);
	}


}
