package view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.quanglinh.layout.custom.ImageButton;

import date_dialog.DatePickerDialog;
import date_dialog.OnclickItemDatePickerDialog;

public class DialogKhachHangQuenDo extends JPanel {
	public JTextField tfTen;
	public JTextField tfDoDeQuen;
	public JTextField tfPhong;
	public JTextField textFieldNGuoiTao;
	public int withTexfie = 100;
	public JTextArea textAreaGhiChu;
    public JLabel lbNgayTao;
	public DialogKhachHangQuenDo() {

		setPreferredSize(new Dimension(430, 300));
		setLayout(new GridLayout(6, 1, 10, 10));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 380, 37);
		add(splitPane);

		JLabel lblNewLabel = new JLabel("T\u00EAn Kh\u00E1ch H\u00E0ng");
		splitPane.setLeftComponent(lblNewLabel);

		tfTen = new JTextField();
		splitPane.setRightComponent(tfTen);
		lblNewLabel.setPreferredSize(new Dimension(withTexfie, 25));
		tfTen.setColumns(10);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 37, 380, 37);
		add(splitPane_1);

		JLabel lblNewLabel_1 = new JLabel("\u0110\u1ED3 \u0111\u1EC3 qu\u00EAn");
		splitPane_1.setLeftComponent(lblNewLabel_1);

		tfDoDeQuen = new JTextField();
		splitPane_1.setRightComponent(tfDoDeQuen);
		lblNewLabel_1.setPreferredSize(new Dimension(withTexfie, 25));
		tfDoDeQuen.setColumns(10);

		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setBounds(0, 148, 380, 37);
		add(splitPane_4);

		JLabel lblNewLabel_4 = new JLabel("Ph\u00F2ng");
		splitPane_4.setLeftComponent(lblNewLabel_4);

		tfPhong = new JTextField();
		splitPane_4.setRightComponent(tfPhong);
		tfPhong.setColumns(10);
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

		JSplitPane splitPane_10 = new JSplitPane();
		splitPane_10.setBounds(0, 296 + 37, 380, 37);
		add(splitPane_10);

		JLabel lblNewLabel_10 = new JLabel("Ng\u00E0y T\u1EA1o");
		splitPane_10.setLeftComponent(lblNewLabel_10);
		lblNewLabel_10.setPreferredSize(new Dimension(withTexfie, 25));

		JPanel panel = new JPanel();
		splitPane_10.setRightComponent(panel);
		panel.setLayout(null);
		panel.setBounds(withTexfie, 0, 320, 37);

		 lbNgayTao = new JLabel(LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/"
					+ LocalDate.now().getYear());
		lbNgayTao.setBounds(0, 0, 253, 39);
		panel.add(lbNgayTao);

		ImageButton imageButtonChonNgay = new ImageButton(panel);
		imageButtonChonNgay.layout_width(60);
		imageButtonChonNgay.layout_height(37);
		// imageButton.layout_marginRight(20);
		imageButtonChonNgay.layout_alignParentRight();
		imageButtonChonNgay.setSizeImage(30, 30, "img/outline_date_range_black_24dp.png");
		imageButtonChonNgay.setBackground(Color.white);

		imageButtonChonNgay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DatePickerDialog.create(Color.BLUE, DialogKhachHangQuenDo.this, new OnclickItemDatePickerDialog() {

					@Override
					public void onclick(int arg0, int arg1, int arg2) {
						lbNgayTao.setText(arg0 + "/" + arg1 + "/" + arg2);

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
