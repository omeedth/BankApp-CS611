package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;

public class AccountEntering extends Request {
	
	protected Account accountToEnter;
	
	public AccountEntering() {
		accountToEnter = null;
	}

	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
