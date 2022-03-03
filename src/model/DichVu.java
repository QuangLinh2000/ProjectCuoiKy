package model;


public class DichVu {
	private String ten;
	private double gia;
	private int soLuong;
	private String thongtin;
	public DichVu(String ten, double gia, int soLuong, String thongtin) {
		super();
		this.ten = ten;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thongtin = thongtin;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the gia
	 */
	public double getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(double gia) {
		this.gia = gia;
	}
	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	/**
	 * @return the thongtin
	 */
	public String getThongtin() {
		return thongtin;
	}
	/**
	 * @param thongtin the thongtin to set
	 */
	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}
	@Override
	public String toString() {
		return "DichVu [ten=" + ten + ", gia=" + gia + ", soLuong=" + soLuong + ", thongtin=" + thongtin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		result = prime * result + ((thongtin == null) ? 0 : thongtin.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		if (Double.doubleToLongBits(gia) != Double.doubleToLongBits(other.gia))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		if (thongtin == null) {
			if (other.thongtin != null)
				return false;
		} else if (!thongtin.equals(other.thongtin))
			return false;
		return true;
	}
	
	

	
	
	
	

}
