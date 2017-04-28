package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.*;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Totsapon Menkul.
 */
public class Purse extends Observable {

	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<>();

	/** Create Strategy Withdraw */
	private WithdrawStrategy strategy;

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	/**
	 * sort by the greatest values to smallest.
	 */
	public Comparator<Valuable> compareMostValue = new Comparator<Valuable>() {
		@Override
		public int compare(Valuable o1, Valuable o2) {
			return (int) Math.signum(o2.getValue() - o1.getValue());
		}
	};

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.strategy = new RecursiveWithdraw();
	}

	/**
	 * Set strategy for withdraw method.
	 * 
	 * @param newStrategy
	 *            now there are GreedyWithdarw and RecusiveWothdraw for
	 *            strategy.
	 */
	public void setStrategy(WithdrawStrategy newStrategy) {
		this.strategy = newStrategy;
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
		for (Valuable value : money) {
			balance = balance + value.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
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
	public boolean insert(Valuable value) {
		if (value.getValue() == 0)
			return false;
		if (!isFull()) {
			money.add(value);
			Collections.sort(this.money, compareMostValue);
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
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
	public Valuable[] withdraw(double amount) {
		Collections.reverse(money);
		Valuable[] withdraw;
		List<Valuable> templist = this.strategy.withdraw(amount, this.money);
		if (templist != null) {
			withdraw = new Valuable[templist.size()];
			for (Valuable value : templist) {
				money.remove(value);
			}
			templist.toArray(withdraw);
			setChanged();
			notifyObservers();
			return withdraw;
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return "there is " + this.count() + " with value " + this.getBalance();
	}
}
