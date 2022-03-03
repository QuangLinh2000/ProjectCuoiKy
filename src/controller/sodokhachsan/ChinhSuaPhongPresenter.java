package controller.sodokhachsan;

import model.KhachSan;
import model.Phong;

public class ChinhSuaPhongPresenter {
	IChinhSuaPhong chinhSuaPhong;
	
	public ChinhSuaPhongPresenter(IChinhSuaPhong chinhSuaPhong) {
		this.chinhSuaPhong = chinhSuaPhong;
	}
	
	public void checkShowDialogChinhSuaPhong(Phong phong) {
			// "Sẵn dùng","Cần Sửa chữa"};//"Đang ở","Đã đặt","không có"

		if(phong.getTrangThai().equals("Đang ở")) {
			chinhSuaPhong.clickChinhSuphongCoNguoiDangO();
		}else if(phong.getTrangThai().equals("Đã đặt")) {
			chinhSuaPhong.clickChinhSuaPhongCoNGuoiDaDat();
		}else {
			chinhSuaPhong.clickChinhSuaPhongCoSanDungOrCanChinhSua();
		}
	}

	public void chinhSuaPhong(KhachSan khachSan, Phong phong, String name) {
		if (phong.getName().isEmpty()) {
			chinhSuaPhong.chinhSuaPhongThatBaiTrong();
		} else if(khachSan.editPhong(name, phong) == false){
			chinhSuaPhong.chinhSuaPhongThatBaiTrungTen();
		}else {
			chinhSuaPhong.chinhSuaPhongThanhCong(phong);
		}

	}
}
