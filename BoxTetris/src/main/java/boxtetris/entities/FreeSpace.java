package boxtetris.entities;

public class FreeSpace extends Dimensions {

    private Coordinates coordinates;
    private boolean onFloor;

    public FreeSpace(Integer length, Integer width, Integer height, Coordinates coordinates) {
        super(length, width, height);
        this.coordinates = coordinates;
        this.onFloor = false;
    }

    public void setOnFloor() {
        this.onFloor = true;
    }

    /**
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
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (onFloor ? 1231 : 1237);
        return result;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
