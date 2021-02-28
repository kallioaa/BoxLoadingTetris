package boxtetris.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cuboid extends Dimensions {

    private final String name;
    private final Integer weight;
    private Integer demand;

    public Cuboid(@JsonProperty("name") String name, @JsonProperty("length") Integer length,
            @JsonProperty("width") Integer width, @JsonProperty("height") Integer height,
            @JsonProperty("weight") Integer weight, @JsonProperty("demand") Integer demand) {
        super(length, width, height);
        this.name = name;
        this.weight = weight;
        this.demand = demand;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return Integer
     */
    public Integer getDemand() {
        return demand;
    }

    
    /** 
     * @param removed
     */
    public void removeDemand(Integer removed) {
        Integer newDemand = demand - removed;
        demand = newDemand;
    }

    
    /** 
     * @param added
     */
    public void addDemand(Integer added) {
        Integer newDemand = demand + added;
        demand = newDemand;
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