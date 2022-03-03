package view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class HienThiChonDichVu extends JPanel {

	public JSpinner soLuong;
	public JLabel lbTenDichVu,lbGia;
	public HienThiChonDichVu() {
		setLayout(null);
		setPreferredSize(new Dimension(420, 35));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(30, 10, 420, 25);
		add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setRightComponent(splitPane_1);
		
		 lbGia = new JLabel("3450003 VND");
		splitPane_1.setLeftComponent(lbGia);
		
		 soLuong = new JSpinner();
		soLuong.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		splitPane_1.setRightComponent(soLuong);
		
		 lbTenDichVu = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		splitPane.setLeftComponent(lbTenDichVu);
		lbTenDichVu.setPreferredSize(new Dimension(100,25));
		lbGia.setPreferredSize(new Dimension(200,25));

	}
}
