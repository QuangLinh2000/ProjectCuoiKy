package controller.xuatbaocao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.KhachHangThuePhong;
import model.KhachSan;
import view.BaoCaoActivity;

public class ControllerXuatBaoCao implements ActionListener {
	BaoCaoActivity view;
	KhachSan khachSan;

	JButton btnxuatBaocao;
	JSpinner spinner;

	public ControllerXuatBaoCao(KhachSan khachSan) {
		this.khachSan = khachSan;
		view = new BaoCaoActivity();
		initView();
		suKien();
	}

	private void suKien() {
		btnxuatBaocao.addActionListener(this);

	}

	private void initView() {
		btnxuatBaocao = view.btnxuatBaocao;
		spinner = view.spinner;

	}

	public BaoCaoActivity getView() {
		return view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnxuatBaocao == e.getSource()) {
			suKienLick();
		}

	}

	private void suKienLick() {
		int month = (int) spinner.getValue();
		if (checkThangCoNguoiKhong(month)) {
			writerExel(khachSan.getListCustomersRentingRooms());
			JOptionPane.showMessageDialog(view, "Xuất báo cáo thành công");

		}else {
			JOptionPane.showMessageDialog(view, "không có người ở trong tháng này");
		}
	}

	public boolean checkThangCoNguoiKhong(int month) {
		for (KhachHangThuePhong khachHangThuePhong : khachSan.getListCustomersRentingRooms()) {

			if (khachHangThuePhong.getCheckOutDate().getMonth() == month && khachHangThuePhong.isStatus() == false) {
				return true;
			}

		}
		return false;
	}

	public void writerExel(List<KhachHangThuePhong> listDv) {

		try {
			File fil = new File("C:\\Users\\QUANGLINH\\Desktop\\" + "Báo Cáo" + ".xlsx");

			FileOutputStream file = new FileOutputStream(fil);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
			XSSFSheet xssfSheet = xssfWorkbook.createSheet("Báo Cáo");
			XSSFRow row;
			XSSFCell cellA;
			XSSFCell cellB;
			XSSFCell cellC;
			XSSFCell cellCTinhTien;
			XSSFCell cellCTinhTien2;

			row = xssfSheet.createRow(1);
			cellA = row.createCell(0);
			cellA.setCellValue("Phòng");

			cellB = row.createCell(1);
			cellB.setCellValue("Tên Khách Hàng");

			cellC = row.createCell(2);
			cellC.setCellValue("Ngày Lập");

			cellC = row.createCell(3);
			cellC.setCellValue("Người lập");

			cellC = row.createCell(4);
			cellC.setCellValue("Tổng Tiền");

			cellC = row.createCell(5);
			cellC.setCellValue("Khách sạn");

			cellC = row.createCell(6);
			cellC.setCellValue("Trạng thái");

			int so = 2;
			for (int i = 0; i < listDv.size(); i++) {
				row = xssfSheet.createRow(so);
				cellA = row.createCell(0);
				cellA.setCellValue(listDv.get(i).getRoom());

				cellB = row.createCell(1);
				cellB.setCellValue(listDv.get(i).getName());

				cellC = row.createCell(2);
				cellC.setCellValue(listDv.get(i).getDateCreate());

				cellC = row.createCell(3);
				cellC.setCellValue(listDv.get(i).getStaff());

				cellC = row.createCell(4);
				cellC.setCellValue(listDv.get(i).tongTien());

				cellC = row.createCell(5);
				cellC.setCellValue(listDv.get(i).getHotel());
				String trangthai = "đang ở";
				if (!listDv.get(i).isStatus()) {
					trangthai = "đã thanh toán";
				}
				cellC = row.createCell(6);
				cellC.setCellValue(trangthai);

				so++;
			}

			xssfWorkbook.write(file);
			xssfWorkbook.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
