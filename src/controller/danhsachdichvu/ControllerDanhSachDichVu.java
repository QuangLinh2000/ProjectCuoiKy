package controller.danhsachdichvu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.DichVu;
import model.KhachSan;
import view.DanhSachDichVuActivity;
import view.dialog.DialogThemDichVu;

public class ControllerDanhSachDichVu implements ActionListener,IThemDichVuKhachSan{
	KhachSan khachSan;
	DanhSachDichVuActivity view;
	
	private JTable table;
	private DefaultTableModel model;
	private JButton btnThemDichVu;
	
	DialogThemDichVu dialogThemDichVu;
	
	ThemDichVuPresenter themDichVuPresenter;
	
	public ControllerDanhSachDichVu(KhachSan khachSan) {
		this.khachSan = khachSan;
		view = new DanhSachDichVuActivity();
		themDichVuPresenter = new ThemDichVuPresenter(this);
		
		intitView();
		suKien();
		
		for (DichVu dichVu : khachSan.getListService()) {
			Object[] ob = {dichVu.getTen(),dichVu.getGia(),dichVu.getThongtin()};
			model.addRow(ob);
		}
	}
	private void suKien() {
		btnThemDichVu.addActionListener(this);
	}
	private void intitView() {
		table = view.table;
		model = view.model;
		btnThemDichVu = view.btnThemDichVu;
		
		dialogThemDichVu = new DialogThemDichVu();
		
	}
	public DanhSachDichVuActivity getView() {
		return view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnThemDichVu) {
			showDiaLogThemDichVu();
		}
		
	}
	public void showDiaLogThemDichVu() {
		
		dialogThemDichVu.textFieldTenDichVu.setText("");
		dialogThemDichVu.textFieldThongTinDichVu.setText("");
		
		int result = JOptionPane.showConfirmDialog(view, dialogThemDichVu, "Thêm Dịch Vụ",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String tenDV = dialogThemDichVu.textFieldTenDichVu.getText().trim();
			double gia = (double) dialogThemDichVu.spinnerGia.getValue();
			String thongtin = dialogThemDichVu.textFieldThongTinDichVu.getText().trim();
			DichVu dichVu = new DichVu(tenDV, gia, 1,thongtin);
			themDichVuPresenter.checkThemDichVu(dichVu);
		}
	}
	public void capNhatBang(DichVu dichVu) {
		Object[] ob = {dichVu.getTen(),dichVu.getGia(),dichVu.getThongtin()};
		model.addRow(ob);
	}
	@Override
	public void themDichVuThanhCong(DichVu dichVu) {
		khachSan.addDichVu(dichVu);
		capNhatBang(dichVu);
		
		
	}
	@Override
	public void themDichVuThatBai() {
		JOptionPane.showMessageDialog(view, "vui lòng nhập đầy đủ thông tin");
		showDiaLogThemDichVu();
		
	}
	

	
}
