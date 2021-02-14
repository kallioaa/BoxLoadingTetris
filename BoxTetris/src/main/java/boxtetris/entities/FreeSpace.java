package boxtetris.entities;

public class FreeSpace extends Dimensions {

    private boolean onFloor;

    public FreeSpace(Integer length, Integer width, Integer height) {
        super(length, width, height);
        this.onFloor = false;
    }

    public void setOnFloor() {
        this.onFloor = true;
    }

    /**
     * @return boolean
     */
    public boolean isOnFloor() {
        return onFloor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (onFloor ? 1231 : 1237);
        return result;
    }

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
