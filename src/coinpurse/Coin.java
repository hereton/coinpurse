package coinpurse;

// TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency. Value and Currency cannot be
 * changed.
 * 
 * 
 * @author Totsapon menkul.
 */
public class Coin implements Comparable<Coin> {
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

	// TODO Write an equals(Object) method.
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coin other = (Coin) (obj);
		return this.value == other.value;

	}

	// TODO Write a compareTo method and implement Comparable.

	public String toString() {
		return this.value + "-" + this.currency;
	}

	@Override
	public int compareTo(Coin other) {
		if (other == null)
			return -1;
		return (int) Math.signum(other.value - this.value);
	}

	// TODO Write good Javadoc comments on all methods.

}
// TODO remove the TODO comments after you complete them! Including this one!
