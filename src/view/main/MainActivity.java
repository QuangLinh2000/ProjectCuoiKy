package view.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.danhsachdichvu.ControllerDanhSachDichVu;
import controller.danhsachhoadon.ControllerDanhSachHoaDon;
import controller.doanhthu.ControllerDoanhThu;
import controller.khachhangdatphong.ControllerKhachHangDatPhong;
import controller.khachhangdatphong.Data;
import controller.khachhangdatphong.Suject;
import controller.khachhangquendo.ControllerKhachHangQuenDo;
import controller.sodokhachsan.ControllerSoDoKhachSan;
import controller.sodokhachsan.SubjectKhachHangDatPhong;
import controller.themnhanvien.ControllerNhanVien;
import controller.xuatbaocao.ControllerXuatBaoCao;
import model.DichVu;
import model.ICapNhatKhachSan;
import model.KhachSan;
import view.BaoCaoActivity;
import view.DanhSachDichVuActivity;
import view.DanhSachHoaDonActivity;
import view.DoanhThuActivity;
import view.HomeActivity;
import view.KhachHangDatPhongActivity;
import view.KhachHangQuenDoActivity;
import view.NhanVienActivity;
import view.PanelSoDoKhachSan;

public class MainActivity extends JFrame implements ActionListener {
	private JPanel contentPane;
	private LeftMenu leftMenu;
	private BaoCaoActivity baoCaoActivity;
	private DanhSachHoaDonActivity danhSachHoaDonActivity;
	private DoanhThuActivity doanhThuActivity;
	private DanhSachDichVuActivity donGiaDichVuActivity;
	private KhachHangDatPhongActivity khachHangDatPhongActivity;
	private KhachHangQuenDoActivity khachHangQuenDoActivity;
	private NhanVienActivity nhanVienActivity;
	private HomeActivity homeActivity;
	private PanelSoDoKhachSan soDoKhachSan;
	private Head head;
	private int i = 0;
	KhachSan khachSan = new KhachSan(null, 0, 0, null, null, null, null);
	// ControllerSoDoKhachSan controllerSoDoKhachSan;
	ControllerDanhSachDichVu controllerDanhSachDichVu;
	Suject suject = new Data();

	List<model.DichVu> listDv = new ArrayList<DichVu>();

	public MainActivity() {
		DichVu dv = new DichVu("nước lọc", 200000, 0, "quang linh");
		DichVu dv2 = new DichVu("nước ngot", 600000, 0, "quang linh");
		DichVu dv3 = new DichVu("nước mía", 300000, 0, "quang linh");
		DichVu dv4 = new DichVu("nước suối", 200000, 0, "Thuy Ngan");
		DichVu dv5 = new DichVu("bimbim", 200000, 0, "Thuy Ngan");
		DichVu dv6 = new DichVu("rượu", 200000, 0, "quang linh");
		DichVu dv7 = new DichVu("Sting", 200000, 0, "quang linh");
		DichVu dv8 = new DichVu("sườn", 30000, 0, "Thuy Ngan");
		DichVu dv9 = new DichVu("rượu", 200000, 0, "quang linh");
		DichVu dv10 = new DichVu("bún", 200000, 0, "quang linh");
		DichVu dv11 = new DichVu("thịt cừu nướng", 900000, 0, "quang linh");
		DichVu dv12 = new DichVu("thịt dê nướng", 500000, 0, "quang linh");
		DichVu dv13 = new DichVu("mì trứng", 200000, 0, "quang linh");
		DichVu dv14 = new DichVu("tôm luộc", 1300000, 0, "quang linh");
		DichVu dv15 = new DichVu("trứng chiên", 14100000, 0, "quang linh");
		DichVu dv16 = new DichVu("rượu votka", 2140000, 0, "quang linh");
		DichVu dv17 = new DichVu("bia tige", 4120000, 0, "quang linh");
		DichVu dv18 = new DichVu("bia sài gòn", 1400000, 0, "quang linh");
		DichVu dv19 = new DichVu("bia hà nội", 14300000, 0, "quang linh");
		DichVu dv20 = new DichVu("bia heniken", 2400000, 0, "quang linh");
		DichVu dv21 = new DichVu("tôm hùm", 5300000, 0, "quang linh");
		DichVu dv22 = new DichVu("bò khô be", 130000, 0, "quang linh");
		DichVu dv23 = new DichVu("thịt luộc", 31400000, 0, "quang linh");
		DichVu dv24 = new DichVu("trứng chiên", 230000, 0, "quang linh");

		listDv.add(dv);
		listDv.add(dv2);
		listDv.add(dv3);
		listDv.add(dv4);
		listDv.add(dv5);
		listDv.add(dv6);
		listDv.add(dv7);
		listDv.add(dv8);
		listDv.add(dv9);
		listDv.add(dv10);
		listDv.add(dv11);
		listDv.add(dv12);
		listDv.add(dv13);
		listDv.add(dv14);
		listDv.add(dv15);
		listDv.add(dv16);
		listDv.add(dv17);
		listDv.add(dv18);
		listDv.add(dv19);
		listDv.add(dv20);
		listDv.add(dv21);
		listDv.add(dv22);
		listDv.add(dv23);
		listDv.add(dv24);

		khachSan.setListService(listDv);
		khoiTao();
		addLayout();
		suKien();

	}

	private void suKien() {
		leftMenu.btnSodoKhachSan.addActionListener(this);
		leftMenu.btnKhachSan.addActionListener(this);
		leftMenu.btnDonGiaDichVu.addActionListener(this);
		leftMenu.btnCachTinhTien.addActionListener(this);
		leftMenu.btnDanhSachHoaDon.addActionListener(this);
		leftMenu.btnDoanhThu.addActionListener(this);
		leftMenu.btnBaoCao.addActionListener(this);
		leftMenu.btnKhachHangDatPhong.addActionListener(this);
		leftMenu.btnKhachHangQuenDo.addActionListener(this);
		leftMenu.btnNhanVien.addActionListener(this);
		head.btnThoat.addActionListener(this);
		leftMenu.btnCacDonGia.addActionListener(this);

	}

	private void addLayout() {
		contentPane.add(leftMenu);
		contentPane.add(head);
		contentPane.add(homeActivity);
		contentPane.add(baoCaoActivity);
		contentPane.add(danhSachHoaDonActivity);
		contentPane.add(doanhThuActivity);
		contentPane.add(khachHangDatPhongActivity);
		contentPane.add(khachHangQuenDoActivity);
		contentPane.add(nhanVienActivity);
		contentPane.add(donGiaDichVuActivity);
		contentPane.add(soDoKhachSan);

		homeActivity.setVisible(true);
		baoCaoActivity.setVisible(false);
		danhSachHoaDonActivity.setVisible(false);
		doanhThuActivity.setVisible(false);
		khachHangDatPhongActivity.setVisible(false);
		khachHangQuenDoActivity.setVisible(false);
		nhanVienActivity.setVisible(false);
		donGiaDichVuActivity.setVisible(false);
		soDoKhachSan.setVisible(false);

	}

	private void khoiTao() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		SubjectKhachHangDatPhong controllerSoDoKhachSan = new ControllerSoDoKhachSan(khachSan, suject);
		controllerDanhSachDichVu = new ControllerDanhSachDichVu(khachSan);
		ControllerKhachHangDatPhong controllerKhachHangDatPhong = new ControllerKhachHangDatPhong(khachSan,
				controllerSoDoKhachSan, suject);

		ControllerDanhSachHoaDon controllerDanhSachHoaDon = new ControllerDanhSachHoaDon(khachSan,
				controllerSoDoKhachSan);
		ControllerDoanhThu controllerDoanhThu = new ControllerDoanhThu(khachSan, controllerSoDoKhachSan);
		ControllerXuatBaoCao controllerXuatBaoCao = new ControllerXuatBaoCao(khachSan);
		ControllerKhachHangQuenDo controllerKhachHangQuenDo = new ControllerKhachHangQuenDo(khachSan);
		ControllerNhanVien controllerNhanVien = new ControllerNhanVien(khachSan);

		leftMenu = new LeftMenu();
		head = new Head();
		homeActivity = new HomeActivity();
		baoCaoActivity = controllerXuatBaoCao.getView();
		danhSachHoaDonActivity = controllerDanhSachHoaDon.getView();
		doanhThuActivity = controllerDoanhThu.getView();
		khachHangDatPhongActivity = controllerKhachHangDatPhong.getView();
		khachHangQuenDoActivity = controllerKhachHangQuenDo.getView();
		nhanVienActivity = controllerNhanVien.getView();
		donGiaDichVuActivity = controllerDanhSachDichVu.getView();
		soDoKhachSan = controllerSoDoKhachSan.getSoDoKhachSan();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftMenu.btnSodoKhachSan) {
			soDoKhachSan.setVisible(true);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();
		}
		if (e.getSource() == leftMenu.btnKhachSan) {
			homeActivity.setVisible(true);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			soDoKhachSan.setVisible(false);
			homeActivity.time.start();
		}
		if (e.getSource() == leftMenu.btnCacDonGia) {
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(true);
			soDoKhachSan.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnCachTinhTien) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnDanhSachHoaDon) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(true);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnDoanhThu) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(true);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnBaoCao) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(true);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnKhachHangDatPhong) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(true);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnKhachHangQuenDo) {
			soDoKhachSan.setVisible(false);
			homeActivity.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(true);
			nhanVienActivity.setVisible(false);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == leftMenu.btnNhanVien) {
			homeActivity.setVisible(false);
			soDoKhachSan.setVisible(false);
			baoCaoActivity.setVisible(false);
			danhSachHoaDonActivity.setVisible(false);
			doanhThuActivity.setVisible(false);
			khachHangDatPhongActivity.setVisible(false);
			khachHangQuenDoActivity.setVisible(false);
			nhanVienActivity.setVisible(true);
			donGiaDichVuActivity.setVisible(false);
			homeActivity.time.stop();

		}
		if (e.getSource() == head.btnThoat) {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainActivity frame = new MainActivity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
