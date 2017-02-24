package coinpurse;

/**
 * 
 * @author SFXW10
 *
 */
public abstract class AbstractValuable implements Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	double value;
	String currency;

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

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Valuable other = (Valuable) (obj);
		return this.getValue() == other.getValue() && this.getCurrency().equalsIgnoreCase(other.getCurrency());

	}

	public int compareTo(Valuable o) {
		if(this.getCurrency().equalsIgnoreCase(o.getCurrency())){
			return (int) Math.signum(this.getValue() - o.getValue());
		}
		return this.getCurrency().compareTo(o.getCurrency());
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}

}
