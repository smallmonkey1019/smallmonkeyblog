package com.java;


/**
 * �ػ��߳�����ػ��߳�
 * @author cuipeng
 * @date 2018��9��6�� ����7:50:44
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
					
					System.out.println("���̣߳�"+i);
				}
			}
		});
		t1.setDaemon(true);//�����ػ��߳�
		t1.start();
		
		
		for (int i = 0; i < 30; i++) {
			System.out.println("���̣߳�"+i);
		}
		System.out.println("���߳�ִ�����.....");
	}
}
