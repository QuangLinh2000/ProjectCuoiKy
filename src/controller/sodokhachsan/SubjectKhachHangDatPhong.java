package controller.sodokhachsan;

import controller.danhsachhoadon.IHoaDonTraPhong;
import controller.khachhangdatphong.IKhachHangDatPhong;
import model.KhachHangDatPhong;
import model.KhachHangThuePhong;
import view.PanelSoDoKhachSan;

public interface SubjectKhachHangDatPhong {
	public void dangKy(IKhachHangDatPhong ob);
	public void update(KhachHangDatPhong khachHangDatPhong);
	
	public void dangKyKhachHangTraPhong(IHoaDonTraPhong ob);
	public void updateKhachHangTraPhong(KhachHangThuePhong khachHangThuePhong);
	public PanelSoDoKhachSan getSoDoKhachSan();
	

}
