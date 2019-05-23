package com.asiainfo;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Qeque {
	
	public static void main(String[] args) {
		//无界方式  无限进行存储
		ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
		concurrentLinkedDeque.offer("张三");
		concurrentLinkedDeque.offer("李四");
		System.out.println(concurrentLinkedDeque.size());
		System.out.println(concurrentLinkedDeque.peek());
		System.out.println(concurrentLinkedDeque.poll());
		System.out.println(concurrentLinkedDeque.size());
	}

}
