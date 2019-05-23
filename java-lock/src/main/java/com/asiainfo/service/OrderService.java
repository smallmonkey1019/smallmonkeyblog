/**     
 * @文件名称: OrderService.java  
 * @类路径: com.asiainfo.service  
 * @描述: TODO  
 * @作者：崔鹏 
 * @时间：2018年11月14日 下午4:16:50  
 * @版本：V1.0     
 */  
package com.asiainfo.service;

import com.asiainfo.OrderNumGenerator;

/**
 * @author cuipeng
 * @email cuipeng3@asiainfo.com
 * @date 2018年11月14日 下午4:16:50
 * @version 1.0
 * @description 
 */
public class OrderService implements Runnable{
	
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	// 使用lock锁
	// private java.util.concurrent.locks.Lock lock = new ReentrantLock();
	private Lock lock = new ZookeeperDistrbuteLock();
	public void run() {
		getNumber();
	}
	public void getNumber() {
		try {
			lock.getLock();
			String number = orderNumGenerator.getNumber();
			System.out.println(Thread.currentThread().getName() + ",生成订单ID:" + number);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
		}
	}
	public static void main(String[] args) {
		System.out.println("####生成唯一订单号###");
//		OrderService orderService = new OrderService();
		for (int i = 0; i < 100; i++) {
			new Thread( new OrderService()).start();
		}
	}

}
