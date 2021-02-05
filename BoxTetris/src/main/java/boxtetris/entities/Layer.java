package boxtetris.entities;

public class Layer extends Dimensions {

    private Integer weight;

    public Layer(Integer length, Integer width, Integer height, Integer weight) {
        super(length, width, height);
        this.weight = weight;
    }

    public Integer getArea() {
        return getLength() * getWidth();
    }

    public Integer getVolume() {
        return getLength() * getWidth() * getHeight();
    }

    public Integer getWeight() {
        return weight;
    }
}
