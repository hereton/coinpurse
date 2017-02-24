package coinpurse;

/**
 * a coin with a monetary value and currency. Default currency is Bath.
 * 
 * 
 * @author Totsapon menkul.
 */
public class Coin extends AbstractValuable {

	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

	public Coin(double value) {
		super(value);
	}

	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * get amount of money(value)
	 * 
	 * @return amount of money.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * get Currency of money.
	 * 
	 * @return Currency of money.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * return a String explanation of coin
	 * 
	 * @return String value and currency of coin.
	 */
	public String toString() {
		return this.value + " " + this.currency;
	}

}
