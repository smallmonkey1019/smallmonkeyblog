package com.java;

/**
 * 使用继承Thread类方式
 * @author cuipeng
 * @date 2018年9月6日 下午7:15:25
 * @version 1.0
 * @description
 */
class createThreadDemo01 extends Thread {
	
	/**
	 * 线程需要执行的任务
	 */
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("run:i = "+i);
		}
	}
}
/**
 * 使用实现runable接口方式
 * @author cuipeng
 * @date 2018年9月6日 下午7:15:59
 * @version 1.0
 * @description
 */
class createThreadDemo02 implements Runnable {
	
	/**
	 * 线程需要执行的任务
	 */
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("子线程:i = "+i);
		}
	}
}

/**
 * 创建多线程
 * @author cuipeng
 * @date 2018年9月6日 下午3:20:16
 * @version 1.0
 * @description
 */
public class ThreadDemo01 {

	/**
	 * 进程：正在运行的应用程序，进程是线程的集合
	 * 线程：线程就是一条执行路径，一个独立的执行单元
	 * 多线程：为了提高程序的效率
	 * 创建线程的方式：
	 * 1、使用继承Thread类方式
	 * 2、使用实现runable接口方式
	 * 3、使用匿名内部类方式
	 * 4、callable方式
	 * 5、使用线程池创建线程
	 */
	public static void main(String[] args) {
		//1、调用线程
		createThreadDemo02 t1 = new createThreadDemo02();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程:i = "+i);
		}
	}
	
	
}
