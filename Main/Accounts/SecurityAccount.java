package Main.Accounts;

import Main.Currencies.Currency;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining security account (stocks)
 * 
 */

/* External Imports */

/* Internal Imports */

public class SecurityAccount extends ClientAccount {

    /* Data Members */

    /* Constructors */

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	public boolean canSendTransfer(Currency money) {
		return accountBalance.computeQuantityDifference(money) >= minAmount;
	}

	@Override
	public boolean canReceiveTransfer(Currency money) {
		return true;
	}

	@Override
	protected boolean sendTransfer(Currency money) {
		if(!canSendTransfer(money)) {
			return false;
		}
		accountBalance.removeMoney(money);
		return true;
	}

	@Override
	protected boolean receiveTransfer(Currency money) {
		if(!canReceiveTransfer(money)) {
			return false;
		}
		accountBalance.receiveMoney(money);
		return true;
	}

	@Override
	public void determineMinAmount() {
		minAmount = 0;
	}
    
}
