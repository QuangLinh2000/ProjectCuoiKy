package model;

import java.util.Date;

public abstract class KhachHang {
	protected String name;
	protected String room;
	protected String cMND;
	protected String note;
	protected String staff;// ten nhan vien
	protected String hotel;
	protected Date dateCreate;// ngay tao
	protected double priceRoom;// gia phong
	protected int numberOfDays;// so ngay dinh o
	protected double moneyPrepay;// so tien tra truoc

	public KhachHang(String name, String room, String cMND, String note, String staff, String hotel, Date dateCreate,
			double priceRoom, int numberOfDays, double moneyPrepay) {
		this.name = name;
		this.room = room;
		this.cMND = cMND;
		this.note = note;
		this.staff = staff;
		this.hotel = hotel;
		this.dateCreate = dateCreate;
		this.priceRoom = priceRoom;
		this.numberOfDays = numberOfDays;
		this.moneyPrepay = moneyPrepay;
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
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}




	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}




	/**
	 * @return the cMND
	 */
	public String getcMND() {
		return cMND;
	}




	/**
	 * @param cMND the cMND to set
	 */
	public void setcMND(String cMND) {
		this.cMND = cMND;
	}




	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}




	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}




	/**
	 * @return the staff
	 */
	public String getStaff() {
		return staff;
	}




	/**
	 * @param staff the staff to set
	 */
	public void setStaff(String staff) {
		this.staff = staff;
	}




	/**
	 * @return the hotel
	 */
	public String getHotel() {
		return hotel;
	}




	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}




	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}




	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}




	/**
	 * @return the priceRoom
	 */
	public double getPriceRoom() {
		return priceRoom;
	}




	/**
	 * @param priceRoom the priceRoom to set
	 */
	public void setPriceRoom(double priceRoom) {
		this.priceRoom = priceRoom;
	}




	/**
	 * @return the numberOfDays
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}




	/**
	 * @param numberOfDays the numberOfDays to set
	 */
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}




	/**
	 * @return the moneyPrepay
	 */
	public double getMoneyPrepay() {
		return moneyPrepay;
	}




	/**
	 * @param moneyPrepay the moneyPrepay to set
	 */
	public void setMoneyPrepay(double moneyPrepay) {
		this.moneyPrepay = moneyPrepay;
	}




	@Override
	public String toString() {
		return "KhachHang [name=" + name + ", room=" + room + ", cMND=" + cMND + ", note=" + note + ", staff=" + staff
				+ ", hotel=" + hotel + ", dateCreate=" + dateCreate + ", priceRoom=" + priceRoom + ", numberOfDays="
				+ numberOfDays + ", moneyPrepay=" + moneyPrepay + "]";
	}

}
