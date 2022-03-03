package controller.themnhanvien;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.KhachSan;
import model.NhanVien;
import view.NhanVienActivity;
import view.dialog.DialogThemNhanVien;

public class ControllerNhanVien implements MouseListener {
	NhanVienActivity view;
	KhachSan khachSan;

	JPopupMenu popupMenu;
	JMenuItem mnChinhSu, mnxoaDichVu;
	JButton btnThem;
	DialogThemNhanVien dialogThemNhanVien;
	JTable table;
	DefaultTableModel model;

	public ControllerNhanVien(KhachSan khachSan) {
		this.khachSan = khachSan;
		view = new NhanVienActivity();

		initView();
		btnThem.addMouseListener(this);
		mnChinhSu.addMouseListener(this);
		mnxoaDichVu.addMouseListener(this);

	}

	private void initView() {
		popupMenu = view.popupMenu;
		mnChinhSu = view.mnChinhSu;
		mnxoaDichVu = view.mnxoaphong;
		btnThem = view.btnThem;
		model = view.model;
		table = view.table;
		dialogThemNhanVien = new DialogThemNhanVien();

	}

	public NhanVienActivity getView() {
		return view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (btnThem == e.getSource()) {
			showDialogThem();
		}
		if (mnChinhSu == e.getSource()) {

		}
		if (mnxoaDichVu == e.getSource()) {

		}

	}

	private void showDialogThem() {
		int result = JOptionPane.showConfirmDialog(view, dialogThemNhanVien, "Thêm Nhân viên",
				JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			String taiKhoan = dialogThemNhanVien.tfTaiKhoan.getText().trim();    
			String name = dialogThemNhanVien.tfTen.getText().trim();        
			String maNhanVien = dialogThemNhanVien.tfMaNhanVien.getText().trim();  
			String chucVu = dialogThemNhanVien.tfChucVu.getText().trim();      
			double luongCoban =(double)dialogThemNhanVien.spinnerTienLuong.getValue();
			NhanVien nhanVien = new NhanVien(taiKhoan, name, maNhanVien, chucVu, luongCoban);
			if(taiKhoan.isEmpty() || name.isEmpty() || maNhanVien.isEmpty()|| chucVu.isEmpty()|| luongCoban <= 0) {
				JOptionPane.showMessageDialog(view, "vui long dien day du thong tin");
				showDialogThem();
			}else {

				Object object[] = {taiKhoan,name,maNhanVien,chucVu,luongCoban};
				model.addRow(object);
				khachSan.addNhanVien(nhanVien);
				JOptionPane.showMessageDialog(view, "Thêm nhân viên thành công");
				addPopup(table, popupMenu);
				
			}
			
		}
		
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

}
