package com.asiainfo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Writer extends Thread {
	
	CyclicBarrier cyclicBarrier;
	Writer(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始写入数据");
		try {
			Thread.sleep(30);
			System.out.println(Thread.currentThread().getName()+"写入数据成功");
			try {
				cyclicBarrier.await();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"所有数据执行完毕");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
	}
}

public class CyclicBarrierTest {
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Writer(cyclicBarrier).start();
		}
	}

}
