package Main.Requests;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract classes for transactions
 * 
 */

/* External Imports */
import java.util.ArrayList;
import java.util.List;

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Accounts.ClientAccount;
import Main.Accounts.DepositAccount;
import Main.Currencies.Currency;
import Main.Records.Recordable;

public abstract class Transaction extends Request implements Recordable {

	/* Static/Final Members */
	public static int transactionCount;

	/* Data Members */
	private int transactionID;
	protected DepositAccount account;
	protected Currency moneyToMove;

    /* Constructors */
	public Transaction() {
		this(null, null);
	}
	
	public Transaction(DepositAccount account, Currency moneyToMove) {
		this.account = account;
		this.moneyToMove = moneyToMove;
		transactionID = transactionCount++;
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
    public int performRequest(FancyATM atm) {
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
	
	@Override
    public String toRecordString() {
        List<String> data = new ArrayList<>();

		/* Add All Data */
		data.add(Integer.toString(transactionID));
		data.add(this.getClass().getSimpleName()); // Transaction Name
		data.add(Integer.toString(this.account.getAccountID()));
		data.add(Double.toString(this.moneyToMove.getQuantity()));
		data.add(this.moneyToMove.getCurrencyName());

        return String.join(",", data);
    }
    
}
