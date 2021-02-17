package boxtetris.entities;

public class Container extends Dimensions {

    private Integer maxWeight;
    private Integer currentWeight;

    public Container(Integer length, Integer width, Integer height, Integer maxWeight) {
        super(length, width, height);
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    /**
     * @return Integer
     */

    public boolean hasCapacity(Integer weight) {
        if (currentWeight + weight <= maxWeight) {
            return true;
        }
        return false;

    }

    /**
     * @param weight
     * @return boolean
     */
    public boolean addWeight(Integer weight) {
        if (currentWeight + weight <= maxWeight) {
            currentWeight += weight;
            return true;
        }
        return false;
    }

    /**
     * @return Integer
     */
    public Integer getMaxWeight() {
        return this.maxWeight;
    }
}