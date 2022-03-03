package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DanhSachDichVuActivity extends JPanel {
	public JTable table;
	public DefaultTableModel model;
	public JButton btnThemDichVu;

    public DanhSachDichVuActivity() {
		createView();
	}
	
	public void createView() {
		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 800, 402);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 844, 70);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh S\u00E1ch D\u1ECBch V\u1EE5 Kh\u00E1ch S\u1EA1n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 327, 48);
		panel.add(lblNewLabel);

		

		btnThemDichVu = new JButton("Thêm");
		btnThemDichVu.setBounds(745, 17, 89, 31);
		panel.add(btnThemDichVu);

		model = new DefaultTableModel();
		Object[] clum = { "Tên Dịch Vụ", "Giá", "Thông Tin Dịch Vụ" };
		for (Object object : clum) {
			model.addColumn(object);
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(280);
		table.getColumnModel().getColumn(1).setPreferredWidth(260);
		table.getColumnModel().getColumn(2).setPreferredWidth(257);
		
	}
	

	
}
