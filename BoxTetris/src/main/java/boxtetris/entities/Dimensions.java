package boxtetris.entities;

public abstract class Dimensions {

    private Integer length;
    private Integer width;
    private Integer height;

    public Dimensions(Integer length, Integer width, Integer height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * @param length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return Integer
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @return Integer
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @return Integer
     */
    public Integer getHeight() {
        return height;
    }
}
