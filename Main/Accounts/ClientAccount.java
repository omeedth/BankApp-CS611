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
import Main.Currencies.Currency;

public abstract class ClientAccount extends Account {

    /* Data Members */
	private Client accountHolder;
	protected Currency accountBalance;
	protected String currencyType;
	protected double minAmount;

    /* Constructors */
	public ClientAccount() {
		this(null);
	}
	
	public ClientAccount(Currency startingBalance) {
		super();
		accountHolder = null;
		accountBalance = startingBalance;
		currencyType = null;
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

    /* Mutator Methods */
	public void setAccountBalance(Currency accountBalance) {
		if(accountBalance.getQuantity() >= minAmount) {
			this.accountBalance = accountBalance;
		}
	}

    /* Logic Methods */
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

}
