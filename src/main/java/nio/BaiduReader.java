package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by Wen on 16/7/23.
 */
public class BaiduReader {
    private Charset charset = Charset.forName("GBK");
    private SocketChannel channel;

    public void readHTMLContent(){
        try {
            InetSocketAddress addr = new InetSocketAddress("www.baidu.com", 80);
            channel = SocketChannel.open(addr);
            channel.configureBlocking(false);
            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int counter = 0;
            while (counter ++ < 10000) {
                channel.read(buf);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print(charset.decode(buf));
                }
                buf.clear();
            }
            System.out.print(counter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new BaiduReader().readHTMLContent();
    }
}
