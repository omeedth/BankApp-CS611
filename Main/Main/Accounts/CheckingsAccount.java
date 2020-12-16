package Main.Accounts;


import Main.Bank;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class defining checkings account
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;
import Main.Currencies.Dollar;

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

	public boolean canPayDepositFee(Currency moneyToDeposite) {
		Dollar depositWithBalance = new Dollar(accountBalance);
		depositWithBalance.receiveMoney(moneyToDeposite);
		return depositWithBalance.computeQuantityDifference(Bank.fee) >= minAmount;
	}

	@Override
	public boolean canDeposit(Currency money) {
		return canPayDepositFee(money);
	}

	public boolean canPayWithdrawalFee(Currency moneyToWithdraw) {
		Currency withdrawalWithFee = moneyToWithdraw.duplicate();
		withdrawalWithFee.receiveMoney(Bank.fee);
		return willRemainAboveMinAmount(withdrawalWithFee);
	}

	@Override
	public boolean canWithdraw(Currency money) {
		return willRemainAboveMinAmount(money) && canPayWithdrawalFee(money);
	}
	
	@Override
	public boolean deposit(Currency money) {
		boolean result = super.deposit(money);
		accountBalance.removeMoney(Bank.fee);
		bank.addToGains(Bank.fee);
		return result;
	}

}
