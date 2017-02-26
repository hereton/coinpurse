package coinpurse;

/**
 * Parent class for Coin and Banknote.
 * 
 * @author Totsapon Menkul.
 *
 */
public abstract class AbstractValuable implements Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	protected double value;
	protected String currency;

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 * @param currency
	 *            is currency of money.
	 */
	public AbstractValuable(double value) {
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
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Compare two Valuable with value. Order items by currency so items with
	 * same currency are grouped together, and if currency is the same then
	 * order by value.
	 *
	 * @param other
	 *            is the Valuable object that you want to compare with
	 * @return if currency is the same, compare by value. if currency is not
	 *         same, compare by currency.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Valuable other = (Valuable) (obj);
		return this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency());

	}

	/**
	 * check two Valuable are equal or not ,it will be equal if they have the
	 * same value and currency.
	 * 
	 * @param obj
	 *            is the object that you want to compare.
	 * @return true if they have the same value and currency, false if they are
	 *         not same
	 */
	public int compareTo(Valuable o) {
		if (this.getCurrency().equalsIgnoreCase(o.getCurrency())) {
			return (int) Math.signum(this.getValue() - o.getValue());
		}
		return this.getCurrency().compareTo(o.getCurrency());
	}

	/**
	 * Get the value of money.
	 * 
	 * @return value of money.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the money.
	 * 
	 * @return the currency of the money.
	 */
	public String getCurrency() {
		return this.currency;
	}

}
