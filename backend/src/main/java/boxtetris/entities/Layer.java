package boxtetris.entities;

public class Layer extends Dimensions {

    private final Integer weight;
    private final Integer amount;
    private final Cuboid cuboid;

    public Layer(Cuboid cuboid, Integer numberOfRows, Integer cuboidsInRow) {
        super(cuboid.getLength() * cuboidsInRow, cuboid.getWidth() * numberOfRows, cuboid.getHeight());
        this.cuboid = cuboid;
        this.amount = cuboidsInRow * numberOfRows;
        this.weight = cuboidsInRow * numberOfRows * cuboid.getWeight();
    }

    /**
     * @return Integer
     */
    public Integer getNumberOfCuboid() {
        return amount;
    }

    public void addLayersDemandToCuboid() {
        cuboid.addDemand(amount);
    }

    public void removeLayersDemandFromCuboid() {
        cuboid.removeDemand(amount);
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
     * @return String
     */
    @Override
    public String toString() {
        String returnString = "";
        returnString += "Cuboid: \n" + cuboid.toString() + "\n";
        returnString += "Layer length: " + getLength() + "\n";
        returnString += "Layer width: " + getWidth() + "\n";
        returnString += "Amount: " + getNumberOfCuboid();
        return returnString;
    }
}
