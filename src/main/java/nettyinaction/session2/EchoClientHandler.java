package nettyinaction.session2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by Wen on 16/7/24.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    int i = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(Unpooled.copiedBuffer("hi yuanyuan!", CharsetUtil.UTF_8));
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        String resStr = new String(bytes);
        System.out.println("Server received: " + resStr);
//        if(i++ < 5)
//        {
//            ctx.write(Unpooled.copiedBuffer("hi yuanyuan!", CharsetUtil.UTF_8));
//            ctx.flush();
//        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}