package view.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class LeftMenu extends JPanel implements ActionListener {
	private int withbtn = 170, heightbtn = 35, withbtnNho = 160;
	int iCacDonGia = 0, iThongKe = 0, iKhachHang = 0;
	public JSplitPane splitPaneSoDoKhachSan, splitPaneKhachSan, splitPaneCacDonGia, splitPaneDonGiaDichVu,
			splitPaneCachTinhTien, splitPaneThongKe, splitPaneDanhSachHoaDon, splitPaneDoanhThu, splitPaneBaoCao,
			splitPaneKhachHang, splitPaneKHDatPhong, splitPaneKHDeQuen, splitPaneNhanVien;

	public  JButton btnSodoKhachSan, btnKhachSan, btnCacDonGia, btnDonGiaDichVu, btnCachTinhTien, btnThongKe,
			btnDanhSachHoaDon, btnDoanhThu, btnBaoCao, btnKhachHang, btnKhachHangDatPhong, btnKhachHangQuenDo,
			btnNhanVien;

	public LeftMenu() {
		setBackground(new Color(30, 144, 255));
		setBounds(0, 81, 220, 556);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		

		splitPaneKhachSan = new JSplitPane();
		add(splitPaneKhachSan);

		JLabel lblNewLabel_1 = new JLabel();
		setIcon(lblNewLabel_1, "img/maphouse.png");
		splitPaneKhachSan.setLeftComponent(lblNewLabel_1);

		btnKhachSan = new JButton("Home");
		btnKhachSan.setBackground(new Color(248, 248, 255));
		btnKhachSan.setPreferredSize(new Dimension(withbtn, heightbtn));
		splitPaneKhachSan.setRightComponent(btnKhachSan);
		
		splitPaneSoDoKhachSan = new JSplitPane();
		add(splitPaneSoDoKhachSan);

		JLabel lblNewLabel = new JLabel();
		setIcon(lblNewLabel, "img/unnamed.png");
		splitPaneSoDoKhachSan.setLeftComponent(lblNewLabel);

		btnSodoKhachSan = new JButton("Sơ đồ khách sạn");
		btnSodoKhachSan.setBackground(new Color(248, 248, 255));
		btnSodoKhachSan.setPreferredSize(new Dimension(withbtn, heightbtn));
		splitPaneSoDoKhachSan.setRightComponent(btnSodoKhachSan);

		splitPaneCacDonGia = new JSplitPane();
		add(splitPaneCacDonGia);

		btnCacDonGia = new JButton("Danh Sách Dịch Vụ");
		btnCacDonGia.setBackground(new Color(248, 248, 255));
		btnCacDonGia.setPreferredSize(new Dimension(withbtn, heightbtn));
		splitPaneCacDonGia.setRightComponent(btnCacDonGia);

		JLabel lblNewLabel_2 = new JLabel();
		splitPaneCacDonGia.setLeftComponent(lblNewLabel_2);
		setIcon(lblNewLabel_2, "img/dongia.png");

		splitPaneDonGiaDichVu = new JSplitPane();
		add(splitPaneDonGiaDichVu);

		btnDonGiaDichVu = new JButton("Đơn giá dịch vụ");
		btnDonGiaDichVu.setBackground(Color.LIGHT_GRAY);
		splitPaneDonGiaDichVu.setRightComponent(btnDonGiaDichVu);
		btnDonGiaDichVu.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_1 = new JLabel();
		splitPaneDonGiaDichVu.setLeftComponent(lblNewLabel_1_1);
		setIcon(lblNewLabel_1_1, "img/hoadon.png");

		splitPaneCachTinhTien = new JSplitPane();
		add(splitPaneCachTinhTien);

		btnCachTinhTien = new JButton("Cách tính tiền");
		btnCachTinhTien.setBackground(Color.LIGHT_GRAY);
		splitPaneCachTinhTien.setRightComponent(btnCachTinhTien);
		btnCachTinhTien.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		splitPaneCachTinhTien.setVisible(false);
		splitPaneDonGiaDichVu.setVisible(false);

		JLabel lblNewLabel_1_2 = new JLabel();
		splitPaneCachTinhTien.setLeftComponent(lblNewLabel_1_2);
		setIcon(lblNewLabel_1_2, "img/tinhTien.png");

		splitPaneThongKe = new JSplitPane();
		add(splitPaneThongKe);

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(248, 248, 255));
		splitPaneThongKe.setRightComponent(btnThongKe);
		btnThongKe.setPreferredSize(new Dimension(withbtn, heightbtn));

		JLabel lblNewLabel_1_3 = new JLabel();
		splitPaneThongKe.setLeftComponent(lblNewLabel_1_3);
		setIcon(lblNewLabel_1_3, "img/thongke.png");

		splitPaneDanhSachHoaDon = new JSplitPane();
		add(splitPaneDanhSachHoaDon);

		btnDanhSachHoaDon = new JButton("Danh sách hóa đơn");
		btnDanhSachHoaDon.setBackground(Color.LIGHT_GRAY);
		splitPaneDanhSachHoaDon.setRightComponent(btnDanhSachHoaDon);
		btnDanhSachHoaDon.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_4 = new JLabel();
		splitPaneDanhSachHoaDon.setLeftComponent(lblNewLabel_1_4);
		setIcon(lblNewLabel_1_4, "img/dshoadon.png");

		splitPaneDoanhThu = new JSplitPane();
		add(splitPaneDoanhThu);

		btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setBackground(Color.LIGHT_GRAY);
		splitPaneDoanhThu.setRightComponent(btnDoanhThu);
		btnDoanhThu.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_5 = new JLabel();
		splitPaneDoanhThu.setLeftComponent(lblNewLabel_1_5);
		setIcon(lblNewLabel_1_5, "img/doanhthu.png");

		splitPaneBaoCao = new JSplitPane();
		add(splitPaneBaoCao);

		btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setBackground(Color.LIGHT_GRAY);
		splitPaneBaoCao.setRightComponent(btnBaoCao);
		btnBaoCao.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_6 = new JLabel();
		splitPaneBaoCao.setLeftComponent(lblNewLabel_1_6);
		setIcon(lblNewLabel_1_6, "img/baocao.png");

		splitPaneBaoCao.setVisible(false);
		splitPaneDoanhThu.setVisible(false);
		splitPaneDanhSachHoaDon.setVisible(false);

		splitPaneKhachHang = new JSplitPane();
		add(splitPaneKhachHang);

		btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setBackground(new Color(248, 248, 255));
		splitPaneKhachHang.setRightComponent(btnKhachHang);
		btnKhachHang.setPreferredSize(new Dimension(withbtn, heightbtn));

		JLabel lblNewLabel_1_7 = new JLabel();
		splitPaneKhachHang.setLeftComponent(lblNewLabel_1_7);
		setIcon(lblNewLabel_1_7, "img/khachhang.png");

		splitPaneKHDatPhong = new JSplitPane();
		add(splitPaneKHDatPhong);

		btnKhachHangDatPhong = new JButton("Khách hàng đặt phòng");
		btnKhachHangDatPhong.setBackground(Color.LIGHT_GRAY);
		splitPaneKHDatPhong.setRightComponent(btnKhachHangDatPhong);
		btnKhachHangDatPhong.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_8 = new JLabel();
		splitPaneKHDatPhong.setLeftComponent(lblNewLabel_1_8);
		setIcon(lblNewLabel_1_8, "img/datphong.png");

		splitPaneKHDeQuen = new JSplitPane();
		add(splitPaneKHDeQuen);

		btnKhachHangQuenDo = new JButton("Khách hàng quên đồ");
		btnKhachHangQuenDo.setBackground(Color.LIGHT_GRAY);
		splitPaneKHDeQuen.setRightComponent(btnKhachHangQuenDo);
		btnKhachHangQuenDo.setPreferredSize(new Dimension(withbtnNho, heightbtn));

		JLabel lblNewLabel_1_9 = new JLabel();
		splitPaneKHDeQuen.setLeftComponent(lblNewLabel_1_9);
		setIcon(lblNewLabel_1_9, "img/khachhang.png");

		splitPaneKHDeQuen.setVisible(false);
		splitPaneKHDatPhong.setVisible(false);

		splitPaneNhanVien = new JSplitPane();
		add(splitPaneNhanVien);

		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBackground(new Color(248, 248, 255));
		splitPaneNhanVien.setRightComponent(btnNhanVien);
		btnNhanVien.setPreferredSize(new Dimension(withbtn, heightbtn));

		JLabel lblNewLabel_1_10 = new JLabel();
		splitPaneNhanVien.setLeftComponent(lblNewLabel_1_10);
		setIcon(lblNewLabel_1_10, "img/nhanvien.png");
       
		btnCacDonGia.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnKhachHang.addActionListener(this);

	}

	public void setIcon(JLabel jLabel, String url) {
		try {

			BufferedImage image = ImageIO.read(new File(url));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(30, 30, 1));
			jLabel.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCacDonGia) {
			
				splitPaneCachTinhTien.setVisible(false);
				splitPaneDonGiaDichVu.setVisible(false);
//
//			} else {
//				splitPaneCachTinhTien.setVisible(true);
//				splitPaneDonGiaDichVu.setVisible(true);
//			}
//			revalidate();
//			iCacDonGia++;
				
		}
		if (e.getSource() == btnThongKe) {
			if (iThongKe % 2 != 0) {
				splitPaneBaoCao.setVisible(false);
				splitPaneDoanhThu.setVisible(false);
				splitPaneDanhSachHoaDon.setVisible(false);

			} else {
				splitPaneBaoCao.setVisible(true);
				splitPaneDoanhThu.setVisible(true);
				splitPaneDanhSachHoaDon.setVisible(true);
			}
			revalidate();
			iThongKe++;
		}
		if (e.getSource() == btnKhachHang) {

			if (iKhachHang % 2 != 0) {
				splitPaneKHDeQuen.setVisible(false);
				splitPaneKHDatPhong.setVisible(false);

			} else {
				splitPaneKHDeQuen.setVisible(true);
				splitPaneKHDatPhong.setVisible(true);
			}
			revalidate();
			iKhachHang++;
		}

	}

}

