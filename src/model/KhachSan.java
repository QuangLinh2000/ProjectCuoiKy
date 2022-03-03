package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KhachSan {
	private String name;
	private int numberOfFloors;// so tang
	private int numberOfRooms;// so phong
	private String address;
	private String phone;
	private String email;
	private String note;
	private List<Phong> listRooms;
	private List<NhanVien> listStaff;
	private List<DichVu> listService;
	private List<KhachHangThuePhong> listCustomersRentingRooms;
	private List<KhachHangDatPhong> listCustomersMakeAReservation;
	private List<KhachHangQuenDo>  lisKhachHangQuenDos;

	public KhachSan(String name, int numberOfFloors, int numberOfRooms, String address, String phone, String email,
			String note) {
		this.name = name;
		this.numberOfFloors = numberOfFloors;
		this.numberOfRooms = numberOfRooms;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.note = note;
		listRooms = new ArrayList<Phong>();
		listStaff = new ArrayList<NhanVien>();
		listService = new ArrayList<DichVu>();
		listCustomersRentingRooms = new ArrayList<KhachHangThuePhong>();
		listCustomersMakeAReservation = new ArrayList<KhachHangDatPhong>();
		lisKhachHangQuenDos = new ArrayList<KhachHangQuenDo>();

	}
	public void setLisKhachHangQuenDos(List<KhachHangQuenDo> lisKhachHangQuenDos) {
		this.lisKhachHangQuenDos = lisKhachHangQuenDos;
	}
	public List<KhachHangQuenDo> getLisKhachHangQuenDos() {
		return lisKhachHangQuenDos;
	}
	
	public void themDoDeQuen(KhachHangQuenDo khachHangQuenDo) {
		lisKhachHangQuenDos.add(khachHangQuenDo);
	}
	public void xoaDoDequen(String tenPhong, String tenNguoiDeQUen) {
		for (KhachHangQuenDo khachHangQuenDo : lisKhachHangQuenDos) {
			if(khachHangQuenDo.getName().equals(tenNguoiDeQUen)&& khachHangQuenDo.getPhong().equals(tenPhong)) {
				lisKhachHangQuenDos.remove(khachHangQuenDo);
				return;
			}
		}
	}

	public void taoSoDoPhong() {
		int tenPhong = 101;
		int tang = 1;
		int soPhongMotTang = soPhongmotTang(numberOfFloors, numberOfRooms);
		int j = 0;
		for (int i = 1; i <= numberOfRooms; i++) {
			Phong phong = new Phong();
			phong.setName(tenPhong + "");
			phong.setGhiChu("");
			phong.setGia(200000);
			phong.setLoaiPhong("Phòng đơn");
			phong.setTang("Tầng " + tang);
			phong.setTrangThai("Sẵn dùng");
			tenPhong++;
			j++;
			if (soPhongMotTang == j) {
				j = 0;
				tang++;
			}
			listRooms.add(phong);
		}

	}

	public int soPhongmotTang(int tang, int phong) {
		if (phong % tang == 0) {
			return phong / tang;
		} else {
			return phong / tang + 1;
		}
	}

	public boolean editPhong(String name, Phong phong) {

		for (int i = 0; i < listRooms.size(); i++) {
			if (name.equals(listRooms.get(i).getName())) {
				// System.out.println(i);
				for (int j = 0; j < listRooms.size(); j++) {
					if (!name.equals(phong.getName()) && phong.getName().equalsIgnoreCase(listRooms.get(j).getName())) {
						return false;
					}
				}
				listRooms.set(i, phong);
				break;
			}
		}

		return true;
	}

	public boolean removePhong(String name) {
		for (int i = 0; i < listRooms.size(); i++) {
			if (name.equals(listRooms.get(i).getName())) {
				listRooms.get(i).setTrangThai("không có");
				return true;
			}
		}
		return false;
	}

	public Phong layPhong(String name) {
		for (Phong phong : listRooms) {
			if (name.equals(phong.getName())) {
				return phong;
			}
		}

		return listRooms.get(0);
	}

	public int layIndexPhong(String name) {
		for (int i = 0; i < listRooms.size(); i++) {
			if (name.equals(listRooms.get(i).getName())) {
				return i;
			}
		}

		return 0;
	}

	public boolean addNhanVien(NhanVien nhanVien) {
		for (NhanVien nv : listStaff) {
			if (nv.equals(nhanVien)) {
				return false;
			}
		}
		listStaff.add(nhanVien);
		return true;
	}

	public boolean removeNhanVien(String taiKhoan) {
		for (int i = 0; i < listStaff.size(); i++) {
			if (taiKhoan.equals(listStaff.get(i).getTaiKhoan())) {
				listStaff.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean editNhanVien(String taiKhoan, NhanVien nhanVien) {
		for (int i = 0; i < listStaff.size(); i++) {
			if (taiKhoan.equals(listStaff.get(i).getTaiKhoan())) {
				for (int j = 0; j < listStaff.size(); j++) {
					if (i != j && nhanVien.getTaiKhoan().equals(listStaff.get(j).getTaiKhoan())) {
						return false;
					}
				}
				listStaff.set(i, nhanVien);
				return true;
			}
		}
		return false;
	}

	public List<NhanVien> seacherNhanVien(String ten) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		for (NhanVien nhanVien : listStaff) {
			if (nhanVien.getName().equals(ten) || nhanVien.getTaiKhoan().equals(ten)) {
				list.add(nhanVien);
			}
		}
		return list;
	}

	public boolean addKhachHangDatPhong(KhachHangDatPhong khachHangDatPhong, String namePhong) {
		listCustomersMakeAReservation.add(khachHangDatPhong);
		for (Phong phon : listRooms) {
			if (phon.getName().equals(namePhong)) {
				phon.setTrangThai("Đã đặt");
				break;
			}
		}
		return true;
	}

	public boolean addKhachHangThuePhong(KhachHangThuePhong khachHang, String phong) {
		Phong phong2 = layPhong(phong);
		if (phong2.getTrangThai().equals("Đã đặt")) {
			if (congNgay(khachHang.getDateCreate(), khachHang.getNumberOfDays())
					.after(layNgayDenOCuaKhachHangDatPhong(phong))) {
				return false;
			} else {
				listCustomersRentingRooms.add(khachHang);
				for (Phong phon : listRooms) {
					if (phon.getName().equals(phong)) {
						phon.setTrangThai("Đang ở");
						return true;
					}
				}
				return true;
			}
		} else {
			listCustomersRentingRooms.add(khachHang);
			for (Phong phon : listRooms) {
				if (phon.getName().equals(phong)) {
					phon.setTrangThai("Đang ở");
					return true;
				}
			}
			return true;
		}
	}

	private Date layNgayDenOCuaKhachHangDatPhong(String tenPhong) {
		for (KhachHangDatPhong khachHangDatPhong : listCustomersMakeAReservation) {
			if (khachHangDatPhong.getRoom().equals(tenPhong)) {
				return khachHangDatPhong.getDateNgayDenO();
			}
		}
		return null;
	}

	private Date congNgay(Date date, int soNgayCong) {
		int day = date.getDate();
		int month = date.getMonth();
		int year = date.getYear() + 1900;
		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		c.add(Calendar.DAY_OF_YEAR, soNgayCong);
		Date d = c.getTime();
		return d;
	}

	public void khachHangTraPhong(String phong) {
		for (int i = 0; i < listCustomersRentingRooms.size(); i++) {
			if (listCustomersRentingRooms.get(i).getRoom().equals(phong)
					&& listCustomersRentingRooms.get(i).isStatus() == true) {
				listCustomersRentingRooms.get(i).setStatus(false);
				listRooms.get(layIndexPhong(listCustomersRentingRooms.get(i).getRoom())).setTrangThai("Sẵn dùng");
				return;
			}
		}
	}

	public int searcherKhachHangThuePhongIndext(String phong) {
		for (int i = 0; i < listCustomersRentingRooms.size(); i++) {
			if (listCustomersRentingRooms.get(i).getRoom().equals(phong)
					&& listCustomersRentingRooms.get(i).isStatus() == true) {
				return i;
			}
		}
		return 0;
	}

	public KhachHangThuePhong searcherKhachHangThuePhong(String phong) {
		for (int i = 0; i < listCustomersRentingRooms.size(); i++) {
			if (listCustomersRentingRooms.get(i).getRoom().equals(phong)
					&& listCustomersRentingRooms.get(i).isStatus() == true) {
				return listCustomersRentingRooms.get(i);
			}
		}
		return null;
	}

	public boolean khachHangDatDenO(String tenPhong) {
		Phong phong = layPhong(tenPhong);
		if (phong.getTrangThai().equals("Sẵn dùng")||phong.getTrangThai().equals("Đã đặt") ) {
			for (int i = 0; i < listCustomersMakeAReservation.size(); i++) {
				if (listCustomersMakeAReservation.get(i).getRoom().equals(tenPhong)) {
					KhachHangDatPhong kh = listCustomersMakeAReservation.get(i);
					listCustomersMakeAReservation.remove(i);

					String name = kh.getName();
					String room = kh.getRoom();
					String cMND = kh.getcMND();
					String note = kh.getNote();
					String staff = kh.getStaff();// ten
					String hotel = kh.getHotel();

					Date dateCreate = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
							LocalDateTime.now().getDayOfMonth());
					double priceRoom = kh.getPriceRoom();//
					int numberOfDays = kh.getNumberOfDays();//
					double moneyPrepay = kh.getMoneyPrepay();
					boolean status = true;

					double sumMoney = 0;
					Date checkOutDate = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
							LocalDateTime.now().getDayOfMonth());

					KhachHangThuePhong khachHangThuePhong = new KhachHangThuePhong(name, room, cMND, note, staff, hotel,
							dateCreate, priceRoom, numberOfDays, moneyPrepay, status, sumMoney, checkOutDate);
					listCustomersRentingRooms.add(khachHangThuePhong);
					for (Phong phon : listRooms) {
						if (phon.getName().equals(tenPhong)) {
							phon.setTrangThai("Đang ở");
							return true;
						}
					}

					break;
				}
			}
			return true;
		} else {
			return false;
		}

	}
	public void huyDatPhong(String tenPhong) {
		for (int i = 0; i < listCustomersMakeAReservation.size(); i++) {
			if(listCustomersMakeAReservation.get(i).getRoom().equals(tenPhong)) {
				listCustomersMakeAReservation.remove(i);
				for (Phong phon : listRooms) {
					if (phon.getName().equals(tenPhong)) {
						phon.setTrangThai("Sẵn dùng");
						break;
					}
				}

				return;
			}
			
		}
	}

	public void addDichVu(DichVu dichVu) {
		listService.add(dichVu);
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
	 * @return the numberOfFloors
	 */
	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	/**
	 * @param numberOfFloors the numberOfFloors to set
	 */
	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	/**
	 * @return the numberOfRooms
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the listRooms
	 */
	public List<Phong> getListRooms() {
		return listRooms;
	}

	/**
	 * @param listRooms the listRooms to set
	 */
	public void setListRooms(List<Phong> listRooms) {
		this.listRooms = listRooms;
	}

	/**
	 * @return the listStaff
	 */
	public List<NhanVien> getListStaff() {
		return listStaff;
	}

	/**
	 * @param listStaff the listStaff to set
	 */
	public void setListStaff(List<NhanVien> listStaff) {
		this.listStaff = listStaff;
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
	 * @return the listCustomersRentingRooms
	 */
	public List<KhachHangThuePhong> getListCustomersRentingRooms() {
		return listCustomersRentingRooms;
	}

	/**
	 * @param listCustomersRentingRooms the listCustomersRentingRooms to set
	 */
	public void setListCustomersRentingRooms(List<KhachHangThuePhong> listCustomersRentingRooms) {
		this.listCustomersRentingRooms = listCustomersRentingRooms;
	}

	/**
	 * @return the listCustomersMakeAReservation
	 */
	public List<KhachHangDatPhong> getListCustomersMakeAReservation() {
		return listCustomersMakeAReservation;
	}

	/**
	 * @param listCustomersMakeAReservation the listCustomersMakeAReservation to set
	 */
	public void setListCustomersMakeAReservation(List<KhachHangDatPhong> listCustomersMakeAReservation) {
		this.listCustomersMakeAReservation = listCustomersMakeAReservation;
	}

	@Override
	public String toString() {
		return "KhachSan [name=" + name + ", numberOfFloors=" + numberOfFloors + ", numberOfRooms=" + numberOfRooms
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", note=" + note + ", listRooms="
				+ listRooms + ", listStaff=" + listStaff + ", listService=" + listService
				+ ", listCustomersRentingRooms=" + listCustomersRentingRooms + ", listCustomersMakeAReservation="
				+ listCustomersMakeAReservation + "]";
	}

}
