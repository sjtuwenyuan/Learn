package json.complete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * {"name":"wenyuan","age":26,"dog":{"colour":"white","type":"sa mo"}}
 * Created by Wen on 16/9/21.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Dog dog = new Dog();
        dog.setType("sa mo");
        dog.setColour("white");
        Dog dog1 = new Dog();
        dog.setType("sa mo");
        dog.setColour("white");
        Person wy = new Person();
        wy.setAge(26);
        wy.setNameForTest("wenyuan");
        wy.setDog(dog);

        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(wy);

        Person person = mapper.readValue("{\"namefortest\":\"wenyuan\",\"age\":26,\"dog\":{\"colour\":\"white\",\"type\":\"sa mo\"}}", Person.class);
        System.out.println(person);



    }
}
