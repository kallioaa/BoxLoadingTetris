package boxtetris.entities;

public class Layer extends Dimensions {

    private Integer weight;

    public Layer(Integer length, Integer width, Integer height, Integer weight) {
        super(length, width, height);
        this.weight = weight;
    }

    /**
     * @return Integer
     */
    public Integer getArea() {
        return getLength() * getWidth();
    }

    /**
     * @return Integer
     */
    public Integer getVolume() {
        return getLength() * getWidth() * getHeight();
    }

    /**
     * @return Integer
     */
    public Integer getWeight() {
        return weight;
    }
}
