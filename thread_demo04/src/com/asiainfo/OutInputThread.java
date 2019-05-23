package com.asiainfo;

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
	public Input(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		int count = 0;
		
		while (true) {
			synchronized (res) { 
				
				if (res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				System.out.println("生产者模式...");
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
				res.notify();
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
	public Out(Res res) {
		this.res = res;
	}
	@Override
	public void run() {
		
		while (true) {
			
			synchronized (res) {
				if (!res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				System.out.println("消费者模式...");
				System.out.println(res.userName+":"+res.sex);
				res.flag = false;
				res.notify();
				
			}
			
			
		}
		
	}
}

public class OutInputThread {

	public static void main(String[] args) {
		Res res = new Res();
		Input input = new Input(res);
		Out out = new Out(res);
		input.start();
		out.start();
		
	}
}
