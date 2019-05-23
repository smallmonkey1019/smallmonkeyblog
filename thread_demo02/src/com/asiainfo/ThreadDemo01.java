package com.asiainfo;

class ThreadTrial implements Runnable {
	
	private int trialCount = 100;
	private Object obj = new Object();
	@Override
	public void run() {
		while (trialCount>0) {
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ����Ʊ
			sale();
			
		}
		
	}
	
	public synchronized void sale() {
//		synchronized (obj) {
			if (trialCount==0) {
				return;
			}
			System.out.println(Thread.currentThread().getName()+"���۵�"+(100-trialCount+1)+"��Ʊ");
			trialCount--;
//		}
		
	}
}

/**
 * ��Ʊ��Ʊ
 * @author cuipeng
 * @date 2018��9��8�� ����3:40:32
 * @version 1.0
 * @description
 */
public class ThreadDemo01 {

	public static void main(String[] args) {
		ThreadTrial threadTrial = new ThreadTrial();
		Thread t1 = new Thread(threadTrial,"����1");
		Thread t2 = new Thread(threadTrial,"����2");
		t1.start();
		t2.start();
	}
}
