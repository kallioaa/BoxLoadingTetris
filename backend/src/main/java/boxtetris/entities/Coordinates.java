package boxtetris.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {

    private Integer x;
    private Integer y;
    private Integer z;

    public Coordinates(@JsonProperty("x") Integer x, @JsonProperty("y") Integer y, @JsonProperty("z") Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @return Integer
     */
    public Integer getX() {
        return x;
    }

    /**
     * @return Integer
     */
    public Integer getY() {
        return y;
    }

    /**
     * @return Integer
     */
    public Integer getZ() {
        return z;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String returnString = "";
        returnString += "X: " + getX() + "\n";
        returnString += "Y: " + getY() + "\n";
        returnString += "Z: " + getZ();
        return returnString;
    }

}