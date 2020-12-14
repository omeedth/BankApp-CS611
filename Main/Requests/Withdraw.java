package Main.Requests;

import Main.Bank;
import Main.FancyATM;
import Main.Accounts.ClientAccount;
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;
import Main.Users.User;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the withdraw transaction
 * 
 */

/* External Imports */

/* Internal Imports */

public class Withdraw extends Transaction {
    
    /* Data Members */

    /* Constructors */
	public Withdraw() {
		this(null, null);
	}

	public Withdraw(DepositAccount account, Currency moneyToMove) {
		super(account, moneyToMove);
	}


    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	public boolean canMakeTransaction() {
		return account.canWithdraw(moneyToMove);
	}

	@Override
	public boolean makeTransaction() {
		return account.withdraw(moneyToMove);
	}

}
