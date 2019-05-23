package com.asiainfo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

class ServerHandler extends ChannelHandlerAdapter {
	
	/**
	 * ��ͨ�������ã�ִ�з���
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// ��������
		String value = (String) msg;
		System.out.println("Server msg:" + value);
		// �ظ����ͻ��� ������!��
		String res = "�õ�...";
		ctx.writeAndFlush(Unpooled.copiedBuffer(res.getBytes()));
	}

}

public class NettyServer {

	public static void main(String[] args) throws Exception {
		System.out.println("������������....");
		// 1.���������̳߳�
		NioEventLoopGroup pGroup = new NioEventLoopGroup();
		NioEventLoopGroup cGroup = new NioEventLoopGroup();
		// 2.����������
		ServerBootstrap b = new ServerBootstrap();
		b.group(pGroup, cGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 1024)
				// 3.���û������뷢������С
				.option(ChannelOption.SO_SNDBUF, 32 * 1024)
				.option(ChannelOption.SO_RCVBUF, 32 * 1024)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel sc)
							throws Exception {
						ByteBuf buf = Unpooled.copiedBuffer("_mayi".getBytes());
						sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));

						sc.pipeline().addLast(new StringDecoder());
						sc.pipeline().addLast(new ServerHandler());
					}
				});
		ChannelFuture cf = b.bind(8080).sync();
		cf.channel().closeFuture().sync();
		pGroup.shutdownGracefully();
		cGroup.shutdownGracefully();

	}

}
