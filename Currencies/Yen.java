package Main.Currencies;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Concrete currency
 * 
 */

/* External Imports */

/* Internal Imports */

public class Yen extends Currency {
    
    /* Data Members */

    /* Constructors */
	public Yen() {
		this(null);
	}
	
	public Yen(double amount) {
		super(amount);
	}
	
	public Yen(Currency currency2) {
		super(currency2);
	}

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

	@Override
	protected void determineName() {
		name = "Yen";
	}

	@Override
	protected void determineExchangeRate() {
		exchangeRate = 103.73;
	}
	
	@Override
	public Yen duplicate() {
		return new Yen(quantity);
	}

}
