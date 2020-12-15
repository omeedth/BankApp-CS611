package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;

public class AccountClosing extends Request {
	
	protected Account accountToClose;
	
	public AccountClosing() {
		accountToClose = null;
	}

	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
