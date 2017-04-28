package observer;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import coinpurse.Purse;

public class PurseStatusObserver extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea statusField;
	private JProgressBar progressBar;

	public PurseStatusObserver() {
		this.setTitle("PURSE STATUS");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		run();
	}

	public void initComponents() {
		statusField = new JTextArea("EMPTY");
		progressBar = new JProgressBar();
		statusField.setEditable(false);
		this.add(statusField, BorderLayout.NORTH);
		this.add(progressBar, BorderLayout.SOUTH);
		this.pack();

	}

	public void run() {
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		if (subject instanceof Purse) {
			Purse purse = (Purse) subject;
			progressBar.setMaximum(purse.getCapacity());

			if (purse.count() == 0) {
				statusField.setText("EMPTY");
				progressBar.setValue(purse.count());
			}
			if (purse.isFull()) {
				statusField.setText("FULL");
				progressBar.setValue(purse.count());
			} else {
				statusField.setText("" + purse.count());
				progressBar.setValue(purse.count());
			}
		}
	}
}
