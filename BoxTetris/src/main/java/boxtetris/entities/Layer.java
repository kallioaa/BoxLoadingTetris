package boxtetris.entities;

public class Layer extends Dimensions {

    private Coordinates coordinates;
    private Integer weight;
    private Integer amount;
    private Cuboid cuboid;

    public Layer(Cuboid cuboid, Integer amount, Integer length, Integer width, Integer height, Integer weight) {
        super(length, width, height);
        this.cuboid = cuboid;
        this.amount = amount;
        this.weight = weight;
    }

    /**
     * @return Integer
     */
    public Integer getNumberOfCuboid() {
        return amount;
    }

    
    /** 
     * @return Cuboid
     */
    public Cuboid getCuboid() {
        return cuboid;
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
        return (double) weight / getArea();
    }

    /**
     * @return Double
     */
    public Double getWeightDivVolume() {
        return (double) weight / getVolume();
    }

    /**
     * @return Double
     */
    public Double getWeightDivHeight() {
        return (double) weight / getHeight();
    }

    /**
     * @return Double
     */
    public Double getHeightAndWeightDivArea() {
        return (double) (weight * getHeight()) / getArea();
    }

    
    /** 
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    
    /** 
     * @param coordinates
     */
    public void addCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
