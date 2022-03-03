package view.dialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DialogThemDichVuMotPhong extends JPanel {
	public JTable table;
	public DefaultTableModel mode = new DefaultTableModel();
	public JButton btnThem;
	public JLabel lbTenPhong;
	public JPanel panel;
	public JScrollPane scrollPane_1;

	public DialogThemDichVuMotPhong() {
		setLayout(null);
		setPreferredSize(new Dimension(500, 500));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 11, 480, 25);
		add(splitPane);

		JLabel lblNewLabel = new JLabel("D\u1ECBch V\u1EE5 Ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		splitPane.setLeftComponent(lblNewLabel);

		lbTenPhong = new JLabel("Quang Linh");
		splitPane.setRightComponent(lbTenPhong);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 480, 154);
		add(scrollPane);

		table = new JTable();

		mode.addColumn("Tên dịch vụ");
		mode.addColumn("Giá");
		mode.addColumn("Số lượng");

		table.setModel(mode);
		scrollPane.setViewportView(table);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(37, 423, 89, 23);
		add(btnThem);
		
		 scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 238, 480, 175);
		add(scrollPane_1);
		
		 panel = new JPanel();
		
		scrollPane_1.setViewportView(panel);
		
		

	}
}
