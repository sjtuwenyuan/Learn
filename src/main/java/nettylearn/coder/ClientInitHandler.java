package nettylearn.coder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class ClientInitHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Person person = new Person();
        person.setName("yaokj");
        person.setSex("man");
        person.setAge(30);
        ctx.write(person);
        ctx.flush();
    }
}