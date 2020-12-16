package Main.Currencies;

/* 
 *  Author: 
 *  Creation Date: 12/4/2020
 *  Purpose: Abstract class defining currencies
 * 
 */

/* External Imports */

/* Internal Imports */

public abstract class Currency {
	
	public static final String[]usableCurrencies = new String[]{"Dollar", "Yen", "Pound"};
	
    /* Data Members */
	protected double quantity;
	protected String name;
	protected double exchangeRate;

    /* Constructors */
	public Currency() {
		this(0);
	}
	
	public Currency(double amount) {
		determineName();
		determineExchangeRate();
		quantity = amount;
}
	
	public Currency(Currency currency2) {
		this();
		if(currency2 == null) {
			quantity = 0;
		}
		else {
			quantity = convertFrom(currency2);
		}
	}

    /* Accessor Methods */
	public double getQuantity() {
		return quantity;
	}

	public String getCurrencyName() {
		return name;
	}
	
	public double getExchangeRate() {
		return exchangeRate;
	}

    /* Mutator Methods */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

    /* Logic Methods */
	
	protected abstract void determineName();
	protected abstract void determineExchangeRate();
	public abstract Currency duplicate();
	
	private double convertFrom(Currency currency2) {
		double multiplier = exchangeRate/currency2.exchangeRate;
		return currency2.quantity * multiplier;
	}
	
	public double computeQuantitySum(Currency money) {
		return quantity + convertFrom(money);
	}
	
	public double computeQuantityDifference(Currency money) {
		return quantity - convertFrom(money);
	}
	
	public void receiveMoney(Currency money) {
		quantity = computeQuantitySum(money);
	}
	
	public void removeMoney(Currency money) {
		quantity = computeQuantityDifference(money);
	}
	
	public void multiplyQuantity(double multiplier) {
		quantity *= multiplier;
	}

	@Override
	public String toString() {
		return "" + quantity + " " + name;
	}
	
	/* Static Methods */

	public static Currency getCurrency(double amount, String currencyType) {
		if (currencyType.equals(Dollar.class.getSimpleName())) {
			return new Dollar(amount);
		} else if (currencyType.equals(Yen.class.getSimpleName())) {
			return new Yen(amount);
		} else if (currencyType.equals(Pound.class.getSimpleName())) {
			return new Pound(amount);
		} else {
			return null;
		}
	}

	public static Currency createInstanceOfType(String currencyName) {
		if(currencyName.equals("Dollar")) {
			return new Dollar();
		}
		else if(currencyName.equals("Yen")) {
			return new Yen();
		}
		else if(currencyName.equals("Pound")) {
			return new Pound();
		}
		return null;
	}
    
}
