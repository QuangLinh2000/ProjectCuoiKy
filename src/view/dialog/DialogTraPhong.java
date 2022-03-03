package view.dialog;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class DialogTraPhong extends JPanel {
	public JTable table;
	public JLabel lbGioVao, lbGioTra, lbPhongNao, lbGia, lbTienPhong, lbTongtienDV, lbTongCong, lbTenKhachhang,lbTraTruoc;
	public DefaultTableModel defaultTableModel = new DefaultTableModel();
	public JRadioButton rdbtnNewRadioButton;
	int with = 100;

	/**
	 * Create the panel.
	 */
	public DialogTraPhong() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 500));

		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 400, 236);
		add(panel);
		panel.setLayout(null);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 0, 400, 25);
		panel.add(splitPane_1);

		JLabel lblNewLabel = new JLabel("Kh\u00E1ch H\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_1.setLeftComponent(lblNewLabel);

		lbTenKhachhang = new JLabel("");
		splitPane_1.setRightComponent(lbTenKhachhang);
		lblNewLabel.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(0, 40, 400, 25);
		panel.add(splitPane_2);

		JLabel lblVoLc = new JLabel("V\u00E0o L\u00FAc");
		lblVoLc.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_2.setLeftComponent(lblVoLc);

		lbGioVao = new JLabel("");
		splitPane_2.setRightComponent(lbGioVao);
		lblVoLc.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBounds(0, 80, 400, 25);
		panel.add(splitPane_3);

		JLabel lblLoiPhng = new JLabel("Tr\u1EA3 L\u00FAc");
		lblLoiPhng.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_3.setLeftComponent(lblLoiPhng);

		lbGioTra = new JLabel("");
		splitPane_3.setRightComponent(lbGioTra);
		lblLoiPhng.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 120, 400, 25);

		panel.add(splitPane_4);

		JLabel lbPhong = new JLabel("Phòng");
		lbPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_4.setLeftComponent(lbPhong);

		lbPhongNao = new JLabel("");
		splitPane_4.setRightComponent(lbPhongNao);
		lbPhong.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setBounds(0, 160, 400, 25);

		panel.add(splitPane_5);

		JLabel lblGi = new JLabel("Gi\u00E1");
		lblGi.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_5.setLeftComponent(lblGi);

		lbGia = new JLabel("");
		splitPane_5.setRightComponent(lbGia);
		lblGi.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 200, 400, 25);

		panel.add(splitPane);

		JLabel lblTinPhng = new JLabel("Tiền phòng");
		lblTinPhng.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane.setLeftComponent(lblTinPhng);

		lbTienPhong = new JLabel("");
		splitPane.setRightComponent(lbTienPhong);
		lblTinPhng.setPreferredSize(new Dimension(with, 25));
		
		JLabel traTuoc = new JLabel("Trả Trước");
		traTuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane.setLeftComponent(traTuoc);

		lbTraTruoc = new JLabel("");
		splitPane.setRightComponent(lbTraTruoc);
		traTuoc.setPreferredSize(new Dimension(with, 25));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 258, 400, 150);
		add(scrollPane);

		table = new JTable();
		defaultTableModel.addColumn("Tên dịch vụ");
		defaultTableModel.addColumn("Giá dịch vụ");
		defaultTableModel.addColumn("Số lượng");

		table.setModel(defaultTableModel);
		scrollPane.setViewportView(table);

		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setBounds(0, 416, 300, 25);
		add(splitPane_6);

		lbTongtienDV = new JLabel("");
		splitPane_6.setRightComponent(lbTongtienDV);

		JLabel lblNewLabel_1 = new JLabel("Ti\u1EC1n D\u1ECBch v\u1EE5");
		splitPane_6.setLeftComponent(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setPreferredSize(new Dimension(with, 25));

		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setBounds(0, 452, 300, 25);
		add(splitPane_7);

		JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng C\u1ED9ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane_7.setLeftComponent(lblNewLabel_2);

		lbTongCong = new JLabel("");
		splitPane_7.setRightComponent(lbTongCong);
		lblNewLabel_2.setPreferredSize(new Dimension(with, 25));

		rdbtnNewRadioButton = new JRadioButton("Print");
		rdbtnNewRadioButton.setBounds(10, 477, 109, 23);
		add(rdbtnNewRadioButton);

	}
}
