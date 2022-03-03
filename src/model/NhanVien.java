package model;

public class NhanVien {
	// Object[] clum = { "Tài Khoản", "Họ Tên", "Mã Nhân viên", "Chức vụ", "Lương cơ
	// bản" };

	private String taiKhoan;
	private String name;
	private String maNhanVien;
	private String chucVu;
	private double luongCoban;

	public NhanVien(String taiKhoan, String name, String maNhanVien, String chucVu, double luongCoban) {
		this.taiKhoan = taiKhoan;
		this.name = name;
		this.maNhanVien = maNhanVien;
		this.chucVu = chucVu;
		this.luongCoban = luongCoban;
	}

	/**
	 * @return the taiKhoan
	 */
	public String getTaiKhoan() {
		return taiKhoan;
	}

	/**
	 * @param taiKhoan the taiKhoan to set
	 */
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
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
	 * @return the maNhanVien
	 */
	public String getMaNhanVien() {
		return maNhanVien;
	}

	/**
	 * @param maNhanVien the maNhanVien to set
	 */
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	/**
	 * @return the chucVu
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @param chucVu the chucVu to set
	 */
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	/**
	 * @return the luongCoban
	 */
	public double getLuongCoban() {
		return luongCoban;
	}

	/**
	 * @param luongCoban the luongCoban to set
	 */
	public void setLuongCoban(double luongCoban) {
		this.luongCoban = luongCoban;
	}

	@Override
	public String toString() {
		return "NhanVien [taiKhoan=" + taiKhoan + ", name=" + name + ", maNhanVien=" + maNhanVien + ", chucVu=" + chucVu
				+ ", luongCoban=" + luongCoban + "]";
	}

}
