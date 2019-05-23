package com.asiainfo;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

class serverHanlder extends SimpleChannelHandler {
	
	//通道被关闭的时候触发
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed...");
	}
	
	//必须要去建立连接,通道被关闭时触发
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected...");
	}
	
	//接收出现异常
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught...");
	}
	//接收客户端数据
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		System.out.println("messageReceived...");
		System.out.println("服务器端接收客户端内容..."+e.getMessage());
		ctx.getChannel().write("你好啊");
	}
	
}

/**
 * netty服务器端
 * @author cuipeng
 * @date 2018年9月30日 下午3:24:28
 * @version 1.0
 * @description
 */
public class NettyServer {
	
	public static void main(String[] args) {
		//1.创建服务对象
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		//2.创建两个线程池  1.监听端口号  2.nio通讯监听
		ExecutorService boos = Executors.newCachedThreadPool();
		ExecutorService work = Executors.newCachedThreadPool();
		//3.将线程池放入到工程中
		serverBootstrap.setFactory(new NioServerSocketChannelFactory(boos, work));
		//4.设置管道工厂
		serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			//设置管道
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline cp = Channels.pipeline();
				//传输数据的时候直接为string类型
				cp.addLast("decoder", new StringDecoder());
				cp.addLast("encoder", new StringEncoder());
				//设置事件监听类
				cp.addLast("serverHanlder", new serverHanlder());
				return cp;
			}
		});
		//5.绑定端口号
		serverBootstrap.bind(new InetSocketAddress(8080));
		System.out.println("服务器端已经被启动...");
	}

}
