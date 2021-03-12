package boxtetris.entities;

/**
 * Class represents freespace
 */
public class FreeSpace extends Dimensions {

    private Coordinates coordinates;
    private boolean onFloor;

    public FreeSpace(Integer length, Integer width, Integer height, Coordinates coordinates) {
        super(length, width, height);
        this.coordinates = coordinates;
        this.onFloor = false;
    }

    /**
     * Means that the bottom side of the freespace is touching the
     */
    public void setOnFloor() {
        this.onFloor = true;
    }

    /**
     * Rerturn the xyz coordinates of tre freespace
     * 
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return boolean
     */
    public boolean isOnFloor() {
        return onFloor;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FreeSpace other = (FreeSpace) obj;
        if (onFloor != other.onFloor)
            return false;
        return true;
    }
}
