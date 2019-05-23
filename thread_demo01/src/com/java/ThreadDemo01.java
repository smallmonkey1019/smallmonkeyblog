package com.java;

/**
 * ʹ�ü̳�Thread�෽ʽ
 * @author cuipeng
 * @date 2018��9��6�� ����7:15:25
 * @version 1.0
 * @description
 */
class createThreadDemo01 extends Thread {
	
	/**
	 * �߳���Ҫִ�е�����
	 */
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("run:i = "+i);
		}
	}
}
/**
 * ʹ��ʵ��runable�ӿڷ�ʽ
 * @author cuipeng
 * @date 2018��9��6�� ����7:15:59
 * @version 1.0
 * @description
 */
class createThreadDemo02 implements Runnable {
	
	/**
	 * �߳���Ҫִ�е�����
	 */
	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println("���߳�:i = "+i);
		}
	}
}

/**
 * �������߳�
 * @author cuipeng
 * @date 2018��9��6�� ����3:20:16
 * @version 1.0
 * @description
 */
public class ThreadDemo01 {

	/**
	 * ���̣��������е�Ӧ�ó��򣬽������̵߳ļ���
	 * �̣߳��߳̾���һ��ִ��·����һ��������ִ�е�Ԫ
	 * ���̣߳�Ϊ����߳����Ч��
	 * �����̵߳ķ�ʽ��
	 * 1��ʹ�ü̳�Thread�෽ʽ
	 * 2��ʹ��ʵ��runable�ӿڷ�ʽ
	 * 3��ʹ�������ڲ��෽ʽ
	 * 4��callable��ʽ
	 * 5��ʹ���̳߳ش����߳�
	 */
	public static void main(String[] args) {
		//1�������߳�
		createThreadDemo02 t1 = new createThreadDemo02();
		Thread thread = new Thread(t1);
		thread.start();
		for (int i = 0; i < 30; i++) {
			System.out.println("���߳�:i = "+i);
		}
	}
	
	
}
