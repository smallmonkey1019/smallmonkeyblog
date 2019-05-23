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
		System.out.println("服务器端像客户端回复的内容..."+e.getMessage());
		
	}
	
}
/**
 * Netty客户端
 * 
 * @author cuipeng
 * @date 2018年10月2日 下午2:59:58
 * @version 1.0
 * @description
 */
public class NettyClient {

	public static void main(String[] args) {
		// 1.创建服务对象
		ClientBootstrap clientBootstrap = new ClientBootstrap();
		// 2.创建两个线程池 1.监听端口号 2.nio通讯监听
		ExecutorService boos = Executors.newCachedThreadPool();
		ExecutorService work = Executors.newCachedThreadPool();
		// 3.将线程池放入到工程中
		clientBootstrap.setFactory(new NioClientSocketChannelFactory(boos, work));
		// 4.设置管道工厂
		clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			// 设置管道
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline cp = Channels.pipeline();
				// 传输数据的时候直接为string类型
				cp.addLast("decoder", new StringDecoder());
				cp.addLast("encoder", new StringEncoder());
				// 设置事件监听类
				cp.addLast("clientHanlder", new serverHanlder());
				return cp;
			}
		});
		// 5.绑定端口号
		ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));
		System.out.println("客户端已经被启动...");
		Channel channel =  connect.getChannel();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("请输入内容：");
			channel.write(scanner.next());
		}
		
	}
}
