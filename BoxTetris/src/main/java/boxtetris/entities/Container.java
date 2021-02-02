package boxtetris.entities;

public class Container {

    private Integer length;
    private Integer width;
    private Integer height;
    private Integer maxWeight;

    public Container(Integer lentgh, Integer width, Integer height, Integer maxWeight) {
        this.length = lentgh;
        this.width = width;
        this.height = height;
        this.maxWeight = maxWeight;
    }
    
    public Integer getLength() {
        return this.length;
    }

    public Integer getwidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public Integer getMaxWeight() {
        return this.maxWeight;
    }    
}