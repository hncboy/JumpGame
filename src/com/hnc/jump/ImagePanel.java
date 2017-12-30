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
			//����
			Utils.screen();
			//���ͼƬ��·��
			File imageFile = new File("D:\\jump.png");
			if (!imageFile.exists()) {
				imageFile.createNewFile();
			}
			image = ImageIO.read(imageFile);
			//����ͼƬ���ֻ�����Ϊ1920*1080
			g.drawImage(image, 0, 0, 540, 960, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
