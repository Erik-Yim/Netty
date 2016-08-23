package cn.itcast.netty.netty.level1.client.demo02;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
	public static void main(String[] args) {
		try {
			new NettyClient().connect("192.168.1.102", 7397);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connect(String inetHost, int inetPort) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)// group 组
				.channel(NioSocketChannel.class)// channel 通道
				.option(ChannelOption.TCP_NODELAY, true)// option 选项
				.handler(new ChildChannelHandler()) ;// handler 处理
			
			// 发起异步链接
			ChannelFuture f = b.connect(inetHost, inetPort);
			// 等待客户端链路关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅关闭
			group.shutdownGracefully();
		}
	}
}
