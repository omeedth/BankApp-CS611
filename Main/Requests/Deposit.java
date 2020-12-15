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
 *  Purpose: Class defining the deposit transaction
 * 
 */

/* External Imports */

/* Internal Imports */

public class Deposit extends Transaction {

    /* Data Members */

    /* Constructors */
	public Deposit() {
		this(null, null);
	}

	public Deposit(DepositAccount account, Currency moneyToMove) {
		super(account, moneyToMove);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	public boolean canMakeTransaction() {
		return account.canDeposit(moneyToMove);
	}

	@Override
	public boolean makeTransaction() {
		return account.deposit(moneyToMove);
	}
    
}
