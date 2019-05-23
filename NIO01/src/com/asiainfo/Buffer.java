package com.asiainfo;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 缓冲区是NIO提供的传输文件，和通道一起使用，存储数据
 * buffer：
 * ByteBuffer,LongBuffer,IntegerBuffer,FloatBuffer,DoubleBuffer
 * BooleanBuffer是没有的 
 * ByteBuffer用的最多
 * @author cuipeng
 * @date 2018年9月25日 下午5:18:44
 * @version 1.0
 * @description
 */
public class Buffer {
	
	/**
	 * 核心参数：
	 *  mark 
    	position  缓冲区正在操作的位置
    	limit   界面（缓冲区可用大小）
    	capacity  作用：缓冲区最大容量，一旦声明，不可改变
    	
    	核心方法：
    	put()  往buff存放数据
    	get()  获取buff的数据
	 */
	
	@Test
	public void test1() {// 1.指定缓冲区大小1024
		ByteBuffer buf = ByteBuffer.allocate(1024);
		System.out.println("--------------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		// 2.向缓冲区存放5个数据
		buf.put("abcd1".getBytes());
		System.out.println("--------------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		// 3.开启读模式
		buf.flip();
		System.out.println("----------开启读模式...----------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		byte[] bytes = new byte[buf.limit()];
		buf.get(bytes);
		System.out.println(new String(bytes, 0, bytes.length));
		System.out.println("----------重复读模式...----------");
		// 4.开启重复读模式
		buf.rewind();
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		byte[] bytes2 = new byte[buf.limit()];
		buf.get(bytes2);
		System.out.println(new String(bytes2, 0, bytes2.length));
		// 5.clean 清空缓冲区  数据依然存在,只不过数据被遗忘
		System.out.println("----------清空缓冲区...----------");
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
		//开启读模式
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
