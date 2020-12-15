package Main.Requests;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for transactions
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Accounts.ClientAccount;
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;

public abstract class Transaction extends Request {

    /* Data Members */
	protected DepositAccount account;
	protected Currency moneyToMove;

    /* Constructors */
	public Transaction() {
		this(null, null);
	}
	
	public Transaction(DepositAccount account, Currency moneyToMove) {
		this.account = account;
		this.moneyToMove = moneyToMove;
	}

    /* Accessor Methods */
	public ClientAccount getAccount() {
		return account;
	}

	public Currency getMoneyToMove() {
		return moneyToMove;
	}

    /* Mutator Methods */
	public void setAccount(DepositAccount account) {
		this.account = account;
	}

	public void setMoneyToMove(Currency moneyToMove) {
		this.moneyToMove = moneyToMove;
	}

    /* Logic Methods */
	
	public abstract boolean canMakeTransaction();
	public abstract boolean makeTransaction();
	
    @Override
    public int performRequest(Bank bank, FancyATM atm) {
    	//TODO: Manage fees
    	if(!canMakeTransaction()) {
    		setFlag(-1);
    		return -1;
    	}
    	if(!makeTransaction()) {
    		setFlag(-1);
    		return -1;
    	}
    	setFlag(1);
        return 1;
    }
    
}
