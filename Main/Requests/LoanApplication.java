package Main.Requests;


/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Class for applying for loans
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Currencies.Currency;
import Main.Users.Client;

public class LoanApplication extends LoanProcess {

    /* Data Members */

    /* Constructors */
	public LoanApplication() {
		this(null, null, null);
	}

	public LoanApplication(Client client, String collateral, Currency amountRequested) {
		super(client, collateral, amountRequested);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */
    
    @Override
    public int performRequest(FancyATM atm) {
        LoanReview review = new LoanReview(client, collateral, amountRequested);
        Bank bank = atm.getBank();
    	bank.sendLoanApplicationInformation(review);
    	setFlag(1);
        return 1;
    }

}
