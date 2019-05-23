package com.java;


class ThreadVolatileDemo extends Thread {
	
	public volatile boolean flag = true;
	@Override
	public void run() {
		System.out.println("子线程开始执行....");
		while (flag) {
			
		}
		System.out.println("子线程结束执行....");
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

/**
 * Volatile
 * @author cuipeng
 * @date 2018年9月10日 下午10:02:33
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
		System.out.println("flag值已经修改为false");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadVolatileDemo.flag);
	}
}
