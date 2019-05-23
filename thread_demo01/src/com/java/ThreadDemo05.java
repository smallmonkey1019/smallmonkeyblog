package com.java;


/**
 * 面试题  t1,t2,t3按顺序执行
 * @author cuipeng
 * @date 2018年9月6日 下午7:50:44
 * @version 1.0
 * @description
 */
public class ThreadDemo05 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					
					System.out.println("子线程t1："+i);
				}
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					
					System.out.println("子线程t2："+i);
				}
			}
		});
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					
					System.out.println("子线程t3："+i);
				}
			}
		});
		t3.start();
		
		
	}
}
