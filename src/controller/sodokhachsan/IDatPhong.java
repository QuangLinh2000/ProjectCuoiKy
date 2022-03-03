package controller.sodokhachsan;

import model.KhachHangDatPhong;

public interface IDatPhong {
	public void clickDatPhongDangSuaChua();
	public void clickDatPhongCoNGuoiO();
	public void clickDatPhongCoNGuoiDat();
	public void clickDatPhongSanDung();
	
	public void datPhongThatBaiThongTinTrong();
	public void datPhongThanhCong(KhachHangDatPhong khachHangDatPhong);

}
