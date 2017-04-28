package coinpurse;

import observer.BalanceObserver;
import observer.PurseStatusObserver;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author your name
 */
public class Main {
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		MoneyFactory.setMoneyFactory(new ThaiMoneyFactory());
		Purse purse = new Purse(CAPACITY);
		BalanceObserver bo = new BalanceObserver();
		PurseStatusObserver po = new PurseStatusObserver();
		purse.addObserver(po);
		purse.addObserver(bo);
		ConsoleDialog ui = new ConsoleDialog(purse, "thailand");
		ui.run();

	}
}
