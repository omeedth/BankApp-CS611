package Main.Accounts;


/* 
 *  Author: 
 *  Creation Date: 12/12/2020
 *  Purpose: Abstract class for any account capable of depositing and withdrawing
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;

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
	
	protected boolean willRemainAboveMinAmount(Currency moneyToWithdraw) {
		return accountBalance.computeQuantityDifference(moneyToWithdraw) >= minAmount;
	}

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
	
	public void addInterest(double interestRate) {
		accountBalance.multiplyQuantity(1+interestRate);
	}
		
	
}
