package model;

public class Phong {
	private String name;
	private String tang;
	private String loaiPhong;
	private String trangThai;
	private String ghiChu;
	private int gia;

	public Phong() {
		// TODO Auto-generated constructor stub
	}
	

	public Phong(String name, String tang, String loaiPhong, String trangThai, String ghiChu, int gia) {
		this.name = name;
		this.tang = tang;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
		this.gia = gia;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tang
	 */
	public String getTang() {
		return tang;
	}

	/**
	 * @param tang the tang to set
	 */
	public void setTang(String tang) {
		this.tang = tang;
	}

	/**
	 * @return the loaiPhong
	 */
	public String getLoaiPhong() {
		return loaiPhong;
	}

	/**
	 * @param loaiPhong the loaiPhong to set
	 */
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	/**
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	/**
	 * @return the ghiChu
	 */
	public String getGhiChu() {
		return ghiChu;
	}

	/**
	 * @param ghiChu the ghiChu to set
	 */
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	/**
	 * @return the gia
	 */
	public int getGia() {
		return gia;
	}

	/**
	 * @param gia the gia to set
	 */
	public void setGia(int gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "Phong [name=" + name + ", tang=" + tang + ", loaiPhong=" + loaiPhong + ", trangThai=" + trangThai
				+ ", ghiChu=" + ghiChu + ", gia=" + gia + "]";
	}
	

}
