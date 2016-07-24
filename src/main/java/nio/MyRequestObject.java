package nio;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Wen on 16/7/23.
 */
public class MyRequestObject implements Serializable{
    private static final long serialVersionUID = -1;
    private String name;
    private String value;
    private byte[] bytes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MyRequestObject(String name, String value) {
        this.name = name;
        this.value = value;
        this.bytes = new byte[1024];
    }

    @Override
    public String toString() {
        return "MyRequestObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", bytes=" + bytes.length +
                '}';
    }
}
