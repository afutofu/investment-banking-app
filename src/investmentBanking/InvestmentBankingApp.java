package investmentBanking;

import javax.swing.SwingUtilities;

import controller.Controller;

public class InvestmentBankingApp {

	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new Controller();

			}

		});
	}
}
