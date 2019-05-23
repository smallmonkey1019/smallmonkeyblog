package com.java;


/**
 * 守护线程与非守护线程
 * @author cuipeng
 * @date 2018年9月6日 下午7:50:44
 * @version 1.0
 * @description
 */
public class ThreadDemo04 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 30; i++) {
					
					System.out.println("子线程："+i);
				}
			}
		});
		t1.setDaemon(true);//设置守护线程
		t1.start();
		
		
		for (int i = 0; i < 30; i++) {
			System.out.println("主线程："+i);
		}
		System.out.println("主线程执行完毕.....");
	}
}
