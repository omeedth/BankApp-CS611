package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.Account;
import Main.Accounts.AdministrativeAccount;
import Main.Accounts.CheckingsAccount;
import Main.Accounts.SavingsAccount;
import Main.Accounts.SecurityAccount;
import Main.Currencies.Currency;
import Main.Records.AccountEntry;
import Main.Users.Client;
import Main.Users.Manager;
import Main.Users.User;
import Main.Utility.FileParserUtility;

import Main.Accounts.ClientAccount;
import Main.Currencies.Currency;
import Main.Display.Pages.UserPage;
import Main.Users.Client;

public class AccountOpening extends Request {
	
	// Alex
	// protected Account accountToOpen;
	private double startAmount;
	private String accountType;
	private String currencyType;
	private User accountUser;

	// Rohit
	protected ClientAccount accountToOpen;
	protected Currency startingAmount;
	protected Client client;
	
	public AccountOpening() {		
		this(0,"",null,"");
	}

	public AccountOpening(String accountType) {
		this(0,accountType,null,"");
	}

	public AccountOpening(String accountType, User accountUser) {
		this(0,accountType,accountUser,"");
	}

	public AccountOpening(double startAmount, String accountType, User accountUser) {
		this(startAmount, accountType, accountUser, "");
	}

	public AccountOpening(double startAmount, String accountType, User accountUser, String currencyType) {
		accountToOpen = null;
		this.startAmount = startAmount;
		this.accountType = accountType;
		this.accountUser = accountUser;
		this.currencyType = currencyType;
	}

	/* Accessor Methods */

	public double getStartAmount() {
		return startAmount;

		// startingAmount = null;
		// client = null;
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

	public String getAccountType() {
		return accountType;
	}

	public User getAccountUser() {
		return accountUser;
	}

	/* Mutator Methods */
	
	/* Logic Methods */

	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub

		int status = 0;

		accountToOpen = null;

		// Alex	
		if (accountType.equals(CheckingsAccount.class.getSimpleName())) {
			accountToOpen = new CheckingsAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else if (accountType.equals(SavingsAccount.class.getSimpleName())) {
			accountToOpen = new SavingsAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else if (accountType.equals(SecurityAccount.class.getSimpleName())) {
			accountToOpen = new SecurityAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else {
			status = -1;
		}

		if (accountToOpen != null) {
			accountUser.getAccounts().add(accountToOpen);
			AccountEntry accountEntry = new AccountEntry(accountToOpen);
			atm.getBank().getAccounts().getRecordEntries().add(accountEntry);
			FileParserUtility.writeLine(accountEntry, AccountEntry.filepath, true);
		}

		return status;

		// Rohit
		/*
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
		*/
	}

}
