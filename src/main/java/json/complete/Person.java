package json.complete;

/**
 * Created by Wen on 16/9/21.
 */
public class Person {
    private String nameForTest;
    private int age;
    private Dog dog;

    public String getNameForTest() {
        return nameForTest;
    }

    public void setNameForTest(String nameForTest) {
        this.nameForTest = nameForTest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameForTest='" + nameForTest + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
