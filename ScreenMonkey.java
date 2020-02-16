/*
build on jdk-12.0.1
 */

package screenIt;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ScreenMonkey extends JFrame {
	String filePath = "C:\\Users\\slib\\Downloads\\1";
	Robot rob;
	int count = 0;
	
	public ScreenMonkey() throws AWTException {
		//getContentPane().setLayout(new FlowLayout());
		rob = new Robot();
		setFocusable(true);
		setAlwaysOnTop(true);
		setSize(200,50);
		setDefaultCloseOperation(3);
		//setOpacity(0.5f);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == 81) {
					try {
						saveScreen();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}				
			}			
		});
	}
	
	private void saveScreen() throws IOException {		
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) dm.getWidth();
		int h = (int) dm.getHeight();
		BufferedImage img = rob.createScreenCapture(new Rectangle(0,0, w,h));
		ImageIO.write(img, "PNG", new File(filePath + count +".png"));
		count++;			
	}	
	
	public static void main(String[] args) throws AWTException {
		ScreenMonkey sm = new ScreenMonkey();
		sm.setVisible(true);		
	}
}
