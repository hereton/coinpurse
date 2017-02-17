package coinpurse;

/**
 * a coin with a monetary value and currency. Default currency is Bath.
 * 
 * 
 * @author Totsapon menkul.
 */
public class Coin implements  Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 * @param currency
	 *            is currency of money.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
	 * check coins that have the same value and currency or not.
	 * 
	 * @param obj
	 *            is a coin to check.
	 * 
	 * @return True if other object has the same value and currency, False if
	 *         it's not.
	 * 
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coin other = (Coin) (obj);
		return this.value == other.value && this.currency.equals(other.currency);

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
