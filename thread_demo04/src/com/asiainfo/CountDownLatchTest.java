package com.asiainfo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(0);
		System.out.println("我是主线程...");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("我是子线程，开始执行任务...");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();
				System.out.println("我是子线程，开始执行任务...");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("我是子线程，开始执行任务...");
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				countDownLatch.countDown();
				System.out.println("我是子线程，开始执行任务...");
			}
		}).start();
		try {
			countDownLatch.await(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("主线程开始执行任务...");
	}
}
