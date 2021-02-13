package boxtetris.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boxtetris.collections.DimensionComparerOne;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;

public class FreeSpaceHandlerTest {

    @Test
    public void firstSpaceIsCorrect() {
        FreeSpace fSpace = new FreeSpace(15, 30, 5);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparerOne());
        FreeSpace served = freeSpaceHandler.getFreeSpace();
        assertEquals(fSpace, served);
    }

    @Test
    public void nOfSpacesIsCorrect() {
        FreeSpace fSpace = new FreeSpace(15, 30, 5);
        Layer layer = new Layer(3, 3, 3, 3, 3);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparerOne());
        freeSpaceHandler.addLayer(layer);
        assertEquals((Integer) 3, freeSpaceHandler.returnFreeSpaces());
    }

    @Test
    public void firstFreeSpaceOnFloor() {
        FreeSpace fSpace = new FreeSpace(15, 30, 5);
        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(fSpace, new DimensionComparerOne());
        assertTrue(freeSpaceHandler.getFreeSpace().isOnFloor());
    }

}
