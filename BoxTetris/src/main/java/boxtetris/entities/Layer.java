package boxtetris.entities;

public class Layer extends Dimensions {

    private Integer weight;
    private Integer amount;

    public Layer(Integer amount, Integer length, Integer width, Integer height, Integer weight) {
        super(length, width, height);
        this.amount = amount;
        this.weight = weight;
    }

    /**
     * @return Integer
     */
    public Integer getNumberOfCuboid() {
        return this.amount;
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

    /**
     * @return Double
     */
    public Double getWeightDivArea() {
        return (double) this.weight / this.getArea();
    }

    /**
     * @return Double
     */
    public Double getWeightDivVolume() {
        return (double) this.weight / this.getVolume();
    }

    /**
     * @return Double
     */
    public Double getWeightDivHeight() {
        return (double) this.weight / this.getHeight();
    }

    /**
     * @return Double
     */
    public Double getHeightAndWeightDivArea() {
        return (double) (this.weight * weight) / this.getArea();
    }

}
