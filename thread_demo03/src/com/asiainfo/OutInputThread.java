package com.asiainfo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������Դ
 * @author cuipeng
 * @date 2018��9��11�� ����3:59:41
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
 * ������
 * @author cuipeng
 * @date 2018��9��11�� ����3:59:30
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
					res.lock.lock();//��ʼ����
					if (res.flag) {
						try {
							condition.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
						}
					}
					if (count == 0) {
						res.userName = "С��";
						res.sex = "Ů";
					} else {
						res.userName = "С��";
						res.sex = "��";
					}
					//��������ż��
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
 * ������
 * @author cuipeng
 * @date 2018��9��11�� ����4:28:59
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
				res.lock.lock();//��ʼ����
				if (!res.flag) {
					condition.await();
				}
				System.out.println(res.userName+":"+res.sex);
				res.flag = false;
				condition.signal();
			} catch (Exception e) {
				// TODO: handle exception
			} finally{
				res.lock.unlock();//�ͷ���
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
