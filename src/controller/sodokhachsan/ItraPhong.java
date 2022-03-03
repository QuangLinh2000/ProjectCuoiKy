package controller.sodokhachsan;

import model.KhachHangThuePhong;

public interface ItraPhong {
	public void clickTraPhongCoNguoio();
	public void clickTraPhongKhongCoNGuoiO();
	
	public void traPhongInHoaDon(KhachHangThuePhong khachHangThuePhong);
	public void traPhongKhongInHoaDong(KhachHangThuePhong khachHangThuePhong);

}
