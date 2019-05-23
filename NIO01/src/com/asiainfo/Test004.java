package com.asiainfo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class Test004 {

	public static void main(String[] args) throws IOException {
		//随机访问
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
		FileChannel channel = raf.getChannel();
		//分配指定缓冲区
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
		ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
		//分散读取
		ByteBuffer[] bufs = {byteBuffer1,byteBuffer2};
		channel.read(bufs);
		for (ByteBuffer byteBuffer : bufs) {
			//切换读模式
			byteBuffer.flip();
		}
		System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
		System.out.println("--------聚集写入-----------");
		RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(bufs);
		raf.close();
		raf2.close();
	}
}
