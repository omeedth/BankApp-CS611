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

public class AccountOpening extends Request {
	
	protected Account accountToOpen;
	private double startAmount;
	private String accountType;
	private String currencyType;
	private User accountUser;
	
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

		if (accountType.equals(CheckingsAccount.class.getSimpleName())) {
			accountToOpen = new CheckingsAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else if (accountType.equals(SavingsAccount.class.getSimpleName())) {
			accountToOpen = new SavingsAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else if (accountType.equals(SecurityAccount.class.getSimpleName())) {
			accountToOpen = new SecurityAccount((Client) accountUser, Currency.getCurrency(startAmount, currencyType));
		} else if (accountType.equals(AdministrativeAccount.class.getSimpleName())) {
			accountToOpen = new AdministrativeAccount((Manager) accountUser);
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
	}

}
