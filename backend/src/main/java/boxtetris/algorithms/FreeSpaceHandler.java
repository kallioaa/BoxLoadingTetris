package boxtetris.algorithms;

import java.util.Comparator;

import boxtetris.collections.MyCollections;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Dimensions;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;

/**
 * Class serves freespaces and checks if a layer can be added to it.
 */

public class FreeSpaceHandler {

    private MyList<FreeSpace> freeSpaces;
    private Comparator<Dimensions> dimensionComparator;

    /**
     * @param dimensions          Dimensions of the original freespace
     * @param dimensionComparator Sorts the freespaces in a given order.
     */
    public FreeSpaceHandler(Dimensions dimensions, Comparator<Dimensions> dimensionComparator) {
        freeSpaces = new MyList<>();
        Coordinates origo = new Coordinates(0, 0, 0);
        FreeSpace fSpace = new FreeSpace(dimensions.getLength(), dimensions.getWidth(), dimensions.getHeight(), origo);
        fSpace.setOnFloor();
        freeSpaces.add(fSpace);
        this.dimensionComparator = dimensionComparator;
    }

    /**
     * Returns the number of freespaces.
     * 
     * @return Integer number of freespaces
     */
    public Integer getNumberOfFreeSpaces() {
        return freeSpaces.size();
    }

    /**
     * Returns the next "best" free space to use from a list of freespaces sorted by
     * dimensionComparators.
     * 
     * @return FreeSpace free space to be used next
     */
    public FreeSpace getFreeSpace() {
        if (freeSpaces.size() == 0) {
            return null;
        }
        MyCollections.sort(freeSpaces, dimensionComparator);
        return freeSpaces.get(0);
    }

    public void removeFreeSpace() {
        if (freeSpaces.size() > 0) {
            freeSpaces.remove(0);
        }
    }

    /**
     * When a new layer is to be added this function handles the generation or
     * prevents adding the layer.
     * 
     * @param layer
     * @return boolean
     */
    public Coordinates addLayer(Layer layer) {
        if (freeSpaces.size() > 0) {
            FreeSpace next = freeSpaces.get(0);
            if (layer.getLength() <= next.getLength() && layer.getWidth() <= next.getWidth()
                    && layer.getHeight() <= next.getHeight()) {
                generateFreeSpaces(layer);
                removeFreeSpace();
                return next.getCoordinates();
            }
            return null;
        }
        return null;
    }

    /**
     * @param layer
     */
    private void generateFreeSpaces(Layer layer) {
        if (freeSpaces.size() > 0) {
            FreeSpace next = freeSpaces.get(0);
            if (next.isOnFloor()) {
                if (next.getLength() - layer.getLength() > 0) {
                    Coordinates coordinates = new Coordinates(next.getCoordinates().getX() + layer.getLength(),
                            next.getCoordinates().getY(), next.getCoordinates().getZ());
                    FreeSpace front = new FreeSpace(next.getLength() - layer.getLength(), next.getWidth(),
                            next.getHeight(), coordinates);
                    front.setOnFloor();
                    freeSpaces.add(front);
                }
                if (next.getWidth() - layer.getWidth() > 0) {
                    Coordinates coordinates = new Coordinates(next.getCoordinates().getX(),
                            next.getCoordinates().getY() + layer.getWidth(), next.getCoordinates().getZ());
                    FreeSpace side = new FreeSpace(layer.getLength(), next.getWidth() - layer.getWidth(),
                            next.getHeight(), coordinates);
                    side.setOnFloor();
                    freeSpaces.add(side);
                }
            }
            if (next.getHeight() - layer.getHeight() > 0) {
                Coordinates coordinates = new Coordinates(next.getCoordinates().getX(), next.getCoordinates().getY(),
                        next.getCoordinates().getZ() + layer.getHeight());
                FreeSpace top = new FreeSpace(layer.getLength(), layer.getWidth(), next.getHeight() - layer.getHeight(),
                        coordinates);
                freeSpaces.add(top);
            }
        }
    }

}
