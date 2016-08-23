package cn.itcast.netty.netty.level1.demo06;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

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
		// 解码器
		// 基于换行符号
		socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024)) ;
		// 基于指定字符串【换行符，这样功能等同于LineBasedFrameDecoder】
		// socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, false, Delimiters.lineDelimiter())) ;
		// 基于最大长度
		// socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(4)) ;
		// 解码转Sring
		socketChannel.pipeline().addLast(new StringDecoder()) ;
		// 编码器 String
		socketChannel.pipeline().addLast(new StringEncoder()) ;
		// 在管道中添加我们自己的接收数据实现方法
		socketChannel.pipeline().addLast(new MyServerHanlder());
		
	}
}
