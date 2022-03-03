package controller.sodokhachsan;

import model.KhachHangThuePhong;
import model.KhachSan;
import model.Phong;

public class ThuePhongPresenter {
	IThuePhong thuePhong;
	public ThuePhongPresenter(IThuePhong thuePhong) {
		this.thuePhong = thuePhong;
	}
	public void checkThuePhong(KhachHangThuePhong khachHang, KhachSan khachSan,Phong phong) {
		
		if (khachHang.getName().isEmpty() || khachHang.getcMND().isEmpty() || khachHang.getStaff().isEmpty()) {
			thuePhong.thuePhongThatBaiThongTinTrong();
		}else if(!khachSan.addKhachHangThuePhong(khachHang, phong.getName())) {
			thuePhong.thuePhongThatBaiCoNGuoiDat();
		}else {
			thuePhong.thuePhongThanhCong(khachHang);
			//System.out.println(khachSan.getListRooms().size()+"presenter");
		}

	}
	public void checkShowThuePhong(Phong phong) {
		 if (phong.getTrangThai().equals("Cần Sửa chữa")) {
			 thuePhong.clickThuePhongCanSuaChua();
			} else if (phong.getTrangThai().equals("Đang ở")) {
				thuePhong.clickThuePhongCoNguoiDangO();
			} else {
				thuePhong.clickThuePhongSanDungOrDaDat();
			}
	}

}
