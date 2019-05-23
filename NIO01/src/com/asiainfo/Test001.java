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

	//��ֱ�ӻ�����  ��һ����д�Ĳ���
	@Test
	public void test001() throws IOException {
		//������
		FileInputStream fst = new FileInputStream("1.png");
		//д����
		FileOutputStream fot = new FileOutputStream("2.png");
		//����������ͨ��
		FileChannel inChannel = fst.getChannel();
		//д��������ͨ��
		FileChannel outChannel = fot.getChannel();
		//����ָ����С������
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		while (inChannel.read(byteBuffer)!=-1) {
			//������ȡģʽ
			byteBuffer.flip();
			//�����ݶ�ȡ��ͨ����
			outChannel.write(byteBuffer);
			byteBuffer.clear();
		}
		//�ر�ͨ��
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
		// ӳ���ļ�
		MappedByteBuffer inMapperBuff = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMapperBuff = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		// ֱ�ӶԻ������������ݶ�д����
		byte[] dst = new byte[inMapperBuff.limit()];
		inMapperBuff.get(dst);
		outMapperBuff.put(dst);
		outChannel.close();
		inChannel.close();

	}
}
