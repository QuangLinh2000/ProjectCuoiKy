package view.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Head extends JPanel {


	public JButton btnThoat;

	public Head() {
		setBackground(new Color(30, 144, 255));
		setBounds(0, 0, 1366, 71);
		setLayout(null);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(49, 2, 85, 65);
		try {

			BufferedImage image = ImageIO.read(new File("img/headt.png"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 70, 1));
			lblNewLabel_3.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Hotel 5 sao");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Wide Latin", Font.BOLD, 24));
		lblNewLabel_4.setBounds(167, 11, 263, 37);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("công cụ quản lý khách sạn hiện đại nhất hiện nay");
		lblNewLabel_5.setForeground(new Color(255, 255, 0));
		lblNewLabel_5.setBounds(177, 46, 288, 14);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Xin chào: Quang linh");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(660, 8, 155, 46);

		add(lblNewLabel_6);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 255, 255));
		btnThoat.setBounds(832, 21, 68, 23);
		add(btnThoat);
		
		JLabel lbhinhanh5sao = new JLabel();
		lbhinhanh5sao.setBounds(487, 11, 148, 56);
		try {

			BufferedImage image = ImageIO.read(new File("img/hinhanh5Sao.jpg"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(150, 90, 1));
			lbhinhanh5sao.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(lbhinhanh5sao);

	}
}