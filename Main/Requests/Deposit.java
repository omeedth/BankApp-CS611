package Main.Requests;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining the deposit transaction
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;

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
