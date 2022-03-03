package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HomeActivity extends JLabel {
    private int i = 0;
	public Timer time;
	public HomeActivity() {
		setBounds(230, 82, 844, 555);
		String urlHinhAnh[] = {"img/hinhanh2.png","img/hinhanh1.png","img/hinhanh3.png"};
		try {

			BufferedImage image = ImageIO.read(new File(urlHinhAnh[i]));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(844, 555, 1));
			setIcon(icon);
			i++;
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    time = new Timer(4000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					i++;
					if(i >= urlHinhAnh.length) {
						i=0;
					}
					BufferedImage image = ImageIO.read(new File(urlHinhAnh[i]));
					ImageIcon icon = new ImageIcon(image.getScaledInstance(844, 555, 1));
					setIcon(icon);
					
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
      time.start();
	}

}
