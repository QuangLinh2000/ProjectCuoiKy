package view.dialog;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class DialogThemDichVu extends JPanel {
	public JTextField textFieldTenDichVu;
	public JTextField textFieldThongTinDichVu;
	public JSpinner spinnerGia;

	public DialogThemDichVu() {
		setLayout(new GridLayout(4, 1, 10, 10));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane);

		JLabel lblNewLabel = new JLabel("T\u00EAn D\u1ECBch V\u1EE5");
		splitPane.setLeftComponent(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(100, 25));

		textFieldTenDichVu = new JTextField();
		splitPane.setRightComponent(textFieldTenDichVu);
		textFieldTenDichVu.setColumns(10);

		JSplitPane splitPane_2 = new JSplitPane();
		add(splitPane_2);

		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1");
		splitPane_2.setLeftComponent(lblNewLabel_1);
		lblNewLabel_1.setPreferredSize(new Dimension(100, 25));

		spinnerGia = new JSpinner();
		spinnerGia.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		splitPane_2.setRightComponent(spinnerGia);

		JSplitPane splitPane_1 = new JSplitPane();
		add(splitPane_1);

		JLabel lblNewLabel_2 = new JLabel("Th\u00F4ng Tin d\u1ECBch v\u1EE5");
		splitPane_1.setLeftComponent(lblNewLabel_2);
		lblNewLabel_2.setPreferredSize(new Dimension(100, 25));

		textFieldThongTinDichVu = new JTextField();
		splitPane_1.setRightComponent(textFieldThongTinDichVu);
		textFieldThongTinDichVu.setColumns(10);
		setPreferredSize(new Dimension(300, 150));

	}

}
