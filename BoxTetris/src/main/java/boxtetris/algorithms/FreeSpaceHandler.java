package boxtetris.algorithms;

import java.util.Comparator;

import boxtetris.collections.MyCollections;
import boxtetris.datastructures.MyList;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;

public class FreeSpaceHandler {

    private MyList<FreeSpace> freeSpaces;
    private Comparator<FreeSpace> freeSpaceSorter;

    private FreeSpace next;

    public FreeSpaceHandler(FreeSpace fSpace, Comparator<FreeSpace> freeSpaceSorter) {
        MyList<FreeSpace> freeSpace = new MyList<>();
        freeSpace.add(fSpace);
        fSpace.setOnFloor();
        this.freeSpaceSorter = freeSpaceSorter;
        this.next = fSpace;
    }

    /**
     * @return FreeSpace
     */
    public FreeSpace getFreeSpace() {
        MyCollections.sort(freeSpaces, freeSpaceSorter);
        this.next = freeSpaces.get(0);
        return next;
    }

    /**
     * @param layer
     * @return boolean
     */
    public boolean addCuboid(Layer layer) {
        if (layer.getLength() <= next.getLength() && layer.getWidth() <= next.getWidth()
                && layer.getHeight() <= next.getHeight()) {

            return true;
        }
        return false;
    }

    /**
     * @param layer
     */
    private void generateFreeSpaces(Layer layer) {
        if (next.isOnFloor()) {
            if (next.getLength() - layer.getLength() != 0) {
                FreeSpace front = new FreeSpace(next.getLength() - layer.getLength(), next.getWidth(),
                        next.getHeight());
                front.setOnFloor();
                freeSpaces.add(front);
            }
            if (next.getWidth() - layer.getWidth() != 0) {
                FreeSpace side = new FreeSpace(next.getLength(), next.getWidth() - layer.getWidth(), next.getHeight());
                side.setOnFloor();
                freeSpaces.add(side);
            }
        }
        if (next.getHeight() - layer.getHeight() != 0) {
            FreeSpace top = new FreeSpace(layer.getLength(), layer.getWidth(), layer.getHeight());
            freeSpaces.add(top);
        }
    }

}
