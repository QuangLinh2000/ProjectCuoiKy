package controller.sodokhachsan;

import model.KhachSan;
import model.Phong;

public class SoDoKhachSanPresenter {
	ISoDoKhachSan iSoDoKhachSan;

	public SoDoKhachSanPresenter(ISoDoKhachSan iSoDoKhachSan) {
		this.iSoDoKhachSan = iSoDoKhachSan;
	}

	public void checkTaoPhong(KhachSan khachSan) {
		//view -> presenter -> model. model -> presenter -> view
		if (khachSan.getListRooms().size() == 0) {
			iSoDoKhachSan.chuaTaoKhachSan();
		} else {
			iSoDoKhachSan.daTaoKhachSan();
		}
	}

	public void taoSoDoPhong(KhachSan khachSan) {

		if (khachSan.getNumberOfRooms() < khachSan.getNumberOfFloors() || khachSan.getName().isEmpty()) {
			iSoDoKhachSan.taoSoDoPhongThatBai();

		} else {
			iSoDoKhachSan.taoSoDoPhongThanhCong(khachSan);
			

		}

	}

	

	public void checkTrangThaiPhong(Phong phong) {
		// "Sẵn dùng","Cần Sửa chữa"};//"Đang ở","Đã đặt","không có"
		if (phong.getTrangThai().equals("Sẵn dùng")) {
			iSoDoKhachSan.trangThaiPhongSanDung();
		}
		if (phong.getTrangThai().equals("Cần Sửa chữa")) {
			iSoDoKhachSan.trangthaiPhongCanChinhSua();
		}
		if (phong.getTrangThai().equals("Đang ở")) {
			iSoDoKhachSan.trangThaiPhongDangO();
		}
		if (phong.getTrangThai().equals("Đã đặt")) {
			iSoDoKhachSan.trangThaiPhongDaDat();
		}
		if (phong.getTrangThai().equals("không có")) {
			iSoDoKhachSan.trangThaiKhongCoPhong();
		}
	}

	

}
