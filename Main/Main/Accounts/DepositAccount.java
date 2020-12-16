package Main.Accounts;


import Main.Bank;

/* 
 *  Author: 
 *  Creation Date: 12/12/2020
 *  Purpose: Abstract class for any account capable of depositing and withdrawing
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;
import Main.Currencies.Dollar;

public abstract class DepositAccount extends ClientAccount {
	

    /* Data Members */

    /* Constructors */
	public DepositAccount() {
		super();
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */
	public abstract boolean canDeposit(Currency money);
	public abstract boolean canWithdraw(Currency money);

	public boolean deposit(Currency money) {
		if(!canDeposit(money)) {
			return false;
		}
		accountBalance.receiveMoney(money);
		return true;
	}

	public boolean withdraw(Currency money) {
		if(!canWithdraw(money)) {
			return false;
		}
		accountBalance.removeMoney(money);
		accountBalance.removeMoney(Bank.fee);
		bank.addToGains(Bank.fee);
		return true;
	}

	@Override
	public boolean canSendTransfer(Currency money) {
		return canWithdraw(money);
	}

	@Override
	public boolean canReceiveTransfer(Currency money) {
		return canDeposit(money);
	}
		
	@Override
	protected boolean sendTransfer(Currency money) {
		return withdraw(money);
	}
		
	@Override
	protected boolean receiveTransfer(Currency money) {
		return deposit(money);
	}
	
	@Override
	public boolean isEligibleForInterest() {
		return accountBalance.computeQuantityDifference(Bank.minToReceiveInterest) >= 0;
	}

	@Override
	public void addInterest() {
		accountBalance.multiplyQuantity(1+Bank.savingsInterest);
	}
		
	
}
