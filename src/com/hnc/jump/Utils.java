package com.hnc.jump;

import java.io.IOException;

//RunTime.getRuntime（）.exec（）运行脚本命令介绍和阻塞
public class Utils {
	// 触摸屏幕实现跳跃
	public static void jump(int time) {
		try {
			//滑动屏幕滑动的起始点和终点都是在自己圆柱体的范围
			Runtime.getRuntime().exec("adb shell input swipe 170 187 170 187 " + time);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 手机屏幕截图及上传截图
	public static void screen() {
		try {
			Process p1 = Runtime.getRuntime().exec("adb shell screencap -p /sdcard/jump.png");
			p1.waitFor(); //使当前线程等待，直到Process结束
			
			Process p2 = Runtime.getRuntime().exec("adb pull /sdcard/jump.png D:\\jump.png");
			p2.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 根据勾股定理计算两点之间的距离
	public static int calDistance(Point p1, Point p2) {
		return (int) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}
}
