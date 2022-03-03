package model;

import java.util.List;

public class TinhTienDichVuKhachHang implements TinhTienDichVu{

	@Override
	public double tienDichVu(List<DichVu> listDV) {
		double sum =0;
		for (int i = 0; i < listDV.size(); i++) {
			sum += listDV.get(i).getGia()*listDV.get(i).getSoLuong();
		}
		return sum;
		
	}

}
