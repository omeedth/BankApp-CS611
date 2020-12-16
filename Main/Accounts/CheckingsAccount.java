package Main.Accounts;

import java.text.ParseException;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining checkings account
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;
import Main.Records.AccountEntry;
import Main.Users.Client;

public class CheckingsAccount extends DepositAccount {

	/* Data Members */

	/* Constructors */

	public CheckingsAccount() {
		super();
	}

	public CheckingsAccount(Currency startingBalance) {
		super(startingBalance);
	}

	public CheckingsAccount(Client accountHolder, Currency startingBalance) {
		super(accountHolder,startingBalance);
	}

	public CheckingsAccount(AccountEntry accountEntry) throws ParseException {
		super(accountEntry);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	public void determineMinAmount() {
		minAmount = 0;
	}

	@Override
	public boolean canDeposit(Currency money) {
		return true;
	}

	@Override
	public boolean canWithdraw(Currency money) {
		return willRemainAboveMinAmount(money);
	}

}
