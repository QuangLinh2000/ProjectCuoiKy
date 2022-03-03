package controller.sodokhachsan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controller.danhsachhoadon.IHoaDonTraPhong;
import controller.khachhangdatphong.IKhachHangDatPhong;
import controller.khachhangdatphong.ObserVer;
import controller.khachhangdatphong.Suject;
import model.DichVu;
import model.KhachHangDatPhong;
import model.KhachHangThuePhong;
import model.KhachSan;
import model.Phong;
import view.HienThiChonDichVu;
import view.PanelSoDoKhachSan;
import view.dialog.DialogChinhSuaPhong;
import view.dialog.DialogKhachHangDatPhong;
import view.dialog.DialogThemDichVuMotPhong;
import view.dialog.DialogThemKhachSan;
import view.dialog.DialogThuePhong;
import view.dialog.DialogTraPhong;

public class ControllerSoDoKhachSan implements ISoDoKhachSan, ActionListener, MouseListener, IChinhSuaPhong, IXoaPhong,
		IThuePhong, IDatPhong, IThemDichVu, SubjectKhachHangDatPhong, ItraPhong,ObserVer{
	PanelSoDoKhachSan soDoKhachSan;
	KhachSan khachSan;
	HienThiChonDichVu[] hienThiChonDichVu;

	SoDoKhachSanPresenter soDophongPresenter;
	ChinhSuaPhongPresenter chinhSuaPhongPresenter;
	XoaPhongPresenter xoaPhongPresenter;
	ThuePhongPresenter thuePhongPresenter;
	DatPhongPresenter datPhongPresenter;
	ThemDichVuKhachHangPresenter themDichVuPresenter;
	TraPhongPresenter traPhongPresenter;

	DialogThemKhachSan dialogThemKhachSan;
	DialogChinhSuaPhong dialogChinhSuaPhong;
	DialogThuePhong dialogThuePhong;
	DialogKhachHangDatPhong dialogKhachHangDatPhong;
	DialogThemDichVuMotPhong dialogThemDichVuMotPhong;
	DialogTraPhong dialogTraPhong;

	JLabel lbThongBaoTaoKhachSan, lbphongcontrong, lbdadat, lbdango, lbCanChiSua;
	JButton btnTaoKhachSan, btnThemDichVuKhachHang;
	JButton btnHienthiPhong[];
	JPanel panelHienThiPhong, jPanelChuaTaoKhachSan;
	JScrollPane jScrollPane;
	JPopupMenu popupMenu;
	JMenuItem mnChinhSu, mnThuePhong, mnThemDichVuChoKhachHang, mnTraPhong, mnxoaphong, mnDatPhong;

	int dangO = 0, daDat = 0, conTrong = 0, canChinhSu = 0;
	String tenPhong = "";
	int index = 0;
	int size = 0;
	int size2 = 0;

	List<IKhachHangDatPhong> khachHangDatPhongOb = new ArrayList<IKhachHangDatPhong>();
	List<IHoaDonTraPhong> khachHangThuePhongOb = new ArrayList<IHoaDonTraPhong>();
	Suject suject;
	

	public ControllerSoDoKhachSan(KhachSan khachSan,Suject suject) {
		this.khachSan = khachSan;
		this.suject = suject;
		suject.dangKy(this);

		soDoKhachSan = new PanelSoDoKhachSan();
		soDophongPresenter = new SoDoKhachSanPresenter(this);
		chinhSuaPhongPresenter = new ChinhSuaPhongPresenter(this);
		xoaPhongPresenter = new XoaPhongPresenter(this);
		thuePhongPresenter = new ThuePhongPresenter(this);
		datPhongPresenter = new DatPhongPresenter(this);
		themDichVuPresenter = new ThemDichVuKhachHangPresenter(this);
		traPhongPresenter = new TraPhongPresenter(this);

		intitView();
		suKien();

	}


	private void suKien() {
		btnTaoKhachSan.addActionListener(this);
		mnThuePhong.addMouseListener(this);
		mnThemDichVuChoKhachHang.addMouseListener(this);
		mnTraPhong.addMouseListener(this);
		mnChinhSu.addMouseListener(this);
		mnxoaphong.addMouseListener(this);
		mnDatPhong.addMouseListener(this);

		btnThemDichVuKhachHang.addActionListener(this);

	}


	private void showDialogTaoKhachSan() {

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogThemKhachSan, "Thêm Khách Sạn",
				JOptionPane.OK_CANCEL_OPTION);
		String name = dialogThemKhachSan.textFieldName.getText().trim();
		int numberOfFloors = (int) dialogThemKhachSan.spinnerSoTang.getValue();
		int numberOfRooms = (int) dialogThemKhachSan.spinnerSoPhong.getValue();
		String address = dialogThemKhachSan.textFieldDiaChi.getText().trim();
		String phone = dialogThemKhachSan.textFieldPhone.getText().trim();
		String email = dialogThemKhachSan.textFieldEmail.getText().trim();
		String note = dialogThemKhachSan.textAreaGhiChu.getText().trim();

		KhachSan khachSan1 = new KhachSan(name, numberOfFloors, numberOfRooms, address, phone, email, note);
		khachSan1.setListCustomersMakeAReservation(khachSan.getListCustomersMakeAReservation());
		khachSan1.setListCustomersRentingRooms(khachSan.getListCustomersRentingRooms());
		khachSan1.setListService(khachSan.getListService());
		khachSan1.setListStaff(khachSan.getListStaff());
		khachSan1.setListRooms(khachSan.getListRooms());
		khachSan1.setLisKhachHangQuenDos(khachSan.getLisKhachHangQuenDos());
		if (result == JOptionPane.OK_OPTION) {
			soDophongPresenter.taoSoDoPhong(khachSan1);
		}

	}

	private void intitView() {
		jPanelChuaTaoKhachSan = soDoKhachSan.jPanelChuaTaoKhachSan;
		lbThongBaoTaoKhachSan = soDoKhachSan.lbThongBaoTaoKhachSan;

		btnTaoKhachSan = soDoKhachSan.btnTaoKhachSan;

		panelHienThiPhong = soDoKhachSan.panelHienThiPhong;

		jScrollPane = soDoKhachSan.scrollPane;

		popupMenu = soDoKhachSan.popupMenu;

		lbphongcontrong = soDoKhachSan.lbphongcontrong;
		lbCanChiSua = soDoKhachSan.lbCanChiSua;
		lbdadat = soDoKhachSan.lbdadat;
		lbdango = soDoKhachSan.lbdango;

		mnChinhSu = soDoKhachSan.mnChinhSu;
		mnThuePhong = soDoKhachSan.mnThuePhong;
		mnThemDichVuChoKhachHang = soDoKhachSan.mnthemdatphong;
		mnTraPhong = soDoKhachSan.mnTraPhong;
		mnxoaphong = soDoKhachSan.mnxoaphong;
		mnDatPhong = soDoKhachSan.mnDatPhong;

		dialogThemKhachSan = new DialogThemKhachSan();
		dialogChinhSuaPhong = new DialogChinhSuaPhong();
		dialogThuePhong = new DialogThuePhong();
		dialogKhachHangDatPhong = new DialogKhachHangDatPhong();
		dialogThemDichVuMotPhong = new DialogThemDichVuMotPhong();
		dialogTraPhong = new DialogTraPhong();

		btnThemDichVuKhachHang = dialogThemDichVuMotPhong.btnThem;

		soDophongPresenter.checkTaoPhong(khachSan);
	}

	public PanelSoDoKhachSan getSoDoKhachSan() {
		return soDoKhachSan;
	}

	@Override
	public void chuaTaoKhachSan() {
		jPanelChuaTaoKhachSan.setVisible(true);
		jScrollPane.setVisible(false);

	}

	@Override
	public void daTaoKhachSan() {
		jPanelChuaTaoKhachSan.setVisible(false);
		jScrollPane.setVisible(true);

	}

	@Override
	public void taoSoDoPhongThanhCong(KhachSan khachSan) {

		this.khachSan = khachSan;
		this.khachSan.taoSoDoPhong();

		jPanelChuaTaoKhachSan.setVisible(false);
		jScrollPane.setVisible(true);
		jScrollPane.setViewportView(panelHienThiPhong);

		JOptionPane.showMessageDialog(soDoKhachSan, "Tạo khách sạn thành công");

		try {
			taoSoDoPhong(khachSan.getNumberOfRooms(), khachSan.getNumberOfFloors());

			capNhatTrangThai();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void taoSoDoPhongThatBai() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Tên khách sạn trống hoặc số phòng lớn hơn số tầng");
		showDialogTaoKhachSan();

	}

	private void taoSoDoPhong(int soPhong, int sotang) {
		int j = 0;
		int count = 0;
		int soPhongMotTang = khachSan.soPhongmotTang(sotang, soPhong);
		panelHienThiPhong.setLayout(new GridLayout(sotang, soPhongMotTang, 10, 10));
		btnHienthiPhong = new JButton[soPhong + sotang];

		for (int i = 0; i < soPhong + sotang; i++) {
			btnHienthiPhong[i] = new JButton();
			if (i == 0 || count == soPhongMotTang) {
				btnHienthiPhong[i].setText(khachSan.getListRooms().get(j).getTang());
				btnHienthiPhong[i].setBackground(Color.black);
				btnHienthiPhong[i].setForeground(Color.white);
				btnHienthiPhong[i].setFont(new Font("Tahoma", Font.BOLD, 17));
				count = 0;
			} else {

				btnHienthiPhong[i].setBackground(Color.green);
				btnHienthiPhong[i].setText(khachSan.getListRooms().get(j).getName());

				addPopup(btnHienthiPhong[i], popupMenu);
				btnHienthiPhong[i].addActionListener(this);
				btnHienthiPhong[i].addMouseListener(this);

				j++;
				count++;

			}
			panelHienThiPhong.add(btnHienthiPhong[i]);

		}
		panelHienThiPhong.validate();
		soDoKhachSan.validate();
	}

	public void capNhatTrangThai() {
		dangO = 0;
		daDat = 0;
		conTrong = 0;
		canChinhSu = 0;
		for (int i =0 ; i< khachSan.getListRooms().size();i++) {
			if (khachSan.getListRooms().get(i).getTrangThai().equals("Sẵn dùng")) {
				conTrong++;
			}
			if (khachSan.getListRooms().get(i).getTrangThai().equals("Cần Sửa chữa")) {
				canChinhSu++;

			}
			if (khachSan.getListRooms().get(i).getTrangThai().equals("Đang ở")) {
				dangO++;

			}
			if (khachSan.getListRooms().get(i).getTrangThai().equals("Đã đặt")) {
				daDat++;

			}

		}
		// System.out.println(khachSan.getListRooms().size());
		lbCanChiSua.setText("Cần chỉnh sữa: " + canChinhSu);
		lbdadat.setText("Đã đặt: " + daDat);
		lbdango.setText("Đang ở: " + dangO);
		lbphongcontrong.setText("Còn trống: " + conTrong);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTaoKhachSan) {
			showDialogTaoKhachSan();
		}
		if (e.getSource() == btnThemDichVuKhachHang) {
			themDichVuChoKhachHang();
		}
		try {
			for (int i = 0; i < btnHienthiPhong.length; i++) {
				if (btnHienthiPhong[i] == e.getSource()) {

					tenPhong = btnHienthiPhong[i].getText();
					index = i;
					break;
				}
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource() == mnChinhSu) {
			Phong phong = khachSan.layPhong(tenPhong);
			chinhSuaPhongPresenter.checkShowDialogChinhSuaPhong(phong);

		}
		if (e.getSource() == mnThemDichVuChoKhachHang) {
			Phong phong = khachSan.layPhong(tenPhong);
			themDichVuPresenter.checkShowDialogThemDichVu(phong);

		}
		if (e.getSource() == mnThuePhong) {
			Phong phong = khachSan.layPhong(tenPhong);
			thuePhongPresenter.checkShowThuePhong(phong);
		}
		if (e.getSource() == mnTraPhong) {
			Phong phong = khachSan.layPhong(tenPhong);
			traPhongPresenter.click(phong);
		}
		if (e.getSource() == mnxoaphong) {
			Phong phong = khachSan.layPhong(tenPhong);
			xoaPhongPresenter.clickXoaPhong(phong);

		}
		if (e.getSource() == mnDatPhong) {

			Phong phong = khachSan.layPhong(tenPhong);
			datPhongPresenter.clickDatPhong(phong);

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void trangThaiPhongSanDung() {
		btnHienthiPhong[index].setBackground(Color.green);

	}

	@Override
	public void trangThaiPhongDangO() {
		btnHienthiPhong[index].setBackground(Color.red);

	}

	@Override
	public void trangthaiPhongCanChinhSua() {
		btnHienthiPhong[index].setBackground(new Color(139, 0, 0));

	}

	@Override
	public void trangThaiPhongDaDat() {
		btnHienthiPhong[index].setBackground(Color.ORANGE);

	}

	@Override
	public void trangThaiKhongCoPhong() {
		btnHienthiPhong[index].setVisible(false);
	}
//-----------------------------------------chinh sua phong--------------------------------

	private void showDialogChinhSuaPhong() {
		Phong p = khachSan.layPhong(tenPhong);
		dialogChinhSuaPhong.textFieldTenPhong.setText(p.getName());
		dialogChinhSuaPhong.comLoaiPhong.setSelectedItem(p.getLoaiPhong());
		dialogChinhSuaPhong.comTrangThai.setSelectedItem(p.getTrangThai());
		dialogChinhSuaPhong.spinnerGia.setValue(p.getGia());
		dialogChinhSuaPhong.textAreaGhiChu.setText(p.getGhiChu());

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogChinhSuaPhong, "Chỉnh sửa phòng",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String name = dialogChinhSuaPhong.textFieldTenPhong.getText().trim();
			String tang = khachSan.layPhong(tenPhong).getTang();
			String loaiPhong = dialogChinhSuaPhong.comLoaiPhong.getSelectedItem().toString();
			String trangThai = dialogChinhSuaPhong.comTrangThai.getSelectedItem().toString();
			String ghiChu = dialogChinhSuaPhong.textAreaGhiChu.getText().trim();
			double gia = Double.parseDouble(dialogChinhSuaPhong.spinnerGia.getValue() + "");

			Phong phong = new Phong(name, tang, loaiPhong, trangThai, ghiChu, (int) gia);
			chinhSuaPhongPresenter.chinhSuaPhong(khachSan, phong, tenPhong);
		}
	}

	@Override
	public void clickChinhSuphongCoNguoiDangO() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng có người đang ở");

	}

	@Override
	public void clickChinhSuaPhongCoNGuoiDaDat() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng có người đã đặt");

	}

	@Override
	public void clickChinhSuaPhongCoSanDungOrCanChinhSua() {
		showDialogChinhSuaPhong();

	}

	@Override
	public void chinhSuaPhongThatBaiTrong() {

		JOptionPane.showMessageDialog(soDoKhachSan, "Vui lòng điền đầy đủ thông tin");
		showDialogChinhSuaPhong();

	}

	@Override
	public void chinhSuaPhongThatBaiTrungTen() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Tên đã tồn tại");
		showDialogChinhSuaPhong();

	}

	@Override
	public void chinhSuaPhongThanhCong(Phong phong) {
		JOptionPane.showMessageDialog(soDoKhachSan, "Chỉnh sửa phòng thành công");
		khachSan.editPhong(tenPhong, phong);
		soDophongPresenter.checkTrangThaiPhong(phong);
		btnHienthiPhong[index].setText(phong.getName());
		capNhatTrangThai();
	}

//----------------------------------Xoa phong------------------------------
	@Override
	public void clickXoaPhongCoNguoiO() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Không thể xóa phòng hiện có người ở");

	}

	@Override
	public void clickXoaPhongCoNguoiDaDat() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Không thể xóa phòng hiện có người đặt");

	}

	@Override
	public void clickXoaPhongSanDungOrCanSuaChua() {

		int n = JOptionPane.showConfirmDialog(soDoKhachSan, "Bạn có chắc chắn muốn xóa phòng này", "Xóa phòng",
				JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.OK_OPTION) {
			btnHienthiPhong[index].setVisible(false);
			khachSan.removePhong(tenPhong);
			capNhatTrangThai();

		}

	}
//----------------------------------thue phong----------------------------------------------------
    public String formatTien(double tien) {
    	 Locale localeEN = new Locale("en", "EN");
    	    NumberFormat en = NumberFormat.getInstance(localeEN);      
    	    String str1 = en.format(tien);
    	    return str1;
    }
	public void showDialogThuePhong(boolean check) {
		Phong phong2 = khachSan.layPhong(tenPhong);

		if(check) {
			dialogThuePhong.textAreaGhiChu.setText("");
			dialogThuePhong.textFieldCMND.setText("");
			dialogThuePhong.textFieldNGuoiTao.setText("");
			dialogThuePhong.textFieldTenKhachhang.setText("");
		}

		dialogThuePhong.textFieldThuePhong.setText(tenPhong);
		dialogThuePhong.textFieldGia.setText( formatTien(phong2.getGia())+" VND");
		dialogThuePhong.lbNgayTao.setText(LocalDate.now().getDayOfMonth()+"/"+LocalDate.now().getMonthValue()+"/"+LocalDate.now().getYear());

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogThuePhong, "Chỉnh sửa phòng",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String name = dialogThuePhong.textFieldTenKhachhang.getText().trim();
			String room = dialogThuePhong.textFieldThuePhong.getText().trim();
			String cMND = dialogThuePhong.textFieldCMND.getText().trim();
			String note = dialogThuePhong.textAreaGhiChu.getText().trim();
			String staff = dialogThuePhong.textFieldNGuoiTao.getText().trim();// ten
			String hotel = khachSan.getName();
            
			String[] da = dialogThuePhong.lbNgayTao.getText().toString().trim().split("/");
			int ngayTao = Integer.parseInt(da[0]);
			int thangTao = Integer.parseInt(da[1]);
			int namTao = Integer.parseInt(da[2]);
			Date dateCreate = new Date(namTao, thangTao, ngayTao); 
			double priceRoom =phong2.getGia();
			int numberOfDays = (int) dialogThuePhong.soNgayDinhO.getValue();//
			double moneyPrepay = (double) dialogThuePhong.soTienTraTruoc.getValue();
			boolean status = true;

			double sumMoney = 0;
			Date checkOutDate = new Date(namTao, thangTao, ngayTao);

			KhachHangThuePhong khachHangThuePhong = new KhachHangThuePhong(name, room, cMND, note, staff, hotel,
					dateCreate, priceRoom, numberOfDays, moneyPrepay, status, sumMoney, checkOutDate);
			Phong phong = khachSan.layPhong(tenPhong);
			thuePhongPresenter.checkThuePhong(khachHangThuePhong, khachSan, phong);
		}
	}

	@Override
	public void thuePhongThanhCong(KhachHangThuePhong khachHang) {
		JOptionPane.showMessageDialog(soDoKhachSan, "Thuê phòng thành công");
		// khachSan.addKhachHangThuePhong(khachHang, tenPhong);
		Phong phong = khachSan.layPhong(tenPhong);
		soDophongPresenter.checkTrangThaiPhong(phong);
		capNhatTrangThai();

	}

	@Override
	public void thuePhongThatBaiThongTinTrong() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Vui lòng nhập đầy đủ thông tin");
		showDialogThuePhong(false);

	}

	@Override
	public void thuePhongThatBaiCoNGuoiDat() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng số ngày ở vượt quá số ngày người đã đặt");
		showDialogThuePhong(false);

	}

	@Override
	public void clickThuePhongCoNguoiDangO() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng có người đang ở");

	}

	@Override
	public void clickThuePhongCanSuaChua() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng đang sửa chữa");

	}

	@Override
	public void clickThuePhongSanDungOrDaDat() {
		showDialogThuePhong(true);

	}

	// ------------------------------------datphong-----------------------
	public void showDialogDatPhong(boolean check) {
		Phong phong2 = khachSan.layPhong(tenPhong);
		dialogKhachHangDatPhong.textFieldThuePhong.setText(tenPhong);
		dialogKhachHangDatPhong.textFieldGia.setText(formatTien(phong2.getGia())+" VNĐ");
		
		if(check == true) {
			dialogKhachHangDatPhong.textAreaGhiChu.setText("");
			dialogKhachHangDatPhong.textFieldCMND.setText("");
			dialogKhachHangDatPhong.textFieldNGuoiTao.setText("");
			dialogKhachHangDatPhong.textFieldTenKhachhang.setText("");
		}

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogKhachHangDatPhong, "Đặt phòng",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String name = dialogKhachHangDatPhong.textFieldTenKhachhang.getText().trim();
			String room = dialogKhachHangDatPhong.textFieldThuePhong.getText().trim();
			String cMND = dialogKhachHangDatPhong.textFieldCMND.getText().trim();
			String note = dialogKhachHangDatPhong.textAreaGhiChu.getText().trim();
			String staff = dialogKhachHangDatPhong.textFieldNGuoiTao.getText().trim();// ten
			String hotel = khachSan.getName();
			
			String da[] = dialogKhachHangDatPhong.lbNgayTao.getText().split("/");
			int ngayTao = Integer.parseInt(da[0]);
			int thangTao = Integer.parseInt(da[1]);
			int namTao = Integer.parseInt(da[2]);
			
			@SuppressWarnings("deprecation")
			Date dateCreate = new Date(namTao, thangTao, ngayTao);
			double priceRoom = phong2.getGia();
			int numberOfDays = (int) dialogKhachHangDatPhong.soNgayDinhO.getValue();//
			double moneyPrepay = (double) dialogKhachHangDatPhong.soTienTraTruoc.getValue();

			String da2[] = dialogKhachHangDatPhong.lbNgayDenO.getText().split("/");
			int ngay = Integer.parseInt(da2[0]);
			int thang = Integer.parseInt(da2[1]);
			int nam = Integer.parseInt(da2[2]);

			Date dateNgayDenO = new Date(nam, thang, ngay);
			KhachHangDatPhong khachHangThuePhong = new KhachHangDatPhong(name, room, cMND, note, staff, hotel,
					dateCreate, priceRoom, numberOfDays, moneyPrepay, dateNgayDenO);

			datPhongPresenter.checkDatPhong(khachHangThuePhong);
		}
	}

	@Override
	public void clickDatPhongDangSuaChua() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng đang sửa chữa");

	}

	@Override
	public void clickDatPhongCoNGuoiO() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng đang có người ở");

	}

	@Override
	public void clickDatPhongCoNGuoiDat() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Phòng đã có người đặt");

	}

	@Override
	public void clickDatPhongSanDung() {
		showDialogDatPhong(true);

	}

	@Override
	public void datPhongThatBaiThongTinTrong() {
		JOptionPane.showMessageDialog(soDoKhachSan, "Vui lòng điền đầy đủ thông tin");
		showDialogDatPhong(false);

	}

	@Override
	public void datPhongThanhCong(KhachHangDatPhong khachHangDatPhong) {
		JOptionPane.showMessageDialog(soDoKhachSan, "Đặt phòng thành công");
		update(khachHangDatPhong);
		khachSan.addKhachHangDatPhong(khachHangDatPhong, tenPhong);
		capNhatTrangThai();
		Phong phong = khachSan.layPhong(tenPhong);
		soDophongPresenter.checkTrangThaiPhong(phong);

	}

	// --------------------them dich vu mot phong-------------------------
	public void showDialogThemDichVu() {
		dialogThemDichVuMotPhong.panel.setLayout(new GridLayout(khachSan.getListService().size(), 1));
		dialogThemDichVuMotPhong.panel.removeAll();
		dialogThemDichVuMotPhong.lbTenPhong.setText(tenPhong);
		hienThiChonDichVu = new HienThiChonDichVu[khachSan.getListService().size()];
		for (int i = 0; i < khachSan.getListService().size(); i++) {
			hienThiChonDichVu[i] = new HienThiChonDichVu();
			hienThiChonDichVu[i].lbGia.setText(khachSan.getListService().get(i).getGia() + "");
			hienThiChonDichVu[i].lbTenDichVu.setText(khachSan.getListService().get(i).getTen());
			dialogThemDichVuMotPhong.panel.add(hienThiChonDichVu[i]);
		}
		dialogThemDichVuMotPhong.scrollPane_1.validate();
		List<DichVu> list = khachSan.getListCustomersRentingRooms()
				.get(khachSan.searcherKhachHangThuePhongIndext(tenPhong)).getListService();

		for (int i = 0; i < list.size(); i++) {
			DichVu dichVu = list.get(i);
			Object[] ob = { dichVu.getTen(), dichVu.getGia(), dichVu.getSoLuong() };
			dialogThemDichVuMotPhong.mode.addRow(ob);
		}

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogThemDichVuMotPhong, "Thêm dịch vụ",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			for (int i = 0; i < list.size(); i++) {
				dialogThemDichVuMotPhong.mode.removeRow(0);
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				dialogThemDichVuMotPhong.mode.removeRow(0);
			}
		}
	}

	@Override
	public void clickThemDichVuCoNguoiThue() {
		showDialogThemDichVu();

	}

	@Override
	public void clickThemDichVuKhongCoNguoiThue() {
		JOptionPane.showMessageDialog(soDoKhachSan, "phòng không có người thuê");

	}

	private void themDichVuChoKhachHang() {

		JOptionPane.showMessageDialog(soDoKhachSan, "Thêm dịch vụ thành công");
		List<DichVu> list1 = khachSan.getListCustomersRentingRooms()
				.get(khachSan.searcherKhachHangThuePhongIndext(tenPhong)).getListService();
		for (int i = 0; i < list1.size(); i++) {
			dialogThemDichVuMotPhong.mode.removeRow(0);
		}
		for (int i = 0; i < hienThiChonDichVu.length; i++) {
			if ((int) hienThiChonDichVu[i].soLuong.getValue() > 0) {
				DichVu dichVu = new DichVu(hienThiChonDichVu[i].lbTenDichVu.getText(),
						Double.parseDouble(hienThiChonDichVu[i].lbGia.getText()),
						(int) hienThiChonDichVu[i].soLuong.getValue(), "null");
				khachSan.getListCustomersRentingRooms().get(khachSan.searcherKhachHangThuePhongIndext(tenPhong))
						.addDichVu(dichVu);

			}

		}
		List<DichVu> list = khachSan.getListCustomersRentingRooms()
				.get(khachSan.searcherKhachHangThuePhongIndext(tenPhong)).getListService();
		for (int i = 0; i < list.size(); i++) {
			DichVu dichVu = list.get(i);
			Object[] ob = { dichVu.getTen(), dichVu.getGia(), dichVu.getSoLuong() };
			dialogThemDichVuMotPhong.mode.addRow(ob);
		}
		dialogThemDichVuMotPhong.panel.removeAll();
		hienThiChonDichVu = new HienThiChonDichVu[khachSan.getListService().size()];
		for (int i = 0; i < khachSan.getListService().size(); i++) {
			hienThiChonDichVu[i] = new HienThiChonDichVu();
			hienThiChonDichVu[i].lbGia.setText(khachSan.getListService().get(i).getGia() + "");
			hienThiChonDichVu[i].lbTenDichVu.setText(khachSan.getListService().get(i).getTen());
			dialogThemDichVuMotPhong.panel.add(hienThiChonDichVu[i]);
		}
		dialogThemDichVuMotPhong.scrollPane_1.validate();

	}

	// -------------------observer ---------------------------------
	@Override
	public void dangKy(IKhachHangDatPhong ob) {
		khachHangDatPhongOb.add(ob);

	}

	@Override
	public void update(KhachHangDatPhong khachHangDatPhong) {
		for (IKhachHangDatPhong kh : khachHangDatPhongOb) {
			kh.update(khachHangDatPhong);
		}

	}

// ----------------------tra phong------------------------------
	public void showDiaLogTraPhong() {
		// lbGioVao, lbGioTra, lbLoaiPhong, lbGia, lbTienPhong, lbTongtienDV,
		// lbTongCong, lbTenKhachhang

		KhachHangThuePhong khachHangThuePhong = khachSan.searcherKhachHangThuePhong(tenPhong);

		int ngayTao = (int) khachHangThuePhong.getDateCreate().getDate();
		int thangTao = (int) khachHangThuePhong.getDateCreate().getMonth();
		int namTao = (int) khachHangThuePhong.getDateCreate().getYear();

		int ngayRa = (int) khachHangThuePhong.getCheckOutDate().getDate();
		int thangRa = (int) khachHangThuePhong.getCheckOutDate().getMonth();
		int namRa = (int) khachHangThuePhong.getCheckOutDate().getYear();

		dialogTraPhong.lbGioVao.setText(ngayTao + "/" + thangTao + "/" + namTao);
		dialogTraPhong.lbGioTra.setText(ngayRa + "/" + thangRa + "/" + namRa);
		dialogTraPhong.lbPhongNao.setText(khachHangThuePhong.getRoom() + "");
		dialogTraPhong.lbGia.setText(formatTien(khachHangThuePhong.getPriceRoom()) + "VND");
		dialogTraPhong.lbTenKhachhang.setText(khachHangThuePhong.getName());
		dialogTraPhong.lbTienPhong.setText(formatTien(khachHangThuePhong.tinhTienPhong()) + "VND");
		dialogTraPhong.lbTongtienDV.setText(formatTien(khachHangThuePhong.tinhTienDichVu()) + "VND");
		dialogTraPhong.lbTongCong.setText(formatTien(khachHangThuePhong.tongTien()) + "VND");
		dialogTraPhong.lbTraTruoc.setText(formatTien(khachHangThuePhong.getMoneyPrepay()) + "VND");
		List<DichVu> list = khachSan.getListCustomersRentingRooms()
				.get(khachSan.searcherKhachHangThuePhongIndext(tenPhong)).getListService();

		for (int i = 0; i < list.size(); i++) {
			DichVu dichVu = list.get(i);
			Object[] ob = { dichVu.getTen(), dichVu.getGia(), dichVu.getSoLuong() };
			dialogTraPhong.defaultTableModel.addRow(ob);
		}

		int result = JOptionPane.showConfirmDialog(soDoKhachSan, dialogTraPhong, "Trả phòng",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			traPhongPresenter.traPhong(dialogTraPhong.rdbtnNewRadioButton,khachHangThuePhong);

			for (int i = 0; i < list.size(); i++) {
				dialogTraPhong.defaultTableModel.removeRow(0);
			}
		} else {

			for (int i = 0; i < list.size(); i++) {
				dialogTraPhong.defaultTableModel.removeRow(0);
			}
		}
	}

	@Override
	public void clickTraPhongCoNguoio() {
		showDiaLogTraPhong();

	}

	@Override
	public void clickTraPhongKhongCoNGuoiO() {
		JOptionPane.showMessageDialog(soDoKhachSan, "phòng không có người ở");

	}

	@Override
	public void traPhongInHoaDon(KhachHangThuePhong khachHangThuePhong) {
		khachSan.khachHangTraPhong(tenPhong);
		capNhatTrangThai();
		Phong phong = khachSan.layPhong(tenPhong);
		soDophongPresenter.checkTrangThaiPhong(phong);
		writerExel(khachHangThuePhong.getListService(), khachHangThuePhong.getName(), khachHangThuePhong.getPriceRoom()+""
				, khachHangThuePhong.tinhTienDichVu()+"", khachHangThuePhong.tongTien()+"");
		updateKhachHangTraPhong(khachHangThuePhong);

	}

	@Override
	public void traPhongKhongInHoaDong(KhachHangThuePhong khachHangThuePhong) {
		khachSan.khachHangTraPhong(tenPhong);
		capNhatTrangThai();
		Phong phong = khachSan.layPhong(tenPhong);
		soDophongPresenter.checkTrangThaiPhong(phong);
		updateKhachHangTraPhong(khachHangThuePhong);

	}
	public void writerExel(List<DichVu> listDv, String tenKhachHang, String giaPhong, String giaDichVu,
			String TongGia) {

		try {
			File fil = new File("C:\\Users\\QUANGLINH\\Desktop\\" + tenKhachHang + ".xlsx");

			FileOutputStream file = new FileOutputStream(fil);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
			XSSFSheet xssfSheet = xssfWorkbook.createSheet(tenKhachHang);
			XSSFRow row;
			XSSFCell cellA;
			XSSFCell cellB;
			XSSFCell cellC;
			XSSFCell cellCTinhTien;
			XSSFCell cellCTinhTien2;

			row = xssfSheet.createRow(0);
			cellA = row.createCell(0);
			cellA.setCellValue("Hóa Đơn Khách Hàng " + tenKhachHang);

			row = xssfSheet.createRow(1);
			cellA = row.createCell(0);
			cellA.setCellValue("Tên Dịch vụ");

			cellB = row.createCell(1);
			cellB.setCellValue("Giá");

			cellC = row.createCell(2);
			cellC.setCellValue("Số Lượng");
			int so = 2;
			for (int i = 0; i < listDv.size(); i++) {
				row = xssfSheet.createRow(so);
				cellA = row.createCell(0);
				cellA.setCellValue(listDv.get(i).getTen());

				cellB = row.createCell(1);
				cellB.setCellValue(listDv.get(i).getGia());

				cellC = row.createCell(2);
				cellC.setCellValue(listDv.get(i).getSoLuong());
				so++;
			}

			row = xssfSheet.createRow(listDv.size() + 2);
			cellCTinhTien = row.createCell(1);
			cellCTinhTien.setCellValue("Giá Phòng");
			cellCTinhTien2 = row.createCell(2);
			cellCTinhTien2.setCellValue(giaPhong);

			row = xssfSheet.createRow(listDv.size() + 3);
			cellCTinhTien = row.createCell(1);
			cellCTinhTien.setCellValue("Dịch Vụ");
			cellCTinhTien2 = row.createCell(2);
			cellCTinhTien2.setCellValue(giaDichVu);

			row = xssfSheet.createRow(listDv.size() + 4);
			cellCTinhTien = row.createCell(1);
			cellCTinhTien.setCellValue("Tổng Tiền");
			cellCTinhTien2 = row.createCell(2);
			cellCTinhTien2.setCellValue(TongGia);
			xssfWorkbook.write(file);
			xssfWorkbook.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// -----------------khach hang tra phong----------------
	@Override
	public void updateKhachHangTraPhong(KhachHangThuePhong khachHangThuePhong) {
             for (IHoaDonTraPhong hd : khachHangThuePhongOb) {
				hd.update(khachHangThuePhong);
			}
	}

	@Override
	public void dangKyKhachHangTraPhong(IHoaDonTraPhong ob) {
		
		khachHangThuePhongOb.add(ob);
	}
	@Override
	public void updateKhacDenO(String i) {
		for (int j = 0; j < btnHienthiPhong.length; j++) {
			if(btnHienthiPhong[j].getText().toString().equals(i)) {
				btnHienthiPhong[j].setBackground(Color.RED);
				break;
			}
		}
		capNhatTrangThai();
		
	}

	@Override
	public void huyDatPhong(String i) {
		Phong phong = khachSan.layPhong(i);
		if(phong.getTrangThai().equals("Đã đặt")||phong.getTrangThai().equals("Sẵn dùng")) {	
				for (int j = 0; j < btnHienthiPhong.length; j++) {
					if(btnHienthiPhong[j].getText().toString().equals(i)) {
						btnHienthiPhong[j].setBackground(Color.GREEN);
						break;
					}
				}
			capNhatTrangThai();
		}
		
		
	}

}
