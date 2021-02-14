package boxtetris.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.entities.Container;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;

public class FreeSpaceHandlerTest {

    @Test
    public void firstSpaceIsCorrect() {
        FreeSpace fSpace = new FreeSpace(15, 30, 5);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        fSpace.setOnFloor();
        FreeSpace served = freeSpaceHandler.getFreeSpace();
        assertEquals(fSpace, served);
    }

    @Test
    public void nOfSpacesIsCorrect() {
        Container fSpace = new Container(15, 30, 5, 10);
        Layer layer = new Layer(3, 3, 3, 3, 3);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        freeSpaceHandler.addLayer(layer);
        assertEquals((Integer) 3, freeSpaceHandler.returnFreeSpaces());
    }

    @Test
    public void firstFreeSpaceOnFloor() {
        Container fSpace = new Container(15, 30, 5, 10);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparatorOne());
        assertTrue(freeSpaceHandler.getFreeSpace().isOnFloor());
    }

}
