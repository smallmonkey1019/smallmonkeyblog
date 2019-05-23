package com.asiainfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class Test001 {

	//非直接缓冲区  做一个读写的操作
	@Test
	public void test001() throws IOException {
		//读入流
		FileInputStream fst = new FileInputStream("1.png");
		//写入流
		FileOutputStream fot = new FileOutputStream("2.png");
		//读入流创建通道
		FileChannel inChannel = fst.getChannel();
		//写入流创建通道
		FileChannel outChannel = fot.getChannel();
		//分配指定大小缓冲区
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		while (inChannel.read(byteBuffer)!=-1) {
			//开启读取模式
			byteBuffer.flip();
			//将数据读取到通道中
			outChannel.write(byteBuffer);
			byteBuffer.clear();
		}
		//关闭通道
		inChannel.close();
		outChannel.close();
		fot.close();
		fst.close();
	}
	
	@Test
	public void test002() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.READ, StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);
		// 映射文件
		MappedByteBuffer inMapperBuff = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMapperBuff = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		// 直接对缓冲区进行数据读写操作
		byte[] dst = new byte[inMapperBuff.limit()];
		inMapperBuff.get(dst);
		outMapperBuff.put(dst);
		outChannel.close();
		inChannel.close();

	}
}
