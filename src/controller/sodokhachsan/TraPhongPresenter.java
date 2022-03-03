package controller.sodokhachsan;

import javax.swing.JRadioButton;

import model.KhachHangThuePhong;
import model.Phong;

public class TraPhongPresenter {
	ItraPhong trItraPhong;

	public TraPhongPresenter(ItraPhong trItraPhong) {
		this.trItraPhong = trItraPhong;
	}
	public void click(Phong phong) {
		if(phong.getTrangThai().equals("Đang ở")) {
			trItraPhong.clickTraPhongCoNguoio();
		}else {
			trItraPhong.clickTraPhongKhongCoNGuoiO();
		}
	}
	public void traPhong(JRadioButton jRadioButton,KhachHangThuePhong khachHangThuePhong) {
		
		if(jRadioButton.isSelected()) {
			trItraPhong.traPhongInHoaDon(khachHangThuePhong);
		}else {
			trItraPhong.traPhongKhongInHoaDong(khachHangThuePhong);
		}
		
	}

}
