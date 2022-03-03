package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;

public class BaoCaoActivity extends JPanel  {
	private JLabel lblNewLabel_1;
	public JButton btnxuatBaocao;
	public JSpinner spinner;

	public BaoCaoActivity() {
		setBackground(new Color(230, 230, 250));
		setBounds(230, 82, 844, 555);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 844, 70);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh S\u00E1ch D\u1ECBch V\u1EE5 Kh\u00E1ch S\u1EA1n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 11, 327, 48);
		panel.add(lblNewLabel);


		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(286, 115, 295, 295);
		add(lblNewLabel_1);
		try {

			BufferedImage image = ImageIO.read(new File("img/excellicon.jpg"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(295, 295, 1));
			lblNewLabel_1.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnxuatBaocao = new JButton("Xu\u1EA5t b\u00E1o c\u00E1o");
		btnxuatBaocao.setBounds(470, 439, 128, 23);
		add(btnxuatBaocao);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(265, 437, 179, 25);
		add(splitPane);

		JLabel lblNewLabel_2 = new JLabel("Tháng");
		splitPane.setLeftComponent(lblNewLabel_2);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		splitPane.setRightComponent(spinner);

	}

	
}
