package Main.Currencies;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Concrete currency
 * 
 */

/* External Imports */

/* Internal Imports */

public class Pound extends Currency {
    
    /* Data Members */

    /* Constructors */
	public Pound() {
		this(null);
	}
	
	public Pound(double amount) {
		super(amount);
	}
	
	public Pound(Currency currency2) {
		super(currency2);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	protected void determineName() {
		name = "Pound";
	}

	@Override
	protected void determineExchangeRate() {
		exchangeRate = 0.75;
	}
	
	@Override
	public Pound duplicate() {
		return new Pound(quantity);
	}

}
