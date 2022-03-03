package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KhachHangThuePhong extends KhachHang {
	private boolean status;
	private List<DichVu> listService;
	private double sumMoney;
	private Date checkOutDate;// ngay tra phong
	TinhTienPhong tienPhong = new TinhTienPhongThongThuong();
	TinhTienDichVu tienDichVu = new TinhTienDichVuKhachHang();

	public KhachHangThuePhong(String name, String room, String cMND, String note, String staff, String hotel,
			Date dateCreate, double priceRoom, int numberOfDays, double moneyPrepay, boolean status, double sumMoney,
			Date checkOutDate) {
		super(name, room, cMND, note, staff, hotel, dateCreate, priceRoom, numberOfDays, moneyPrepay);
		this.status = status;
		this.sumMoney = sumMoney;
		this.checkOutDate = checkOutDate;
		listService = new ArrayList<DichVu>();

	}
	public  long daysBetween2Dates(Date date1,Date date2) {
        // Định dạng thời gian
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        // Định nghĩa 2 mốc thời gian ban đầu
       

        c1.setTime(date1);
        c2.setTime(date2);

        // Công thức tính số ngày giữa 2 mốc thời gian:
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

       
        return noDay;

    }
	public double tinhTienPhong() {
		//this.sumMoney = tienPhong.tinhTienPhong(daysBetween2Dates(dateCreate, checkOutDate), priceRoom);
		return tienPhong.tinhTienPhong(daysBetween2Dates(dateCreate, checkOutDate), priceRoom,moneyPrepay);
	}
	public double tinhTienDichVu() {
		return tienDichVu.tienDichVu(listService);
	}

	
	public boolean isStatus() {
		return status;
	}
	
	public double tongTien() {
		return tinhTienDichVu()+tinhTienPhong();
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the listService
	 */
	public List<DichVu> getListService() {
		return listService;
	}

	/**
	 * @param listService the listService to set
	 */
	public void setListService(List<DichVu> listService) {
		this.listService = listService;
	}

	/**
	 * @return the sumMoney
	 */
	public double getSumMoney() {
		return sumMoney;
	}

	/**
	 * @param sumMoney the sumMoney to set
	 */
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public boolean addDichVu(DichVu dichVu) {
		for (int i = 0; i < listService.size(); i++) {
			if (dichVu.equals(listService.get(i))) {
				dichVu.setSoLuong(dichVu.getSoLuong() + listService.get(i).getSoLuong());
				listService.set(i, dichVu);
				return true;
			}
		}
		listService.add(dichVu);
		return false;
	}

	@Override
	public String toString() {
		return "KhachHangThuePhong [status=" + status + ", listService=" + listService + ", sumMoney=" + sumMoney
				+ ", checkOutDate=" + checkOutDate + "]";
	}

}
