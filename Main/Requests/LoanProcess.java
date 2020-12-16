package Main.Requests;


/* 
 *  Author: 
 *  Creation Date: 12/14/2020
 *  Purpose: Abstract class for requests related to loans
 * 
 */

/* External Imports */

/* Internal Imports */
import Main.Bank;
import Main.FancyATM;
import Main.Currencies.Currency;
import Main.Users.Client;

public abstract class LoanProcess extends Request {

    /* Data Members */
	protected Client client;
	protected String collateral;
	protected Currency amountRequested;
	protected String currencyRepresentation;
	protected String currencyName;
	

    /* Constructors */
	public LoanProcess() {
		this(null, null, null);
	}
	
	public LoanProcess(Client client, String collateral, Currency amountRequested) {
		this.client = client;
		this.collateral = collateral;
		this.amountRequested = amountRequested;
		this.currencyRepresentation = null;
		this.currencyName = null;
	}


    /* Accessor Methods */
	public Client getClient() {
		return client;
	}

	public String getCollateral() {
		return collateral;
	}

	public Currency getAmountRequested() {
		return amountRequested;
	}

	public String getCurrencyRepresentation() {
		return currencyRepresentation;
	}

	public String getCurrencyName() {
		return currencyName;
	}


    /* Mutator Methods */
	public void setClient(Client client) {
		this.client = client;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	public void setAmountRequested(Currency amountRequested) {
		this.amountRequested = amountRequested;
	}

	public void setCurrencyRepresentation(String currencyRepresentation) {
		this.currencyRepresentation = currencyRepresentation;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}


    /* Logic Methods */
	@Override
	public int performRequest(FancyATM atm) {
		// TODO Auto-generated method stub
		return 0;
	}





}
