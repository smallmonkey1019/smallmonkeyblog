package com.asiainfo;


class StopThreadDemo extends Thread {
	private boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println("�ӳ���ִ����...");
		}
	}
	
	public void stopThread() {
		this.flag = false;
	}
}
/**
 * ֹͣ�߳�
 * @author cuipeng
 * @date 2018��9��12�� ����10:28:33
 * @version 1.0
 * @description
 */
public class StopThread {
	
	public static void main(String[] args) throws InterruptedException {
		/*StopThreadDemo stopThreadDemo = new StopThreadDemo();
		stopThreadDemo.start();*/
		for (int i = 0; i < 10; i++) {
			System.out.println("���߳�:"+i);
			if (i == 6) {
				Thread.interrupted();
			}
			
		}
	}

}
