package com.asiainfo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

class ClientHandler extends ChannelHandlerAdapter {

	/**
	 * 当通道被调用,执行该方法
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 接收数据
		String value = (String) msg;
		System.out.println("client msg:" + value);
	}

	
}


public class NettyClient {

	
	public static void main(String[] args) throws Exception {
		System.out.println("客户端已经启动....");
		// 创建负责接收客户端连接
		NioEventLoopGroup pGroup = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(pGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				ByteBuf buf = Unpooled.copiedBuffer("_mayi".getBytes());
				sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));

				sc.pipeline().addLast(new StringDecoder());
				sc.pipeline().addLast(new ClientHandler());
			}
		});
		ChannelFuture cf = b.connect("127.0.0.1", 8080).sync();
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("你好".getBytes()));
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("_mayi我是小明".getBytes()));
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("_mayi我23了".getBytes()));
		/*Thread.sleep(1000);*/
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("_mayi我是小红".getBytes()));
		cf.channel().writeAndFlush(Unpooled.wrappedBuffer("_mayi我27了".getBytes()));

		// 等待客户端端口号关闭
		cf.channel().closeFuture().sync();
		pGroup.shutdownGracefully();

	}
}
