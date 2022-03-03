package model;

import java.util.Date;

public class KhachHangQuenDo {
	//Khách hàng", "Để quên","Phòng", "Ghi chú","Tạo bởi","Ngày tao"
	private String name;
	private String tenDoDeQuen;
	private String phong;
	private String ghiChu;
	private String nhanVien;
	private Date ngayTao;
	
	public KhachHangQuenDo(String name, String tenDoDeQuen, String phong, String ghiChu, String nhanVien,
			Date ngayTao) {
		this.name = name;
		this.tenDoDeQuen = tenDoDeQuen;
		this.phong = phong;
		this.ghiChu = ghiChu;
		this.nhanVien = nhanVien;
		this.ngayTao = ngayTao;
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
	 * @return the tenDoDeQuen
	 */
	public String getTenDoDeQuen() {
		return tenDoDeQuen;
	}


	/**
	 * @param tenDoDeQuen the tenDoDeQuen to set
	 */
	public void setTenDoDeQuen(String tenDoDeQuen) {
		this.tenDoDeQuen = tenDoDeQuen;
	}


	/**
	 * @return the phong
	 */
	public String getPhong() {
		return phong;
	}


	/**
	 * @param phong the phong to set
	 */
	public void setPhong(String phong) {
		this.phong = phong;
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
	 * @return the nhanVien
	 */
	public String getNhanVien() {
		return nhanVien;
	}


	/**
	 * @param nhanVien the nhanVien to set
	 */
	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
	}


	/**
	 * @return the ngayTao
	 */
	public Date getNgayTao() {
		return ngayTao;
	}


	/**
	 * @param ngayTao the ngayTao to set
	 */
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}


	@Override
	public String toString() {
		return "KhachHangQuenDo [name=" + name + ", tenDoDeQuen=" + tenDoDeQuen + ", phong=" + phong + ", ghiChu="
				+ ghiChu + ", nhanVien=" + nhanVien + ", ngayTao=" + ngayTao + "]";
	}
	
	

}
