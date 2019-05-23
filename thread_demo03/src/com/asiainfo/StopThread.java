package com.asiainfo;


class StopThreadDemo extends Thread {
	private boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println("子程序执行中...");
		}
	}
	
	public void stopThread() {
		this.flag = false;
	}
}
/**
 * 停止线程
 * @author cuipeng
 * @date 2018年9月12日 上午10:28:33
 * @version 1.0
 * @description
 */
public class StopThread {
	
	public static void main(String[] args) throws InterruptedException {
		/*StopThreadDemo stopThreadDemo = new StopThreadDemo();
		stopThreadDemo.start();*/
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程:"+i);
			if (i == 6) {
				Thread.interrupted();
			}
			
		}
	}

}
