package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<>();
		for (Valuable value : money) {
			if (amount >= value.getValue()) {
				amount -= value.getValue();
				templist.add(value);
			}
		}
		return templist;
	}
}
