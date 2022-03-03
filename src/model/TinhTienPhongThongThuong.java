package model;

public class TinhTienPhongThongThuong implements TinhTienPhong {

	@Override
	public double tinhTienPhong(long soNgay,double giaPhong,double soTienTraTruoc) {
		if(soNgay == 0) {
			return giaPhong -  soTienTraTruoc;
		}else {
			return giaPhong*soNgay -  soTienTraTruoc;
		}
		
	}

}
