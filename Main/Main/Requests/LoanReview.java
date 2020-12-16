package Main.Requests;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for accepting/rejecting loans
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Accounts.LoanAccount;
import Main.Currencies.Currency;
import Main.Users.Client;

public class LoanReview extends LoanProcess {
	

    /* Data Members */
	protected boolean accepted;

    /* Constructors */
	public LoanReview() {
		this(null, null, null);
	}

	public LoanReview(Client client, String collateral, Currency amountRequested) {
		super(client, collateral, amountRequested);
		accepted = false;
	}
	

    /* Accessor Methods */
	public boolean getAccepted() {
		return accepted;
	}
	
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}


    /* Mutator Methods */

    /* Logic Methods */
	@Override
	public int performRequest(FancyATM atm) {
		int status = 0;
		if(accepted) {
			LoanAccount account = new LoanAccount(collateral, amountRequested.duplicate());
			client.addAccount(account);
			Bank bank = atm.getBank();
			bank.addToHistory(createRecordEntry());
		}
		
		if(!accepted) {
			//TODO: Process for when a loan is not approved
		}
		setFlag(status);
		return status;
	}

    

}
