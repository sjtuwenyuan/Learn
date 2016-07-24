package nettylearn.multhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class InboundHandler1 extends ChannelInboundHandlerAdapter {
//	private static Logger logger = Logger.getLogger(InboundHandler1.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		logger.info("InboundHandler1.channelRead: ctx :" + ctx);
		
		// 通知执行下一个InboundHandler
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		String resultStr = new String(result1);
		System.out.println("Inbound1 said:" + resultStr);
		result.release();
		System.out.println("come to inbound1");
        ByteBuf byteBuf =  ctx.alloc().buffer(result1.length);
        byteBuf.writeBytes(result1);
		ctx.fireChannelRead(byteBuf);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler1.channelReadComplete");
		ctx.flush();
	}
}