package Main.Currencies;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Concrete currency
 * 
 */

/* External Imports */

/* Internal Imports */

public class Dollar extends Currency {
    
    /* Data Members */

    /* Constructors */
	public Dollar() {
		this(null);
	}
	
	public Dollar(double amount) {
		super(amount);
	}
	
	public Dollar(Currency currency2) {
		super(currency2);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	protected void determineName() {
		name = "Dollar";
	}

	@Override
	protected void determineExchangeRate() {
		exchangeRate = 1;
	}
	
	@Override
	public Dollar duplicate() {
		return new Dollar(quantity);
	}

}
