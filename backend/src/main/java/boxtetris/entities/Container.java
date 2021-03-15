package boxtetris.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing a container
 */
public class Container extends Dimensions {

    private final String name;
    private final Integer maxWeight;

    public Container(@JsonProperty("name") String name, @JsonProperty("length") Integer length,
            @JsonProperty("width") Integer width, @JsonProperty("height") Integer height,
            @JsonProperty("maxWeight") Integer maxWeight) {
        super(length, width, height);
        this.name = name;
        this.maxWeight = maxWeight;
    }

    /**
     * @return String name of the container
     */
    public String getName() {
        return name;
    }

    /**
     * @return Integer Max Weight of the container
     */
    public Integer getMaxWeight() {
        return this.maxWeight;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String returnString = "";
        returnString += "Name: " + getName() + "\n";
        returnString += super.toString();
        returnString += "Max weight: " + maxWeight + "\n";
        return returnString;

    }
}