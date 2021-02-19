package boxtetris.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Cuboid;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;

public class FreeSpaceHandlerTest {

    @Test
    public void firstSpaceIsCorrect() {
        Coordinates coordinate = new Coordinates(2, 2, 2);
        FreeSpace fSpace = new FreeSpace(15, 30, 5, coordinate);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        fSpace.setOnFloor();
        FreeSpace served = freeSpaceHandler.getFreeSpace();
        assertEquals(fSpace, served);
    }

    @Test
    public void nOfSpacesIsCorrect() {
        Cuboid cuboid = new Cuboid(2, 2, 2, 2);
        Container fSpace = new Container(15, 30, 5, 10);
        Layer layer = new Layer(cuboid, 3, 3);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        freeSpaceHandler.addLayer(layer);
        assertEquals((Integer) 3, freeSpaceHandler.getNumberOfFreeSpaces());
    }

    @Test
    public void firstFreeSpaceOnFloor() {
        Container fSpace = new Container(15, 30, 5, 10);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        assertTrue(freeSpaceHandler.getFreeSpace().isOnFloor());
    }

}
