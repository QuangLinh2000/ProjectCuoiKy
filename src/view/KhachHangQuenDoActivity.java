package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KhachHangQuenDoActivity extends JPanel {

	public JTable table;
	public DefaultTableModel model;
	public JButton btnThem;
	public JPopupMenu popupMenu;
	public JMenuItem mnTraDo;

	public KhachHangQuenDoActivity() {

		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 100, 800, 411);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 844, 70);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Sách Đồ Để Quên");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 327, 48);
		panel.add(lblNewLabel);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(664, 28, 89, 23);
		panel.add(btnThem);

		model = new DefaultTableModel();
		Object[] clum = { "Khách hàng", "Để quên", "Phòng", "Ghi chú", "Tạo bởi", "Ngày tao" };
		for (Object object : clum) {
			model.addColumn(object);
		}
		table.setModel(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(167);
		table.getColumnModel().getColumn(5).setPreferredWidth(170);

		popupMenu = new JPopupMenu();

		mnTraDo = new JMenuItem("Trả đồ");
		addIconMenuItem(mnTraDo, "img/thuephong.jpg");
		popupMenu.add(mnTraDo);

	}

	public void addIconMenuItem(JMenuItem jMenuItem, String url) {
		try {

			BufferedImage image = ImageIO.read(new File(url));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(18, 18, 1));
			jMenuItem.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
