package com.java;


/**
 * ������  t1,t2,t3��˳��ִ��
 * @author cuipeng
 * @date 2018��9��6�� ����7:50:44
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
					
					System.out.println("���߳�t1��"+i);
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
					
					System.out.println("���߳�t2��"+i);
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
					
					System.out.println("���߳�t3��"+i);
				}
			}
		});
		t3.start();
		
		
	}
}
