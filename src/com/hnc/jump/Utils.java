package com.hnc.jump;

import java.io.IOException;

//RunTime.getRuntime����.exec�������нű�������ܺ�����
public class Utils {
	// ������Ļʵ����Ծ
	public static void jump(int time) {
		try {
			//������Ļ��������ʼ����յ㶼�����Լ�Բ����ķ�Χ
			Runtime.getRuntime().exec("adb shell input swipe 170 187 170 187 " + time);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// �ֻ���Ļ��ͼ���ϴ���ͼ
	public static void screen() {
		try {
			Process p1 = Runtime.getRuntime().exec("adb shell screencap -p /sdcard/jump.png");
			p1.waitFor(); //ʹ��ǰ�̵߳ȴ���ֱ��Process����
			
			Process p2 = Runtime.getRuntime().exec("adb pull /sdcard/jump.png D:\\jump.png");
			p2.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���ݹ��ɶ����������֮��ľ���
	public static int calDistance(Point p1, Point p2) {
		return (int) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}
