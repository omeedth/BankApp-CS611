package Main.Requests;


import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;
import Main.Accounts.ClientAccount;
import Main.Currencies.Currency;

public class AccountClosing extends Request {
	
	protected ClientAccount accountToClose;
	
	public AccountClosing() {
		accountToClose = null;
	}

	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub
		Currency balanceWithoutFee = accountToClose.getAccountBalance();
		balanceWithoutFee.removeMoney(Bank.fee);
		if(balanceWithoutFee.getQuantity() > 0) {
			accountToClose.getAccountBalance().removeMoney(Bank.fee);
			atm.getBank().addToGains(Bank.fee);
			setFlag(1);
			return 1;
		}
		setFlag(-1);
		return -1;
	}

}
