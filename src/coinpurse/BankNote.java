package coinpurse;

/**
 * a bank with a monetary value, serial number and currency. Default currency is
 * Bath.
 * 
 * @author Totsapon Menkul
 *
 */
public class BankNote extends AbstractValuable {

	/** serial number of the BankNote. */
	public long serialNumber;

	/**
	 * A BankNote with given value using the default currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 */
	public BankNote(double value) {
		super(value, DEFAULT_CURRENCY);
		setSerialNumber(MoneyFactory.nextSerialNumber);
		MoneyFactory.nextSerialNumber += 1;
	}

	/**
	 * /** A BankNote with given value ,serial number and currency.
	 * 
	 * @param value
	 *            is amount of input money.
	 * @param currency
	 *            is currency of money.
	 */
	public BankNote(double value, String currency, Long serialNumber) {
		super(value, currency);
		setSerialNumber(MoneyFactory.nextSerialNumber);
		MoneyFactory.nextSerialNumber += 1;
	}

	public BankNote(double value, String currency) {
		super(value, currency);
		setSerialNumber(MoneyFactory.nextSerialNumber);
		MoneyFactory.nextSerialNumber += 1;

	}

	/**
	 * get amount of money(value)
	 * 
	 * @return amount of money.
	 */
	@Override
	public double getValue() {
		return super.value;
	}

	/**
	 * get Currency of money.
	 * 
	 * @return Currency of money.
	 */
	@Override
	public String getCurrency() {
		return super.currency;
	}

	/**
	 * get serial number of bank note.
	 * 
	 * @return serial number of bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * return a String explanation of coin
	 * 
	 * @return String value and currency of coin.
	 */
	public String toString() {
		return super.value + "-" + super.currency + " note [" + this.serialNumber + "]";
	}

}
