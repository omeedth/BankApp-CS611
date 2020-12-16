package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;
import Main.Accounts.ClientAccount;
import Main.Currencies.Currency;
import Main.Users.Client;

public class AccountOpening extends Request {
	
	protected ClientAccount accountToOpen;
	protected Currency startingAmount;
	protected Client client;
	
	public AccountOpening() {
		accountToOpen = null;
		startingAmount = null;
		client = null;
	}

	public ClientAccount getAccountToOpen() {
		return accountToOpen;
	}

	public Currency getStartingAmount() {
		return startingAmount;
	}
	
	public Client getUser() {
		return client;
	}

	public void setAccountToOpen(ClientAccount accountToOpen) {
		this.accountToOpen = accountToOpen;
	}

	public void setStartingAmount(Currency startingAmount) {
		this.startingAmount = startingAmount;
	}
	
	public void setUser(Client client) {
		this.client = client;
	}

	@Override
	public int performRequest(FancyATM atm) {
		Currency amountAfterFee = startingAmount.duplicate();
		amountAfterFee.removeMoney(Bank.fee);
		if(amountAfterFee.getQuantity() - accountToOpen.getMinAmount() < 0) {
			setFlag(-1);
			return -1;
		}
		client.addAccount(accountToOpen);
		accountToOpen.setAccountHolder(client);
		accountToOpen.getAccountBalance().removeMoney(Bank.fee);
		atm.getBank().addToGains(Bank.fee);
		setFlag(1);
		return 1;
	}

}
