package controller.sodokhachsan;

import model.Phong;

public class XoaPhongPresenter {
	IXoaPhong xoaPhong;

	public XoaPhongPresenter(IXoaPhong xoaPhong) {
		this.xoaPhong = xoaPhong;
	}

	public void clickXoaPhong(Phong phong) {
		// "Sẵn dùng","Cần Sửa chữa"};//"Đang ở","Đã đặt","không có"

		if (phong.getTrangThai().equals("Đang ở")) {
			xoaPhong.clickXoaPhongCoNguoiO();
		} else if (phong.getTrangThai().equals("Đã đặt")) {
			xoaPhong.clickXoaPhongCoNguoiDaDat();

		} else {
			xoaPhong.clickXoaPhongSanDungOrCanSuaChua();

		}
	}

}
