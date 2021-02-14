package boxtetris.entities;

public class Cuboid extends Dimensions {

    private static final int _0 = 0;
    private Integer weight;

    public Cuboid(Integer length, Integer width, Integer height, Integer weight) {
        super(length, width, height);
        this.weight = weight;
    }

    public void rotate() {
        Integer oldLength = getLength();
        setLength(getWidth());
        setWidth(oldLength);
    }

    /**
     * @return Integer
     */
    public Integer getWeight() {
        return weight;
    }
}