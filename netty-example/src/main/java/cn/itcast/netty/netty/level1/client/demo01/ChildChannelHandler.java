package cn.itcast.netty.netty.level1.client.demo01;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		System.out.println("客户端链接到服务端");
	}
}
