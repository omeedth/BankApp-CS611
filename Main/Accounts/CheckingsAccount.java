package Main.Accounts;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining checkings account
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;

public class CheckingsAccount extends DepositAccount {
    
    /* Data Members */

    /* Constructors */

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
