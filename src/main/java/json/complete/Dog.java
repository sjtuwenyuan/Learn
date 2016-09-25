package json.complete;

/**
 * Created by Wen on 16/9/21.
 */
public class Dog {
    private String colour;
    private String type;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "colour='" + colour + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
