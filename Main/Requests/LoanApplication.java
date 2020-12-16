package Main.Requests;


import javax.swing.JLabel;

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
import Main.Currencies.Dollar;
import Main.Display.Pages.LoanApplicationPage;
import Main.Display.Pages.LoanReviewPage;
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
    	if(amountRequested == null) {
    		try {
    			amountRequested = Currency.createInstanceOfType(currencyName);
				amountRequested.receiveMoney(new Dollar(Integer.parseInt(currencyRepresentation)));
    		}
    		catch(Exception e) {
				System.out.println("The amount of money is not an int");
				atm.goToPage(new LoanApplicationPage(client));
				JLabel msg = new JLabel("Please make sure that the amount of money is an integer.");
				atm.msgReturn(msg);
				setFlag(-1);
				return -1;
    		}
    	}
    	if(collateral.strip().length() == 0) {
    		System.out.println("No collateral was entered");
    		atm.goToPage(new LoanApplicationPage(client));
    		JLabel msg = new JLabel("Please make sure that you enter collateral");
    		atm.msgReturn(msg);
    		setFlag(-1);
    		return -1;
    	}
    	LoanReview review = new LoanReview(client, collateral, amountRequested);
    	Bank bank = atm.getBank();
    	bank.sendLoanApplicationInformation(review);
    	setFlag(1);
        return 1;
    }

}
