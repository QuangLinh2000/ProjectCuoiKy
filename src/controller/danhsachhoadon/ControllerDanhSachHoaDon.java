package controller.danhsachhoadon;

import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.sodokhachsan.SubjectKhachHangDatPhong;
import model.KhachHangThuePhong;
import model.KhachSan;
import view.DanhSachHoaDonActivity;

public class ControllerDanhSachHoaDon implements IHoaDonTraPhong {
	DanhSachHoaDonActivity view;
	KhachSan khachSan;

	DefaultTableModel model;
	JTable table;
	SubjectKhachHangDatPhong subjectKhachHangDatPhong;

	public ControllerDanhSachHoaDon(KhachSan khachSan, SubjectKhachHangDatPhong subjectKhachHangDatPhong) {
		this.khachSan = khachSan;
		this.subjectKhachHangDatPhong = subjectKhachHangDatPhong;
		subjectKhachHangDatPhong.dangKyKhachHangTraPhong(this);
		view = new DanhSachHoaDonActivity();
		initView();
		// { "Phòng", "Tên Khách hàng","Ngày lập","Người Lập","Tổng Tiền" };

		List<KhachHangThuePhong> list = khachSan.getListCustomersRentingRooms();

		for (KhachHangThuePhong khachHangThuePhong : list) {
			Object[] ob = { khachHangThuePhong.getRoom(), khachHangThuePhong.getName(),
					khachHangThuePhong.getCheckOutDate(), khachHangThuePhong.getStaff(),
					khachHangThuePhong.tongTien() };
			model.addRow(ob);
		}

	}

	private void initView() {
		model = view.model;
		table = view.table;

	}

	public DanhSachHoaDonActivity getView() {
		return view;
	}

	@Override
	public void update(KhachHangThuePhong khachHangThuePhong) {
        Date date = khachHangThuePhong.getCheckOutDate();
        String ngaylap = date.getDate()+"/"+date.getMonth()+"/"+date.getYear();
		Object[] ob = { khachHangThuePhong.getRoom(), khachHangThuePhong.getName(),
				ngaylap, khachHangThuePhong.getStaff(), khachHangThuePhong.tongTien() };
		model.addRow(ob);
	}

}
