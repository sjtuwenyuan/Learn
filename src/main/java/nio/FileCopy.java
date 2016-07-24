package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Wen on 16/7/23.
 */
public class FileCopy {
    public static void main(String[] args) throws Exception{
        String inFile = "infile.txt";
        String outFile = "outfile.txt";

        FileInputStream fis = new FileInputStream(FileCopy.class.getClassLoader().getResource(inFile).getPath());
        FileOutputStream fos = new FileOutputStream(FileCopy.class.getClassLoader().getResource("").getPath() + outFile);

        FileChannel fic = fis.getChannel();
        FileChannel foc = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.clear();
        while(fic.read(buf) > 0) {
            buf.flip();
            foc.write(buf);
            buf.clear();
        }
    }
}
