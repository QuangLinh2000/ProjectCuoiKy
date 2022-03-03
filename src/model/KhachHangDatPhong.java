package model;

import java.util.Date;

public class KhachHangDatPhong extends KhachHang {
    private Date dateNgayDenO;

	public KhachHangDatPhong(String name, String room, String cMND, String note, String staff, String hotel,
			Date dateCreate, double priceRoom, int numberOfDays, double moneyPrepay, Date dateNgayDenO) {
		super(name, room, cMND, note, staff, hotel, dateCreate, priceRoom, numberOfDays, moneyPrepay);
		this.dateNgayDenO = dateNgayDenO;
	}

	/**
	 * @return the dateNgayDenO
	 */
	public Date getDateNgayDenO() {
		return dateNgayDenO;
	}

	/**
	 * @param dateNgayDenO the dateNgayDenO to set
	 */
	public void setDateNgayDenO(Date dateNgayDenO) {
		this.dateNgayDenO = dateNgayDenO;
	}
	
	
	
	
	

}
