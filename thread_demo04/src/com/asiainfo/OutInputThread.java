package com.asiainfo;

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
				System.out.println("������ģʽ...");
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
				res.notify();
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
				System.out.println("������ģʽ...");
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
