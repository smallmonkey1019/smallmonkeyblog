package com.java;

class createThread05 implements Runnable {
	//getId()  �߳�Id
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getId()+"���߳�:i = "+i);
		
		}
	}
}
/**
 * ʹ�ó��õ��߳�API
 * @author cuipeng
 * @date 2018��9��6�� ����7:50:44
 * @version 1.0
 * @description
 */
public class ThreadDemo03 {

	public static void main(String[] args) {
		
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println("�������߳�...");
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			System.out.println("�������߳�");
		}
		System.out.println("���߳�ִ�����!");
	}

	
}
