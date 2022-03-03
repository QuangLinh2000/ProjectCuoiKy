package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DanhSachHoaDonActivity extends JPanel implements ActionListener{

	public JTable table;
	public DefaultTableModel model;

	public DanhSachHoaDonActivity() {
		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);
	
	
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 800, 361);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 844, 70);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Sách Hóa Đơn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 327, 48);
		panel.add(lblNewLabel);


		model = new DefaultTableModel();
		Object[] clum = {  "Phòng", "Tên Khách hàng","Ngày lập","Người Lập","Tổng Tiền" };
		for (Object object : clum) {
			model.addColumn(object);
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(185);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
