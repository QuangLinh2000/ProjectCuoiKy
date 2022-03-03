package controller.khachhangdatphong;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.sodokhachsan.SubjectKhachHangDatPhong;
import model.KhachHangDatPhong;
import model.KhachSan;
import view.KhachHangDatPhongActivity;

public class ControllerKhachHangDatPhong implements IKhachHangDatPhong, ActionListener, MouseListener {
	KhachHangDatPhongActivity view;
	KhachSan khachSan;
	DefaultTableModel model;
	JPopupMenu popupMenu;
	JTable table;
	JMenuItem mnThuePhong, mnxoaphong;

	SubjectKhachHangDatPhong subjectKhachHangDatPhong;
	Suject suject;

	public ControllerKhachHangDatPhong(KhachSan khachSan, SubjectKhachHangDatPhong subjectKhachHangDatPhong,
			Suject suject) {
		this.suject = suject;
		this.khachSan = khachSan;
		this.subjectKhachHangDatPhong = subjectKhachHangDatPhong;
		subjectKhachHangDatPhong.dangKy(this);
		view = new KhachHangDatPhongActivity();
		intitView();
		suKien();
	}

	private void suKien() {
		mnThuePhong.addMouseListener(this);
		mnxoaphong.addMouseListener(this);

	}

	private void intitView() {
		model = view.model;
		popupMenu = view.popupMenu;
		table = view.table;
		mnThuePhong = view.mnThuePhong;
		mnxoaphong = view.mnxoaphong;

	}

	public KhachHangDatPhongActivity getView() {
		return view;
	}

	@Override
	public void update(KhachHangDatPhong khachHangDatPhong) {
//		Object[] clum = {  "Khách hàng", "Đặt Ngày","Phòng", "Số Ngày","Trả Trước","Tạo bởi","Tạo Ngày" };
		Date date = khachHangDatPhong.getDateNgayDenO();
		Date date2 = khachHangDatPhong.getDateCreate();

		Object[] ob = { khachHangDatPhong.getName(), date.getDate() + "/" + date.getMonth() + "/" + date.getYear(),
				khachHangDatPhong.getRoom(), khachHangDatPhong.getNumberOfDays(), khachHangDatPhong.getMoneyPrepay(),
				khachHangDatPhong.getStaff(), date2.getDate() + "/" + date2.getMonth() + "/" + date2.getYear() };

		model.addRow(ob);
		addPopup(table, popupMenu);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == mnThuePhong) {
			int i = table.getSelectedRow();

			String tenPhong = String.valueOf(table.getValueAt(i, 2));
			if (khachSan.khachHangDatDenO(tenPhong)) {
				suject.updateDenO(tenPhong);
				model.removeRow(i);
			} else {
				JOptionPane.showMessageDialog(view, "có người đang ở");
			}
		}
		if (e.getSource() == mnxoaphong) {
			int i = table.getSelectedRow();

			String tenPhong = String.valueOf(table.getValueAt(i, 2));
			khachSan.huyDatPhong(tenPhong);
			suject.huyDatPhong(tenPhong);
			model.removeRow(i);
//			System.out.println(khachSan.getListCustomersMakeAReservation().size());

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
