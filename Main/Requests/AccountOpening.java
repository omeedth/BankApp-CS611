package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;
import Main.Accounts.ClientAccount;
import Main.Currencies.Currency;
import Main.Display.Pages.UserPage;
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
	
	public void setClient(Client client) {
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
		accountToOpen.setAccountBalance(startingAmount.duplicate());
		accountToOpen.getAccountBalance().removeMoney(Bank.fee);
		accountToOpen.setBank(atm.getBank());
		atm.getBank().addToGains(Bank.fee);
		atm.goToPage(new UserPage(client));
		setFlag(1);
		return 1;
	}

}
