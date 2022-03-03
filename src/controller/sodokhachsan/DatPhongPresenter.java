package controller.sodokhachsan;

import model.KhachHangDatPhong;
import model.Phong;

public class DatPhongPresenter {
	IDatPhong datPhong;

	public DatPhongPresenter(IDatPhong datPhong) {
		this.datPhong = datPhong;
	}

	public void clickDatPhong(Phong phong) {
		// "Sẵn dùng","Cần Sửa chữa"};//"Đang ở","Đã đặt","không có"

		if (phong.getTrangThai().equals("Cần Sửa chữa")) {
			datPhong.clickDatPhongDangSuaChua();
		} else if (phong.getTrangThai().equals("Đang ở")) {
			datPhong.clickDatPhongCoNGuoiO();

		} else if (phong.getTrangThai().equals("Đã đặt")) {
			datPhong.clickDatPhongCoNGuoiDat();

		} else {
			datPhong.clickDatPhongSanDung();

		}
	}
	public void checkDatPhong(KhachHangDatPhong khachHang) {
		if(khachHang.getName().isEmpty() || khachHang.getcMND().isEmpty() || khachHang.getStaff().isEmpty()) {
			datPhong.datPhongThatBaiThongTinTrong();
		}else {
			datPhong.datPhongThanhCong(khachHang);
		}
	}

}
