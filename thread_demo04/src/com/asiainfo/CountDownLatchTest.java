package com.asiainfo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(0);
		System.out.println("�������߳�...");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("�������̣߳���ʼִ������...");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();
				System.out.println("�������̣߳���ʼִ������...");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("�������̣߳���ʼִ������...");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();
				System.out.println("�������̣߳���ʼִ������...");
			}
		}).start();
		try {
			countDownLatch.await(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���߳̿�ʼִ������...");
	}
}
