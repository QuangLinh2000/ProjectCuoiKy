package controller.sodokhachsan;

import model.Phong;

public class ThemDichVuKhachHangPresenter {
	IThemDichVu themDichVu;

	public ThemDichVuKhachHangPresenter(IThemDichVu themDichVu) {
		this.themDichVu = themDichVu;
	}
	public void checkShowDialogThemDichVu(Phong phong) {
		if(phong.getTrangThai().equals("Đang ở")) {
			themDichVu.clickThemDichVuCoNguoiThue();	
		}else {
			themDichVu.clickThemDichVuKhongCoNguoiThue();
		}
	}

}
