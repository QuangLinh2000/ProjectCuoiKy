package controller.sodokhachsan;

import model.KhachHangThuePhong;

public interface IThuePhong {
	public void thuePhongThanhCong(KhachHangThuePhong khachHang);
	public void thuePhongThatBaiThongTinTrong();
	public void thuePhongThatBaiCoNGuoiDat();
	
	public void clickThuePhongCoNguoiDangO();
	public void clickThuePhongCanSuaChua();
	public void clickThuePhongSanDungOrDaDat();

}
