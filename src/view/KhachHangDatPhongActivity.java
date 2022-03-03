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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KhachHangDatPhongActivity extends JPanel {

	public JTable table;
	public DefaultTableModel model;
	public JPopupMenu popupMenu;
	public JMenuItem mnChinhSu, mnThuePhong, mnxoaphong;

	public KhachHangDatPhongActivity() {

		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 109, 800, 402);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 844, 70);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Sách Đặt Phòng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 327, 48);
		panel.add(lblNewLabel);

		model = new DefaultTableModel();
		Object[] clum = { "Khách hàng", "Đặt Ngày", "Phòng", "Số Ngày", "Trả Trước", "Tạo bởi", "Tạo Ngày" };
		for (Object object : clum) {
			model.addColumn(object);
		}
		table.setModel(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(140);
		table.getColumnModel().getColumn(5).setPreferredWidth(117);
		table.getColumnModel().getColumn(6).setPreferredWidth(170);

		popupMenu = new JPopupMenu();

		mnThuePhong = new JMenuItem("Đến ở");
		addIconMenuItem(mnThuePhong, "img/thuephong.jpg");
		popupMenu.add(mnThuePhong);

//		mnChinhSu = new JMenuItem("Chỉnh sửa");
//		addIconMenuItem(mnChinhSu, "img/chinhsua.png");
//		popupMenu.add(mnChinhSu);

		mnxoaphong = new JMenuItem("Hủy đặt");
		addIconMenuItem(mnxoaphong, "img/xoa.png");
		popupMenu.add(mnxoaphong);

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
