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
}
