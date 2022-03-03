package controller.danhsachdichvu;

import model.DichVu;

public class ThemDichVuPresenter {
	IThemDichVuKhachSan themDichVu;

	public ThemDichVuPresenter(IThemDichVuKhachSan themDichVu) {
		this.themDichVu = themDichVu;
	}
	public void checkThemDichVu(DichVu dichVu) {
		if(dichVu.getGia() == 0 || dichVu.getTen().isEmpty()) {
			themDichVu.themDichVuThatBai();
		}else {
			themDichVu.themDichVuThanhCong(dichVu);
		}
	}

}
