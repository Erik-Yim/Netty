package cn.itcast.netty.netty.level1.demo02;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		System.out.println("报告");
		System.out.println("信息：有一客户端链接到本服务端");
		System.out.println("IP:"+socketChannel.localAddress().getHostName());
		System.out.println("Port:"+socketChannel.localAddress().getPort());
		System.out.println("报告完毕");
		
		//在管道中添加我们自己的接收数据实现方法
		socketChannel.pipeline().addLast(new MyServerHanlder());
	}
}
