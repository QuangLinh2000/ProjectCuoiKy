package view.dialog;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class DialogThemNhanVien extends JPanel {

	public JTextField tfTaiKhoan;
	public JTextField tfTen;
	public JTextField tfMaNhanVien;
	public JTextField tfChucVu;
	public int withTexfie = 100;
	public JSpinner spinnerTienLuong;

	/**
	 * Create the panel.
	 */
	public DialogThemNhanVien() {
		setPreferredSize(new Dimension(430, 400));
		setLayout(new GridLayout(5, 1, 10, 10));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 380, 37);
		add(splitPane);

		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		splitPane.setLeftComponent(lblNewLabel);

		tfTaiKhoan = new JTextField();
		splitPane.setRightComponent(tfTaiKhoan);
		lblNewLabel.setPreferredSize(new Dimension(withTexfie, 25));
		tfTaiKhoan.setColumns(10);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 37, 380, 37);
		add(splitPane_1);

		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		splitPane_1.setLeftComponent(lblNewLabel_1);

		tfTen = new JTextField();
		splitPane_1.setRightComponent(tfTen);
		lblNewLabel_1.setPreferredSize(new Dimension(withTexfie, 25));
		tfTen.setColumns(10);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 148, 380, 37);
		add(splitPane_4);

		JLabel lblNewLabel_4 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		splitPane_4.setLeftComponent(lblNewLabel_4);

		tfMaNhanVien = new JTextField();
		splitPane_4.setRightComponent(tfMaNhanVien);
		tfMaNhanVien.setColumns(10);
		lblNewLabel_4.setPreferredSize(new Dimension(withTexfie, 25));

		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setBounds(0, 185, 380, 37);
		add(splitPane_5);

		JLabel lblNewLabel_5 = new JLabel("Ch\u1EE9c v\u1EE5");
		splitPane_5.setLeftComponent(lblNewLabel_5);

		tfChucVu = new JTextField();
		splitPane_5.setRightComponent(tfChucVu);
		tfChucVu.setColumns(10);
		lblNewLabel_5.setPreferredSize(new Dimension(withTexfie, 25));

		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setBounds(0, 259, 380, 37);
		add(splitPane_7);

		JLabel lblNewLabel_7 = new JLabel("L\u01B0\u01A1ng c\u01A1 b\u1EA3n");
		splitPane_7.setLeftComponent(lblNewLabel_7);
		lblNewLabel_7.setPreferredSize(new Dimension(withTexfie, 25));
		
		 spinnerTienLuong = new JSpinner();
		spinnerTienLuong.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		splitPane_7.setRightComponent(spinnerTienLuong);

	}
	

	

}
