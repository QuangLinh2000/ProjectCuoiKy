package view.dialog;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DialogChinhSuaPhong extends JPanel {
	public JTextField textFieldTenPhong;
	public JComboBox comTrangThai,comLoaiPhong;
	public JTextArea textAreaGhiChu;
	private String[] trangthai = {"Sẵn dùng","Cần Sửa chữa"};//"Đang ở","Đã đặt","không có"
    private String[] loaiPhong = {"Phòng đơn","Phòng đôi","phòng Đơn vip","phòng đôi vip"};
    public JSpinner spinnerGia;
	
	public DialogChinhSuaPhong() {
      
		setPreferredSize(new Dimension(300,240));
		setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 300, 25);
		add(splitPane);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn Ph\u00F2ng");
		splitPane.setLeftComponent(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(80,25));
		
		
		textFieldTenPhong = new JTextField();
		splitPane.setRightComponent(textFieldTenPhong);
		textFieldTenPhong.setColumns(10);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setBounds(0, 40, 300, 25);
		add(splitPane_3);
		
		JLabel lblNewLabel_2 = new JLabel("Lo\u1EA1i Ph\u00F2ng");
		splitPane_3.setLeftComponent(lblNewLabel_2);
		lblNewLabel_2.setPreferredSize(new Dimension(80,25));

		
	    comLoaiPhong = new JComboBox(loaiPhong);
		splitPane_3.setRightComponent(comLoaiPhong);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 80, 300, 25);
		add(splitPane_4);
		
		JLabel lblNewLabel_3 = new JLabel("Tr\u1EA1ng Th\u00E1i");
		splitPane_4.setLeftComponent(lblNewLabel_3);
		lblNewLabel_3.setPreferredSize(new Dimension(80,25));

		
		 comTrangThai = new JComboBox(trangthai);
		 
		splitPane_4.setRightComponent(comTrangThai);
		

		JSplitPane splitPaneGia = new JSplitPane();
		splitPaneGia.setBounds(0, 120, 300, 25);
		add(splitPaneGia);
		
		JLabel lblNewLabelGia = new JLabel("Giá");
		splitPaneGia.setLeftComponent(lblNewLabelGia);
		lblNewLabelGia.setPreferredSize(new Dimension(80,25));
		
		 spinnerGia = new JSpinner();
		spinnerGia.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		splitPaneGia.setRightComponent(spinnerGia);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(0, 160, 300, 80);
		add(splitPane_2);
		
		JLabel lblNewLabel_4 = new JLabel(" Ghi ch\u00FA");
		splitPane_2.setLeftComponent(lblNewLabel_4);
		lblNewLabel_4.setPreferredSize(new Dimension(80,25));

		
		 textAreaGhiChu = new JTextArea();
		splitPane_2.setRightComponent(textAreaGhiChu);

	}
	public int layIndexTrangThai(String name) {
		for (int i = 0; i < trangthai.length; i++) {
			if(name.equals(trangthai[i])) {
				return i;
			}
		}
		return 2;
	}
	public int layIndexLoaiPhong(String name) {
		for (int i = 0; i < loaiPhong.length; i++) {
			if(name.equals(loaiPhong[i])) {
				return i;
			}
		}
		return 3;
	}
}
