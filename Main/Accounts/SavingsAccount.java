package Main.Accounts;

import java.text.ParseException;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining savings account
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;
import Main.Records.AccountEntry;
import Main.Users.Client;

public class SavingsAccount extends DepositAccount {

	/* Data Members */
	protected int totalWithdraws, withdrawsRemaining;

	/* Constructors */
	public SavingsAccount() {
		totalWithdraws = 6;
		withdrawsRemaining = 6;
	}

	public SavingsAccount(Currency startingBalance) {
		super(startingBalance);
	}

	public SavingsAccount(Client accountHolder, Currency startingBalance) {
		super(accountHolder,startingBalance);
	}

	public SavingsAccount(AccountEntry accountEntry) throws ParseException {
		super(accountEntry);
		totalWithdraws = 0;
		withdrawsRemaining = 0;
	}

    /* Accessor Methods */
	
	public int getTotalWithdraws() {
		return totalWithdraws;
	}
	
	public int getWithdrawsRemaining() {
		return withdrawsRemaining;
	}

    /* Mutator Methods */

    /* Logic Methods */
	
	public void resetWithdrawsRemaining() {
		withdrawsRemaining = totalWithdraws;
	}
	
	protected boolean hasRemainingWithdraws() {
		return withdrawsRemaining > 0;
	}
	
	@Override
	public void determineMinAmount() {
		minAmount = 2500;
	}

	@Override
	public boolean canDeposit(Currency money) {
		return true;
	}

	@Override
	public boolean canWithdraw(Currency money) {
		return hasRemainingWithdraws() && willRemainAboveMinAmount(money);
	}
	
	@Override
	public boolean withdraw(Currency money) {
		boolean result = super.withdraw(money);
		if(result) {
			withdrawsRemaining--;
		}
		return result;
	}
}
