package com.asiainfo;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Qeque {
	
	public static void main(String[] args) {
		//�޽緽ʽ  ���޽��д洢
		ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
		concurrentLinkedDeque.offer("����");
		concurrentLinkedDeque.offer("����");
		System.out.println(concurrentLinkedDeque.size());
		System.out.println(concurrentLinkedDeque.peek());
		System.out.println(concurrentLinkedDeque.poll());
		System.out.println(concurrentLinkedDeque.size());
	}

}
