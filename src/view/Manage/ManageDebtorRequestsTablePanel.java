package view.Manage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.DebtorRequest;
import view.DebtorTableListener;

public class ManageDebtorRequestsTablePanel extends JPanel {

	private JLabel topInvestorsLabel;
	private JTable table;
	private ManageDebtorRequestsTableModel tableModel;
	private JScrollPane tableSP;

	private DebtorTableListener listener;

	public ManageDebtorRequestsTablePanel() {

		topInvestorsLabel = new JLabel("Debtor Requests");

		tableModel = new ManageDebtorRequestsTableModel();

		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		tableSP = new JScrollPane(table);
		tableSP.setPreferredSize(new Dimension(250, 150));

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
					int row = table.rowAtPoint(e.getPoint());
					int id = tableModel.getData().get(row).getId();

					listener.sendDebtorId(id);
				} catch (IndexOutOfBoundsException ex) {

				}

			}
		});

		setDesign();
		layoutComponents();
	}

	public void clearSelection() {
		table.clearSelection();
	}

	public void setTableListener(DebtorTableListener listener) {
		this.listener = listener;
	}

	public void setTableData(List<DebtorRequest> db) {

		tableModel.setData(db);
	}

	public void refreshTable() {

		tableModel.fireTableDataChanged();
	}

	private void setDesign() {

		Color lightBlue = new Color(204, 247, 255);

		int size = 25;

		setBackground(lightBlue);

		topInvestorsLabel.setFont(new Font("montserrat", Font.PLAIN, size));
		topInvestorsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void layoutComponents() {

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;

		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.PAGE_START;

		// First Row
		gc.gridy = 0;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.insets = new Insets(30, 15, 30, 15);
		gc.anchor = GridBagConstraints.CENTER;

		add(topInvestorsLabel, gc);

		// Second Row
		gc.gridy++;
		gc.weighty = 1;
		gc.insets = new Insets(0, 25, 20, 25);
		add(tableSP, gc);

	}
}
