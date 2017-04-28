package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {

		// System.out.println(Arrays.toString(money.toArray()));
		// base case - did we succeed or fail?
		if (amount < 0)
			return null;
		if (amount > 0 && money.size() == 0)
			return null;
		if (money.size() == 0) {
			return null;
		}
		if (amount == 0) {
			List<Valuable> baseTemp = new ArrayList<>();
			return baseTemp;
		}
		// recursive step
		// case 1: what is happending here?
		List<Valuable> temp = withdraw(amount - money.get(0).getValue(), money.subList(1, money.size()));
		if (temp != null) {
			temp.add(money.get(0));
			return temp;
		}
		// case 2:
		return withdraw(amount, money.subList(1, money.size()));

	}
}
