package observer;

import javax.swing.AbstractListModel;

import coinpurse.Purse;
import coinpurse.Valuable;

public class PurseListModel extends AbstractListModel<Valuable> {
	private Purse purse;

	public PurseListModel(Purse purse) { this.purse = purse; }

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Valuable getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
