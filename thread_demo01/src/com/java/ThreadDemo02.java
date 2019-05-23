package com.java;



/**
 * 创建多线程
 * @author cuipeng
 * @date 2018年9月6日 下午3:20:16
 * @version 1.0
 * @description
 */
public class ThreadDemo02 {

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
		
		//什么是匿名内部类
		//匿名内部类创建方式
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 30; i++) {
					System.out.println("子线程:i = "+i);
				}
			}
		});
		
		t1.start();
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程:i = "+i);
		}
	}
	
	
}
