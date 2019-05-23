package com.asiainfo;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * ��������NIO�ṩ�Ĵ����ļ�����ͨ��һ��ʹ�ã��洢����
 * buffer��
 * ByteBuffer,LongBuffer,IntegerBuffer,FloatBuffer,DoubleBuffer
 * BooleanBuffer��û�е� 
 * ByteBuffer�õ����
 * @author cuipeng
 * @date 2018��9��25�� ����5:18:44
 * @version 1.0
 * @description
 */
public class Buffer {
	
	/**
	 * ���Ĳ�����
	 *  mark 
    	position  ���������ڲ�����λ��
    	limit   ���棨���������ô�С��
    	capacity  ���ã����������������һ�����������ɸı�
    	
    	���ķ�����
    	put()  ��buff�������
    	get()  ��ȡbuff������
	 */
	
	@Test
	public void test1() {// 1.ָ����������С1024
		ByteBuffer buf = ByteBuffer.allocate(1024);
		System.out.println("--------------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		// 2.�򻺳������5������
		buf.put("abcd1".getBytes());
		System.out.println("--------------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		// 3.������ģʽ
		buf.flip();
		System.out.println("----------������ģʽ...----------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		byte[] bytes = new byte[buf.limit()];
		buf.get(bytes);
		System.out.println(new String(bytes, 0, bytes.length));
		System.out.println("----------�ظ���ģʽ...----------");
		// 4.�����ظ���ģʽ
		buf.rewind();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		byte[] bytes2 = new byte[buf.limit()];
		buf.get(bytes2);
		System.out.println(new String(bytes2, 0, bytes2.length));
		// 5.clean ��ջ�����  ������Ȼ����,ֻ�������ݱ�����
		System.out.println("----------��ջ�����...----------");
		buf.clear();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		System.out.println((char)buf.get());
		
}
	
	
	@Test
	public void test2() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		byteBuffer.put("abcde".getBytes());
		//������ģʽ
		byteBuffer.flip();
		byteBuffer.mark();
		byte[] bytes = new byte[byteBuffer.limit()];
		byteBuffer.get(bytes,0,2);
		
		System.out.println(new String(bytes, 0, 2));
		System.out.println(byteBuffer.position());
		
		//byteBuffer.flip();
		byteBuffer.reset();
		byte[] bytes2 = new byte[byteBuffer.limit()];
		byteBuffer.get(bytes2,2,2);
		System.out.println(new String(bytes2,2, 2));
		byteBuffer.reset();

		System.out.println(byteBuffer.position());

	}
}
