package com.java;



/**
 * �������߳�
 * @author cuipeng
 * @date 2018��9��6�� ����3:20:16
 * @version 1.0
 * @description
 */
public class ThreadDemo02 {

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
		
		//ʲô�������ڲ���
		//�����ڲ��ഴ����ʽ
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 30; i++) {
					System.out.println("���߳�:i = "+i);
				}
			}
		});
		
		t1.start();
		for (int i = 0; i < 30; i++) {
			System.out.println("���߳�:i = "+i);
		}
	}
	
	
}
