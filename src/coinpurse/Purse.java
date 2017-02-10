package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO import ArrayList and Collections (so you can use Collections.sort())

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Totsapon Menkul.
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<>();

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (int i = 0; i < this.money.size(); i++) {
			balance = balance + this.money.get(i).getValue();
		}
		return balance;

	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	// TODO write accessor method for capacity. Use Java naming convention.
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		// TODO complete this method
		// TODO Don't Repeat Yourself: Avoid writing duplicate code.
		return (this.money.size() >= this.capacity);
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (coin.getValue() == 0)
			return false;
		if (!isFull()) {
			money.add(coin);
			Collections.sort(this.money);
			return true;
		}
		return false;
		// TODO complete the insert method
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		List<Coin> templist = new ArrayList<>();
		for (Coin coin : money) {
			if (amount >= coin.getValue()) {

				amount -= coin.getValue();
				templist.add(coin);
				
			}
		}
		if (amount == 0) {
			for (Coin coin : templist) {
				this.money.remove(coin);
			}
			Coin[] withdraw = new Coin[templist.size()];
			templist.toArray(withdraw);
			return withdraw;
		}
		return null;

	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		// TODO complete this
		return "there is " + this.count() + " coins with value " + this.getBalance();
	}

}
// TODO remove the TODO comments after you complete them.
// TODO When you are finished, there should not be any TODO. Including this one.
