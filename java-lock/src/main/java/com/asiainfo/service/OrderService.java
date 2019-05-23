/**     
 * @�ļ�����: OrderService.java  
 * @��·��: com.asiainfo.service  
 * @����: TODO  
 * @���ߣ����� 
 * @ʱ�䣺2018��11��14�� ����4:16:50  
 * @�汾��V1.0     
 */  
package com.asiainfo.service;

import com.asiainfo.OrderNumGenerator;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018��11��14�� ����4:16:50
 * @version 1.0
 * @description 
 */
public class OrderService implements Runnable{
	
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	// ʹ��lock��
	// private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	private Lock lock = new ZookeeperDistrbuteLock();
	public void run() {
		getNumber();
	}
	public void getNumber() {
		try {
			lock.getLock();
			String number = orderNumGenerator.getNumber();
			System.out.println(Thread.currentThread().getName() + ",���ɶ���ID:" + number);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}
	public static void main(String[] args) {
		System.out.println("####����Ψһ������###");
//		OrderService orderService = new OrderService();
		for (int i = 0; i < 100; i++) {
			new Thread( new OrderService()).start();
		}
	}

}
