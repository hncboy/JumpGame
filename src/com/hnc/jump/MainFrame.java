package com.hnc.jump;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {

	private ImagePanel imagePanel = null;
	private Point startPoint = new Point(); // ��������
	private Point endPoint = new Point(); // �յ������
	private boolean isFirst = true; // �ж��Ƿ�Ϊ��һ�ε��

	public MainFrame() {
		// ����Frame
		imagePanel = new ImagePanel();
		add(imagePanel);
		setTitle("��һ��");
		setSize(540, 960);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().height / 2, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// ͼƬ��������¼�
		imagePanel.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// ����ǵ�һ�ε����Ϊ��������
		if (isFirst) {
			startPoint.x = event.getX();
			startPoint.y = event.getY();
			System.out.println("startPoint.x: " + startPoint.x + ", startPoint.y: " + startPoint.y);
			isFirst = false;
			return;
		}
		// �ڶ��ε��Ϊ�յ������
		endPoint.x = event.getX();
		endPoint.y = event.getY();
		System.out.println("endPoint.x: " + endPoint.x + ", endPoint.y: " + endPoint.y);
		// ʹ�ù��ɶ��������Ծ�ľ���
		int distance = Utils.calDistance(startPoint, endPoint);
		// ������Գ�����ʱ��ϵ������ʱ�䣬����ʵ���������ϵ��
		int time = (int) (distance / 0.37);
		Utils.jump(time);
		System.out.println("distance: " + distance + ", time: " + time);
		// �ȴ���ͼ��Ҫ��ʱ�䣬����ʵ���������
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ���´���㿪ʼ
		isFirst = true;
		// ˢ�����
		imagePanel.validate();
		imagePanel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
