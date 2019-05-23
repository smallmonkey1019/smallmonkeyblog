package com.asiainfo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 * @author cuipeng
 * @date 2018年9月11日 下午3:59:41
 * @version 1.0
 * @description
 */
class Res {
	
	public String userName;
	public String sex;
	public boolean flag = false;
	Lock lock = new ReentrantLock();
}

/**
 * 生产者
 * @author cuipeng
 * @date 2018年9月11日 下午3:59:30
 * @version 1.0
 * @description
 */
class Input extends Thread{
	
	Res res;
	Condition condition;
	public Input(Res res,Condition condition) {
		this.res = res;
		this.condition = condition;
	}
	@Override
	public void run() {
		int count = 0;
		
		while (true) {
				
				try {
					res.lock.lock();//开始上锁
					if (res.flag) {
						try {
							condition.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						}
					}
					if (count == 0) {
						res.userName = "小红";
						res.sex = "女";
					} else {
						res.userName = "小蓝";
						res.sex = "男";
					}
					//计算奇数偶数
					count = (count + 1) % 2;
					res.flag = true;
					condition.signal();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} finally {
					res.lock.unlock();
				}
		}
		
	}
}

/**
 * 消费者
 * @author cuipeng
 * @date 2018年9月11日 下午4:28:59
 * @version 1.0
 * @description
 */
class Out extends Thread {
	
	Res res;
	Condition condition;
	public Out(Res res,Condition condition) {
		this.res = res;
		this.condition = condition;
	}
	@Override
	public void run() {
		
		while (true) {
			
			try {
				res.lock.lock();//开始上锁
				if (!res.flag) {
					condition.await();
				}
				System.out.println(res.userName+":"+res.sex);
				res.flag = false;
				condition.signal();
			} catch (Exception e) {
				// TODO: handle exception
			} finally{
				res.lock.unlock();//释放锁
			}
		}
		
	}
}

public class OutInputThread {

	public static void main(String[] args) {
		Res res = new Res();
		Condition condition = res.lock.newCondition();
		Input input = new Input(res,condition);
		Out out = new Out(res,condition);
		input.start();
		out.start();
		
	}
}
