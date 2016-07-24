package nettylearn.multhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;



public class OutboundHandler2 extends ChannelOutboundHandlerAdapter {

//	private static Logger logger = Logger.getLogger(OutboundHandler2.class);

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//		logger.info("OutboundHandler2.write");
		// 执行下一个OutboundHandler

		System.out.println("come to outbound2");
//		super.write(ctx, msg, promise);
        ByteBuf result = (ByteBuf) msg;
        byte[] result1 = new byte[result.readableBytes()];
        result.readBytes(result1);
        String resultStr = new String(result1);
        System.out.println(resultStr);
        ctx.write(msg);
	}
}