package view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.quanglinh.layout.custom.ImageButton;

import date_dialog.DatePickerDialog;
import date_dialog.OnclickItemDatePickerDialog;
import java.awt.CardLayout;
import java.awt.Font;

public class DialogKhachHangDatPhong extends JPanel {

	public JTextField textFieldThuePhong;
	public JTextField textFieldGia;
	public JTextField textFieldTenKhachhang;
	public JTextField textFieldNGuoiTao;
	public JTextField textFieldCMND;
	public int withTexfie = 100;
	public JSpinner soTienTraTruoc;
	public JSpinner soNgayDinhO;
	public JTextArea textAreaGhiChu;
	public ImageButton imageButtonChonNgay;
	public JLabel lbNgayDenO, lbNgayTao;

	public DialogKhachHangDatPhong() {
		setPreferredSize(new Dimension(430, 443));
		setLayout(new GridLayout(10, 1, 10, 10));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 380, 37);
		add(splitPane);

		JLabel lblNewLabel = new JLabel("Thu\u00EA ph\u00F2ng");
		splitPane.setLeftComponent(lblNewLabel);

		textFieldThuePhong = new JTextField();
		textFieldThuePhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		splitPane.setRightComponent(textFieldThuePhong);
		lblNewLabel.setPreferredSize(new Dimension(withTexfie, 25));
		textFieldThuePhong.setColumns(10);
		textFieldThuePhong.setEditable(false);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 37, 380, 37);
		add(splitPane_1);

		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1");
		splitPane_1.setLeftComponent(lblNewLabel_1);

		textFieldGia = new JTextField();
		textFieldGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		splitPane_1.setRightComponent(textFieldGia);
		lblNewLabel_1.setPreferredSize(new Dimension(withTexfie, 25));
		textFieldGia.setColumns(10);
		textFieldGia.setEditable(false);

		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setBounds(0, 74, 380, 37);
		add(splitPane_2);

		JLabel lnNgayTaoNos = new JLabel("Ng\u00E0y t\u1EA1o");
		splitPane_2.setLeftComponent(lnNgayTaoNos);
		lnNgayTaoNos.setPreferredSize(new Dimension(withTexfie, 25));

		JPanel panelNgayTao = new JPanel();
		splitPane_2.setRightComponent(panelNgayTao);
		panelNgayTao.setBounds(withTexfie, 0, 320, 37);
		panelNgayTao.setLayout(null);

		lbNgayTao = new JLabel(LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/"
				+ LocalDate.now().getYear());
		lbNgayTao.setBounds(0, 0, 253, 33);
		panelNgayTao.add(lbNgayTao);

		imageButtonChonNgay = new ImageButton(panelNgayTao);
		imageButtonChonNgay.layout_width(60);
		imageButtonChonNgay.layout_height(37);
		// imageButton.layout_marginRight(20);
		imageButtonChonNgay.layout_alignParentRight();
		imageButtonChonNgay.setSizeImage(30, 30, "img/outline_date_range_black_24dp.png");
		imageButtonChonNgay.setBackground(Color.white);

		imageButtonChonNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DatePickerDialog.create(Color.BLUE, DialogKhachHangDatPhong.this, new OnclickItemDatePickerDialog() {

					@Override
					public void onclick(int arg0, int arg1, int arg2) {
						lbNgayTao.setText(arg0 + "/" + arg1 + "/" + arg2);

					}
				});

			}
		});

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 148, 380, 37);
		add(splitPane_4);

		JLabel lblNewLabel_4 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		splitPane_4.setLeftComponent(lblNewLabel_4);

		textFieldTenKhachhang = new JTextField();
		splitPane_4.setRightComponent(textFieldTenKhachhang);
		textFieldTenKhachhang.setColumns(10);
		lblNewLabel_4.setPreferredSize(new Dimension(withTexfie, 25));

		JSplitPane splitPane_5 = new JSplitPane();
		splitPane_5.setBounds(0, 185, 380, 37);
		add(splitPane_5);

		JLabel lblNewLabel_5 = new JLabel("Ng\u01B0\u1EDDi t\u1EA1o");
		splitPane_5.setLeftComponent(lblNewLabel_5);

		textFieldNGuoiTao = new JTextField();
		splitPane_5.setRightComponent(textFieldNGuoiTao);
		textFieldNGuoiTao.setColumns(10);
		lblNewLabel_5.setPreferredSize(new Dimension(withTexfie, 25));

		JSplitPane splitPane_6 = new JSplitPane();
		splitPane_6.setBounds(0, 222, 380, 37);
		add(splitPane_6);

		JLabel lblNewLabel_6 = new JLabel("S\u1ED1 ng\u00E0y \u0111\u1ECBnh \u1EDF");
		splitPane_6.setLeftComponent(lblNewLabel_6);
		lblNewLabel_6.setPreferredSize(new Dimension(withTexfie, 25));

		soNgayDinhO = new JSpinner();
		soNgayDinhO.setModel(new SpinnerNumberModel(1, 0, 1000, 1));
		splitPane_6.setRightComponent(soNgayDinhO);

		JSplitPane splitPane_7 = new JSplitPane();
		splitPane_7.setBounds(0, 259, 380, 37);
		add(splitPane_7);

		JLabel lblNewLabel_7 = new JLabel("CMND/Passport");
		splitPane_7.setLeftComponent(lblNewLabel_7);

		textFieldCMND = new JTextField();
		splitPane_7.setRightComponent(textFieldCMND);
		textFieldCMND.setColumns(10);
		lblNewLabel_7.setPreferredSize(new Dimension(withTexfie, 25));
//
		JSplitPane splitPane_8 = new JSplitPane();
		splitPane_8.setBounds(0, 296, 380, 37);
		add(splitPane_8);

		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 ti\u1EC1n tr\u1EA3 tr\u01B0\u1EDBc");
		splitPane_8.setLeftComponent(lblNewLabel_3);
		lblNewLabel_3.setPreferredSize(new Dimension(withTexfie, 25));

		soTienTraTruoc = new JSpinner();
		soTienTraTruoc.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		splitPane_8.setRightComponent(soTienTraTruoc);

		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setBounds(0, 296 + 37, 380, 37);
		add(splitPane_10);

		JLabel lblNewLabel_10 = new JLabel("Ng\u00E0y \u0111\u1EBFn \u1EDF");
		splitPane_10.setLeftComponent(lblNewLabel_10);
		lblNewLabel_10.setPreferredSize(new Dimension(withTexfie, 25));

		JPanel panel = new JPanel();
		splitPane_10.setRightComponent(panel);
		panel.setLayout(null);
		panel.setBounds(withTexfie, 0, 320, 37);

		lbNgayDenO = new JLabel(LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/"
				+ LocalDate.now().getYear());
		lbNgayDenO.setBounds(0, 0, 253, 33);
		panel.add(lbNgayDenO);

		ImageButton imageButtonNgayDenO = new ImageButton(panel);
		imageButtonNgayDenO.layout_width(60);
		imageButtonNgayDenO.layout_height(37);
		// imageButton.layout_marginRight(20);
		imageButtonNgayDenO.layout_alignParentRight();
		imageButtonNgayDenO.setSizeImage(30, 30, "img/outline_date_range_black_24dp.png");
		imageButtonNgayDenO.setBackground(Color.white);

		imageButtonNgayDenO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DatePickerDialog.create(Color.BLUE, DialogKhachHangDatPhong.this, new OnclickItemDatePickerDialog() {

					@Override
					public void onclick(int arg0, int arg1, int arg2) {
						lbNgayDenO.setText(arg0 + "/" + arg1 + "/" + arg2);

					}
				});

			}
		});

		JSplitPane splitPane_9 = new JSplitPane();
		splitPane_9.setBounds(0, 296 + 37 + 37, 380, 37);
		add(splitPane_9);

		JLabel lblNewLabel_9 = new JLabel("Ghi ch\u00FA");
		splitPane_9.setLeftComponent(lblNewLabel_9);
		lblNewLabel_9.setPreferredSize(new Dimension(withTexfie, 25));

		textAreaGhiChu = new JTextArea();
		splitPane_9.setRightComponent(textAreaGhiChu);

	}

}
