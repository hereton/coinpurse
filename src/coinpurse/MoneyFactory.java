package coinpurse;

/**
 * 
 * @author SFXW10
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory factory;
	public static long nextSerialNumber = 1000000;

	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = new ThaiMoneyFactory();
		}
		return factory;
	}

	/**
	 * Create a new money object in the local currency.
	 * 
	 * @param value
	 *            is the value that you want to create.
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Accepts money value as a String and create a new money object in the
	 * local currency.
	 * 
	 * @param value
	 *            is the value that you want to create.
	 * @return the Valuable of object.
	 */
	public Valuable createMoney(String value) {
		double money = Double.parseDouble(value);
		return factory.createMoney(money);

	}

	/**
	 * Set the local factory.
	 * 
	 * @param factory
	 *            is the subclass of MoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.factory = factory;
	}

}
