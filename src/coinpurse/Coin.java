package coinpurse;

/**
 * a coin with a monetary value and currency. Default currency is Bath.
 * 
 * 
 * @author Totsapon menkul.
 */
public class Coin extends AbstractValuable {

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is the value of the coin
	 */
	public Coin(double value) {
		super(value);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin
	 * @param currency
	 *            is the currency of coin
	 */
	public Coin(double value, String currency) {
		super(value, currency);

	}

	/**
	 * get amount of money(value)
	 * 
	 * @return amount of money.
	 */
	public double getValue() {
		return super.value;
	}

	/**
	 * get Currency of money.
	 * 
	 * @return Currency of money.
	 */
	public String getCurrency() {
		return super.currency;
	}

	/**
	 * return a String explanation of coin
	 * 
	 * @return String value and currency of coin.
	 */
	public String toString() {
		String cur = super.getCurrency();
		if ("Ringgit".equalsIgnoreCase(cur)) {
			if (super.getValue() <= 0.5) {
				cur = "Sen";
				return super.value * 100 + " " + cur;
			}
		}
		if ("Baht".equals(cur)) {
			if (super.getValue() <= 0.5) {
				cur = "Satang";
				return super.value * 100 + " " + cur;
			}
		}
		return super.value + " " + cur;
	}
}
