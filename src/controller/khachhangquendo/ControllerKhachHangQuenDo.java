package controller.khachhangquendo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.math3.stat.ranking.NaNStrategy;

import model.KhachHangQuenDo;
import model.KhachSan;
import view.KhachHangQuenDoActivity;
import view.dialog.DialogKhachHangQuenDo;

public class ControllerKhachHangQuenDo implements MouseListener {
	KhachHangQuenDoActivity view;
	KhachSan khachSan;

	JTable table;
	DefaultTableModel model;
	JButton btnThem;
	DialogKhachHangQuenDo dialogKhachHangQuenDo;
	JPopupMenu popupMenu;
	JMenuItem mnTraDo;

	public ControllerKhachHangQuenDo(KhachSan khachSan) {
		this.khachSan = khachSan;
		view = new KhachHangQuenDoActivity();
		initView();
		btnThem.addMouseListener(this);
		mnTraDo.addMouseListener(this);
	}

	private void initView() {
		table = view.table;
		model = view.model;
		btnThem = view.btnThem;
		popupMenu = view.popupMenu;
		mnTraDo = view.mnTraDo;

		dialogKhachHangQuenDo = new DialogKhachHangQuenDo();

	}

	public KhachHangQuenDoActivity getView() {
		return view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == btnThem) {
			lickThem();
		}
		if(e.getSource() == mnTraDo) {
			int i = table.getSelectedRow();
			String ten = (String) table.getValueAt(i, 0);
			String tenPhong = (String) table.getValueAt(i, 2);

			khachSan.xoaDoDequen(tenPhong, ten);
			model.removeRow(i);

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

	private void lickThem() {
		showDiaLogThem();

	}

	public void showDiaLogThem() {
		dialogKhachHangQuenDo.textAreaGhiChu.setText("");
		dialogKhachHangQuenDo.textFieldNGuoiTao.setText("");
		dialogKhachHangQuenDo.tfDoDeQuen.setText("");
		dialogKhachHangQuenDo.tfPhong.setText("");
		dialogKhachHangQuenDo.tfTen.setText("");
		int result = JOptionPane.showConfirmDialog(view, dialogKhachHangQuenDo, "Khách hàng quên đồ",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			String name = dialogKhachHangQuenDo.tfTen.getText().trim();       
			String tenDoDeQuen = dialogKhachHangQuenDo.tfDoDeQuen.getText().trim();
			String phong = dialogKhachHangQuenDo.tfPhong.getText().trim();      
			String ghiChu = dialogKhachHangQuenDo.textAreaGhiChu.getText().trim();     
			String nhanVien= dialogKhachHangQuenDo.textFieldNGuoiTao.getText().trim(); 
			
			String da[] = dialogKhachHangQuenDo.lbNgayTao.getText().split("/");
			int ngay = Integer.parseInt(da[0]);
			int thang = Integer.parseInt(da[1]);
			int nam =Integer.parseInt(da[2]);
			Date ngayTao = new Date(nam, thang, ngay);   
			
			if(name.isEmpty() || tenDoDeQuen.isEmpty() || phong.isEmpty()|| nhanVien.isEmpty()) {
				JOptionPane.showMessageDialog(view, "vui long dien day du thong tin");
				showDiaLogThem();
			}else {
				KhachHangQuenDo khachHangQuenDo = new KhachHangQuenDo(name, tenDoDeQuen, phong, ghiChu, nhanVien, ngayTao);
				khachSan.themDoDeQuen(khachHangQuenDo);
				Object[] ob = {name,tenDoDeQuen,phong,ghiChu,nhanVien,ngay+"/"+thang+"/"+nam};
				model.addRow(ob);
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

}
