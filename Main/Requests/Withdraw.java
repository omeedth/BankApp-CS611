package Main.Requests;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the withdraw transaction
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;

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
