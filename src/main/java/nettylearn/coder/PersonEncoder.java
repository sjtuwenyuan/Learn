package nettylearn.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PersonEncoder extends MessageToByteEncoder<Person> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
		byte[] datas = ByteObjConverter.objectToByte(msg);
		out.writeBytes(datas);
		ctx.flush();
	}
}