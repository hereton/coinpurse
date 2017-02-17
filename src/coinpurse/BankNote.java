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
	public static long nextSerialNumber = 1000000;
	private final double value;
	private final String currency;
	private final long serialNumber;

	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CRRENCY;
		this.serialNumber = nextSerialNumber;
		BankNote.nextSerialNumber += 1;
	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		BankNote.nextSerialNumber += 1;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	public long getSerial() {
		return this.serialNumber;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		BankNote other = (BankNote) obj;
		return this.value == other.value && this.currency.equals(other.currency);
	}

	public String toString() {
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
	
}
