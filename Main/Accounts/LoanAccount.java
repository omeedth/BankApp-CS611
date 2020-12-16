package Main.Accounts;

import Main.Bank;

/* 
 *  Author: 
 *  Creation Date: 12/14/2020
 *  Purpose: Represents an account storing information about a client's loans
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Currencies.Currency;

public class LoanAccount extends ClientAccount {
	
    /* Data Members */
	private String collateral;
	private Currency originalLoan, loanRemaining;


    /* Constructors */
	public LoanAccount() {
		collateral = null;
		originalLoan = null;
		loanRemaining = null;
	}
	
	public LoanAccount(String collateral, Currency originalLoan) {
		this.collateral = collateral;
		this.originalLoan = originalLoan;
	}


    /* Accessor Methods */
	
	public String getCollateral() {
		return collateral;
	}

	public Currency getOriginalLoan() {
		return originalLoan;
	}

	public Currency getLoanRemaining() {
		return loanRemaining;
	}


    /* Mutator Methods */

	public void setOriginalLoan(Currency originalLoan) {
		this.originalLoan = originalLoan;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}
	
	public void setLoanRemaining(Currency loanRemaining) {
		this.loanRemaining = loanRemaining;
	}


    /* Logic Methods */
	@Override
	public void determineMinAmount() {
		minAmount = 0;
	}
	
	public boolean hasEnoughLoanLeft(Currency money) {
		return money.getQuantity() <= loanRemaining.getQuantity();
	}
	
	public boolean wouldOverpay(Currency money) {
		return money.getQuantity() > accountBalance.getQuantity();
	}
	
	public boolean increaseLoan(Currency money) {
		if(!hasEnoughLoanLeft(money)) {
			return false;
		}
		loanRemaining.removeMoney(money);
		accountBalance.receiveMoney(money);
		return true;
	}

	public boolean payBackLoan(Currency money) {
		if(wouldOverpay(money)) {
			return false;
		}
		accountBalance.removeMoney(money);
		return true;
	}

	@Override
	public boolean canSendTransfer(Currency money) {
		return hasEnoughLoanLeft(money);
	}

	@Override
	public boolean canReceiveTransfer(Currency money) {
		return !wouldOverpay(money);
	}

	@Override
	protected boolean sendTransfer(Currency money) {
		return increaseLoan(money);
	}

	@Override
	protected boolean receiveTransfer(Currency money) {
		return payBackLoan(money);
	}

	@Override
	public boolean isEligibleForInterest() {
		return true;
	}

	@Override
	public void addInterest() {
		accountBalance.multiplyQuantity(1+Bank.loanInterest);
	}

	@Override
	public String getAccountType() {
		return "Loan";
	}

}
