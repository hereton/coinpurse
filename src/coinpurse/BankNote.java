package coinpurse;

/**
 * a bank with a monetary value, serial number and currency. Default currency is
 * Bath.
 * 
 * @author Totsapon Menkul
 *
 */
public class BankNote implements Valuable {
	public static final String DEFAULT_CRRENCY = "Baht";
	/** add serial number by 1 when added BankNote. */
	public static long nextSerialNumber = 1000000;
	/** value of BankNote */
	private final double value;
	/** currency of BankNote */
	private final String currency;
	/** serial number of BankNote */
	private final long serialNumber;

	/**
	 * A BankNote with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CRRENCY;
		this.serialNumber = nextSerialNumber;
		BankNote.nextSerialNumber += 1;
	}

	/**
	 * /** A BankNote with given value ,serial number and currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 * @param currency
	 *            is currency of money.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		BankNote.nextSerialNumber += 1;
	}

	/**
	 * get amount of money(value)
	 * 
	 * @return amount of money.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * get Currency of money.
	 * 
	 * @return Currency of money.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * get serial number of bank note.
	 * 
	 * @return serial number of bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
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
		BankNote other = (BankNote) obj;
		return this.value == other.value && this.currency.equals(other.currency);
	}

	/**
	 * return a String explanation of coin
	 * 
	 * @return String value and currency of coin.
	 */
	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}

}
