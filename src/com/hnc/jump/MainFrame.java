package com.hnc.jump;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseListener {

	private ImagePanel imagePanel = null;
	private Point startPoint = new Point(); // 起点的坐标
	private Point endPoint = new Point(); // 终点的坐标
	private boolean isFirst = true; // 判断是否为第一次点击

	public MainFrame() {
		// 构建Frame
		imagePanel = new ImagePanel();
		add(imagePanel);
		setTitle("跳一跳");
		setSize(540, 960);
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().height / 2, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// 图片的鼠标点击事件
		imagePanel.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// 如果是第一次点击则为起点的坐标
		if (isFirst) {
			startPoint.x = event.getX();
			startPoint.y = event.getY();
			System.out.println("startPoint.x: " + startPoint.x + ", startPoint.y: " + startPoint.y);
			isFirst = false;
			return;
		}
		// 第二次点击为终点的坐标
		endPoint.x = event.getX();
		endPoint.y = event.getY();
		System.out.println("endPoint.x: " + endPoint.x + ", endPoint.y: " + endPoint.y);
		// 使用勾股定理计算跳跃的距离
		int distance = Utils.calDistance(startPoint, endPoint);
		// 距离除以长按的时间系数计算时间，根据实际情况调节系数
		int time = (int) (distance / 0.37);
		Utils.jump(time);
		System.out.println("distance: " + distance + ", time: " + time);
		// 等待截图需要的时间，根据实际情况调节
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 重新从起点开始
		isFirst = true;
		// 刷新面板
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
