package coinpurse;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author your name
 */
public class Main {

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// TODO follow the steps in the sequence diagram
		// 1. create a Purse
		Purse purse = new Purse(3);
		purse.getBalance();
		Coin c1 = new Coin(10);
		Coin c2 = new Coin(10);
		purse.insert(c1);
		
		// 2. create a ConsoleDialog with a reference to the Purse object

		// 3. run the ConsoleDialog

	}
}
