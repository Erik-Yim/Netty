package cn.itcast.netty.netty.level1.demo01;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * ClassName: ChildChannelHandler  
 * (监听连接)
 * @author zhangtian  
 * @version
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		System.out.println("报告");
		System.out.println("信息：有一客户端链接到本服务端");
		System.out.println("IP:"+socketChannel.localAddress().getHostName());
		System.out.println("Port:"+socketChannel.localAddress().getPort());
		System.out.println("报告完毕");
	}
}
