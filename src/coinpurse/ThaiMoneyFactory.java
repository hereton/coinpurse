package coinpurse;

/**
 * 
 * create money of Thai currency.
 * 
 * @author Totsapon Menkul.
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/** set currency to Baht. */
	public static String currency = "Baht";
	/** add serial number by 1 when added BankNote. */
	public static long nextSerialNumber = 1000000;

	/**
	 * Create money of Thai currency.
	 * 
	 * @param value
	 *            is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException
	 *             if value is not valid.
	 */
	public Valuable createMoney(double value) {
		if (isValid(value)) {
			if (value <= 10) {
				return new Coin(value);
			}
			return new BankNote(value, currency, nextSerialNumber);
		}
		throw new IllegalArgumentException();
	}

	/**
	 * to check value that is valid in thai currency or not.
	 * 
	 * @param value
	 *            amount of money input.
	 * @return true if amount of money is valid. false if it's not.
	 */
	public boolean isValid(double value) {
		Double[] baht = { 0.25, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 500.0, 1000.0 };
		for (Double valid : baht) {
			if (valid.equals(value)) {
				return true;
			}
		}
		return false;
	}

}
