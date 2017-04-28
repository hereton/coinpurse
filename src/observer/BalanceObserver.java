package observer;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;

import coinpurse.Purse;

public class BalanceObserver extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField balanceField;

	public BalanceObserver() {
		this.setTitle("Balance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		run();
	}

	public void initComponents() {
		balanceField = new JTextField(8);
		balanceField.setFont(new Font("Courier", Font.BOLD, 50));
		this.add(balanceField);
		this.pack();
	}

	public void run() {
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			balanceField.setText(purse.getBalance() + "BAHT");
		}
	}
}
