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
	
	//ͨ�����رյ�ʱ�򴥷�
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.channelClosed(ctx, e);
		System.out.println("channelClosed...");
	}
	
	//����Ҫȥ��������,ͨ�����ر�ʱ����
	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.channelDisconnected(ctx, e);
		System.out.println("channelDisconnected...");
	}
	
	//���ճ����쳣
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, e);
		System.out.println("exceptionCaught...");
	}
	//���տͻ�������
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(ctx, e);
		System.out.println("messageReceived...");
		System.out.println("�������˽��տͻ�������..."+e.getMessage());
		ctx.getChannel().write("��ð�");
	}
	
}

/**
 * netty��������
 * @author cuipeng
 * @date 2018��9��30�� ����3:24:28
 * @version 1.0
 * @description
 */
public class NettyServer {
	
	public static void main(String[] args) {
		//1.�����������
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		//2.���������̳߳�  1.�����˿ں�  2.nioͨѶ����
		ExecutorService boos = Executors.newCachedThreadPool();
		ExecutorService work = Executors.newCachedThreadPool();
		//3.���̳߳ط��뵽������
		serverBootstrap.setFactory(new NioServerSocketChannelFactory(boos, work));
		//4.���ùܵ�����
		serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			//���ùܵ�
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline cp = Channels.pipeline();
				//�������ݵ�ʱ��ֱ��Ϊstring����
				cp.addLast("decoder", new StringDecoder());
				cp.addLast("encoder", new StringEncoder());
				//�����¼�������
				cp.addLast("serverHanlder", new serverHanlder());
				return cp;
			}
		});
		//5.�󶨶˿ں�
		serverBootstrap.bind(new InetSocketAddress(8080));
		System.out.println("���������Ѿ�������...");
	}

}
