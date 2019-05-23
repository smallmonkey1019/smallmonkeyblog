package com.asiainfo;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;


class clientHanlder extends SimpleChannelHandler {
	
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed...");

	}
	
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected...");

	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught...");

	}
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		System.out.println("messageReceived...");
		System.out.println("����������ͻ��˻ظ�������..."+e.getMessage());
		
	}
	
}
/**
 * Netty�ͻ���
 * 
 * @author cuipeng
 * @date 2018��10��2�� ����2:59:58
 * @version 1.0
 * @description
 */
public class NettyClient {

	public static void main(String[] args) {
		// 1.�����������
		ClientBootstrap clientBootstrap = new ClientBootstrap();
		// 2.���������̳߳� 1.�����˿ں� 2.nioͨѶ����
		ExecutorService boos = Executors.newCachedThreadPool();
		ExecutorService work = Executors.newCachedThreadPool();
		// 3.���̳߳ط��뵽������
		clientBootstrap.setFactory(new NioClientSocketChannelFactory(boos, work));
		// 4.���ùܵ�����
		clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			// ���ùܵ�
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline cp = Channels.pipeline();
				// �������ݵ�ʱ��ֱ��Ϊstring����
				cp.addLast("decoder", new StringDecoder());
				cp.addLast("encoder", new StringEncoder());
				// �����¼�������
				cp.addLast("clientHanlder", new serverHanlder());
				return cp;
			}
		});
		// 5.�󶨶˿ں�
		ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));
		System.out.println("�ͻ����Ѿ�������...");
		Channel channel =  connect.getChannel();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("���������ݣ�");
			channel.write(scanner.next());
		}
		
	}
}
