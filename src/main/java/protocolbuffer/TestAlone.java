package protocolbuffer;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by Wen on 16/7/26.
 */
public class TestAlone {
    public static void main(String[] args) {
        FirstProtobuf.testBuf.Builder builder = FirstProtobuf.testBuf.newBuilder();
        builder.setID(777);
        builder.addName("wenyuan");

        FirstProtobuf.testBuf info = builder.build();
        byte[] result = info.toByteArray();
        System.out.println(result.toString());
        TestAlone.getData(result);
    }
    public static void getData(byte[] result) {
        try {
            FirstProtobuf.testBuf testBuf = FirstProtobuf.testBuf.parseFrom(result);
            System.out.println(testBuf);
            System.out.println(FirstProtobuf.testBuf.PhoneType.HOME);//这里使用枚举
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
