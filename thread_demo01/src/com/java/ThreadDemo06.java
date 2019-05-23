package com.java;


class ThreadVolatileDemo extends Thread {
	
	public volatile boolean flag = true;
	@Override
	public void run() {
		System.out.println("���߳̿�ʼִ��....");
		while (flag) {
			
		}
		System.out.println("���߳̽���ִ��....");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

/**
 * Volatile
 * @author cuipeng
 * @date 2018��9��10�� ����10:02:33
 * @version 1.0
 * @description
 */
public class ThreadDemo06 {
	public static void main(String[] args) {
		ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
		threadVolatileDemo.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadVolatileDemo.setFlag(false);
		System.out.println("flagֵ�Ѿ��޸�Ϊfalse");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadVolatileDemo.flag);
	}
}
