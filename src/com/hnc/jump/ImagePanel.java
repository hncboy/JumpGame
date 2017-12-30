package com.hnc.jump;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private Image image = null;
	
	@Override
	public void paint(Graphics g) {
		try {
			//截屏
			Utils.screen();
			//存放图片的路径
			File imageFile = new File("D:\\jump.png");
			if (!imageFile.exists()) {
				imageFile.createNewFile();
			}
			image = ImageIO.read(imageFile);
			//画出图片，手机像素为1920*1080
			g.drawImage(image, 0, 0, 540, 960, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
