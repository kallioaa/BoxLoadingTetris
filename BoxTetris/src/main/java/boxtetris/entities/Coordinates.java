package boxtetris.entities;

public class Coordinates {

    private Integer x;
    private Integer y;
    private Integer z;

    public Coordinates(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    
    /** 
     * @return Integer
     */
    public Integer getX() {
        return x;
    }

    
    /** 
     * @return Integer
     */
    public Integer getY() {
        return y;
    }

    
    /** 
     * @return Integer
     */
    public Integer getZ() {
        return z;
    }

}