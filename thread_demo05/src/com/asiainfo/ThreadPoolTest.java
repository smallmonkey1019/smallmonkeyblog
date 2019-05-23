package com.asiainfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		//1、可缓存的线程池,重复利用
		/*ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int temp = i;
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("threadname:"+Thread.currentThread().getName()+"i:"+ temp);
				}
			});
		}*/
		
		//2、可固定长度的线程池
		/*ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			final int temp = i;
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("threadname:"+Thread.currentThread().getName()+"i:"+ temp);
				}
			});
		}*/
		
		//3、可定时线程池
		/*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int temp = i;
			
			executorService.schedule(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("threadname:"+Thread.currentThread().getName()+"i:"+ temp);
				}
			}, 3, TimeUnit.SECONDS);
		}*/
		//4、单线程池
		ScheduledExecutorService scheduledExecutorService =  Executors.newSingleThreadScheduledExecutor();
		for (int i = 0; i < 10; i++) {
			final int temp = i;
			
			scheduledExecutorService.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("threadname:"+Thread.currentThread().getName()+"i:"+ temp);
				}
			});
		}
		scheduledExecutorService.shutdown();
	}

}
