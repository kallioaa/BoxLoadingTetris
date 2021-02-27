package boxtetris.entities;

public class Coordinates {

    private final Integer x;
    private final Integer y;
    private final Integer z;

    public Coordinates(Integer x, Integer y, Integer z) {
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