package view;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSoDoKhachSan extends JPanel {
	public JLabel lbphongcontrong, lbdadat, lbdango, lbCanChiSua, lbThongBaoTaoKhachSan;
	public JPanel panelHienThiPhong, jPanelChuaTaoKhachSan;
	public JPopupMenu popupMenu;
	public JButton btnTaoKhachSan;
	public JMenuItem mnChinhSu, mnThuePhong, mnthemdatphong, mnTraPhong, mnxoaphong,mnDatPhong;
	public JScrollPane scrollPane;

	public PanelSoDoKhachSan() {
		createView();
	}

	public void createView() {
		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);

		lbphongcontrong = new JLabel("Còn trống");
		lbphongcontrong.setBackground(new Color(124, 252, 0));
		lbphongcontrong.setBounds(109, 20, 100, 14);
		add(lbphongcontrong);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setBounds(79, 20, 15, 14);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setBounds(202, 20, 15, 14);
		add(btnNewButton_1);

		lbdadat = new JLabel("Đã đặt");
		lbdadat.setBounds(237, 20, 72, 14);
		add(lbdadat);

		JButton btndango = new JButton("");
		btndango.setBackground(new Color(255, 0, 0));
		btndango.setBounds(319, 20, 15, 14);
		add(btndango);

		lbdango = new JLabel("Đang ở");
		lbdango.setBounds(357, 20, 76, 14);
		add(lbdango);

		lbCanChiSua = new JLabel("Cần sửa chửa");
		lbCanChiSua.setBounds(468, 20, 104, 14);
		add(lbCanChiSua);

		JButton btncanchinhsua = new JButton("");
		
		btncanchinhsua.setBackground(new Color(139, 0, 0));
		btncanchinhsua.setBounds(443, 20, 15, 14);
		add(btncanchinhsua);

		 scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 67, 770, 395);
		add(scrollPane);

		panelHienThiPhong = new JPanel();

		jPanelChuaTaoKhachSan = new JPanel(null);
		jPanelChuaTaoKhachSan.setBounds(22, 67, 770, 395);
		add(jPanelChuaTaoKhachSan);
		
		lbThongBaoTaoKhachSan = new JLabel("Chưa tạo khách sạn");
		lbThongBaoTaoKhachSan.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbThongBaoTaoKhachSan.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongBaoTaoKhachSan.setBounds(0, 55, 770, 135);
		jPanelChuaTaoKhachSan.add(lbThongBaoTaoKhachSan);

		btnTaoKhachSan = new JButton("Tạo khách sạn");
		btnTaoKhachSan.setBounds(325, 232, 153, 36);
		jPanelChuaTaoKhachSan.add(btnTaoKhachSan);

		popupMenu = new JPopupMenu();

		mnThuePhong = new JMenuItem("Thuê phòng");
		addIconMenuItem(mnThuePhong, "img/thuephong.jpg");
		popupMenu.add(mnThuePhong);
		
		mnDatPhong = new JMenuItem("Đặt phòng");
		addIconMenuItem(mnDatPhong, "img/thuephong.jpg");
		popupMenu.add(mnDatPhong);

		mnthemdatphong = new JMenuItem("Thêm dịch vụ");
		addIconMenuItem(mnthemdatphong, "img/khachhang.png");
		popupMenu.add(mnthemdatphong);

		mnTraPhong = new JMenuItem("Trả Phòng");
		addIconMenuItem(mnTraPhong, "img/Updateicon.png");
		popupMenu.add(mnTraPhong);

		mnChinhSu = new JMenuItem("Chỉnh sửa");
		addIconMenuItem(mnChinhSu, "img/chinhsua.png");
		popupMenu.add(mnChinhSu);

		mnxoaphong = new JMenuItem("Xóa phòng này");
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
