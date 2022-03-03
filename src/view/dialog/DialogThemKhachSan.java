package view.dialog;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DialogThemKhachSan extends JPanel {
	public JTextField textFieldName;
	public JTextField textFieldDiaChi;
	public JTextField textFieldPhone;
	public JTextField textFieldEmail;
	public JTextArea textAreaGhiChu;
	public JSpinner  spinnerSoTang,spinnerSoPhong ;

	/**
	 * Create the panel.
	 */
	

	public DialogThemKhachSan() {
		setLayout(null);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 300, 30);
		add(splitPane);

		JLabel lbTenKS = new JLabel("*T\u00EAn kh\u00E1ch s\u1EA1n");
		lbTenKS.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane.setLeftComponent(lbTenKS);
		lbTenKS.setPreferredSize(new Dimension(80, 30));

		textFieldName = new JTextField();
		splitPane.setRightComponent(textFieldName);
		textFieldName.setColumns(10);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 40, 300, 30);
		add(splitPane_1);

		JLabel lblSTng = new JLabel("*S\u1ED1 T\u1EA7ng  ");
		lblSTng.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_1.setLeftComponent(lblSTng);
		lblSTng.setPreferredSize(new Dimension(80, 30));
		
		 spinnerSoTang = new JSpinner();
		spinnerSoTang.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		splitPane_1.setRightComponent(spinnerSoTang);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(0, 80, 300, 30);
		add(splitPane_2);

		JLabel lblSPhng = new JLabel("*S\u1ED1 ph\u00F2ng  ");
		lblSPhng.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_2.setLeftComponent(lblSPhng);
		lblSPhng.setPreferredSize(new Dimension(80, 30));
		
		spinnerSoPhong = new JSpinner();
		spinnerSoPhong.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		splitPane_2.setRightComponent(spinnerSoPhong);

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBounds(0, 120, 300, 30);
		add(splitPane_3);

		JLabel lblDaCh = new JLabel("\u0110\u1ECBa ch\u1EC9  ");
		lblDaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_3.setLeftComponent(lblDaCh);
		lblDaCh.setPreferredSize(new Dimension(80, 30));

		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setColumns(10);
		splitPane_3.setRightComponent(textFieldDiaChi);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 160, 300, 30);
		add(splitPane_4);

		JLabel lblPhone = new JLabel("Phone  ");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_4.setLeftComponent(lblPhone);
		lblPhone.setPreferredSize(new Dimension(80, 30));

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		splitPane_4.setRightComponent(textFieldPhone);

		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setBounds(0, 200, 300, 30);
		add(splitPane_5);

		JLabel lblEmail = new JLabel("Email  ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_5.setLeftComponent(lblEmail);
		lblEmail.setPreferredSize(new Dimension(80, 30));

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		splitPane_5.setRightComponent(textFieldEmail);

		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setBounds(0, 240, 300, 76);
		add(splitPane_6);

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setHorizontalAlignment(SwingConstants.RIGHT);
		splitPane_6.setLeftComponent(lblGhiCh);
		lblGhiCh.setPreferredSize(new Dimension(80, 30));

		textAreaGhiChu = new JTextArea();
		splitPane_6.setRightComponent(textAreaGhiChu);

		setPreferredSize(new Dimension(300, 320));

	}
}
