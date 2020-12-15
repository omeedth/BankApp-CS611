package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;

public class AccountOpening extends Request {
	
	protected Account accountToOpen;
	
	public AccountOpening() {
		accountToOpen = null;
	}

	@Override
	public int performRequest(Bank bank, FancyATM atm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
