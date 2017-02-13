package coinpurse;

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
		// TODO follow the steps in the sequence diagram
		// 1. create a Purse
		// Purse is the shared object.
		Purse purse = new Purse(10);
		
		
		
		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog ui = new ConsoleDialog(purse);
		
		// 3. run the ConsoleDialog
		ui.run();
	}
}
