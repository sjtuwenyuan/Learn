package nettyinaction.session2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Wen on 16/7/24.
 */

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf result = (ByteBuf)msg;
        byte[] bytes = new byte[result.readableBytes()];
        result.readBytes(bytes);
        String resStr = new String(bytes);
        System.out.println("Server received: " + resStr);

        String response = "hi huihui!";
        ByteBuf encode = ctx.alloc().buffer(4 * response.length());
        encode.writeBytes(response.getBytes());
        ctx.write(encode);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
//        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
