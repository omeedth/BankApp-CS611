package Main.Accounts;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class for accounts for clients/customers
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Users.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import Main.Bank;
import Main.Currencies.Currency;
import Main.Records.AccountEntry;

public abstract class ClientAccount extends Account {

	/* Data Members */
	private Client accountHolder;
	protected Currency accountBalance;
	protected String currencyType;
	protected double minAmount;

	/* Constructors */
	public ClientAccount() {
		super();
		accountHolder = null;
		accountBalance = null;
		currencyType = null;
		determineMinAmount();
	}

	public ClientAccount(Currency startingBalance) {
		super();
		accountHolder = null;
		accountBalance = startingBalance;
		currencyType = startingBalance.getCurrencyName();
		determineMinAmount();
	}

	public ClientAccount(Client accountHolder, Currency startingBalance) {
		super();
		this.accountHolder = accountHolder;
		accountBalance = startingBalance;
		currencyType = (startingBalance != null ? startingBalance.getCurrencyName() : null);
		determineMinAmount();
	}

	public ClientAccount(AccountEntry accountEntry, Client accountUser) throws ParseException {
		super(Integer.parseInt((String) accountEntry.getRecordData().get("id")), new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH).parse(((String) accountEntry.getRecordData().get("creationDate")))); // new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH).parse(((String) accountEntry.getRecordData().get("creationDate")))
		accountHolder = accountUser;
		accountBalance = Currency.getCurrency(Double.parseDouble((String) accountEntry.getRecordData().get("balance")), (String) accountEntry.getRecordData().get("currencyType"));
		currencyType = (String) accountEntry.getRecordData().get("currencyType");
		determineMinAmount();
	}

    /* Accessor Methods */
	public Client getAccountHolder() {
		return accountHolder;
	}
	
	public Currency getAccountBalance() {
		return accountBalance;
	}
	
	public String getCurrencyType() {
		return currencyType;
	}
	
	public double getMinAmount() {
		return minAmount;
	}

    /* Mutator Methods */
	public void setAccountBalance(Currency accountBalance) {
		if(accountBalance.getQuantity() >= minAmount) {
			this.accountBalance = accountBalance;
		}
	}
	
	
	public void setAccountHolder(Client c) {
		accountHolder = c;
	}

    /* Logic Methods */
	
	protected boolean willRemainAboveMinAmount(Currency moneyToWithdraw) {
		return accountBalance.computeQuantityDifference(moneyToWithdraw) >= minAmount;
	}
	public abstract void determineMinAmount();
	public abstract boolean canSendTransfer(Currency money);
	public abstract boolean canReceiveTransfer(Currency money);
	public boolean canTransferTo(Currency money, ClientAccount targetAccount) {
		return hasSameHolder(targetAccount) && canSendTransfer(money) && targetAccount.canReceiveTransfer(money);
	}

	protected abstract boolean sendTransfer(Currency money);
	protected abstract boolean receiveTransfer(Currency money);
	public boolean transferTo(Currency money, ClientAccount targetAccount) {
		boolean sendSuccess = sendTransfer(money);
		if(!sendSuccess) {
			return false;
		}
		boolean receiveSuccess = targetAccount.receiveTransfer(money);
		return receiveSuccess;
	}
	
	public abstract boolean isEligibleForInterest();

	public abstract void addInterest();

	@Override
	public String toString() {
		return "<ClientAccount: " + this.getClass().getSimpleName() + ", ID: " + getAccountID() + ", Time Created: " + getDateCreated() + ", Account Balance: " + getAccountBalance() + ", Currency Type: " + getCurrencyType() + ", Account Holder: " + getAccountHolder().getId() + ">";
	}

}
