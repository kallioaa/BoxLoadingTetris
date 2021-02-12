package boxtetris.collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import boxtetris.algorithms.DimensionComparerOne;
import boxtetris.datastructures.MyList;
import boxtetris.entities.FreeSpace;

public class MyCollectionsTest {

    private MyList<FreeSpace> freeSpaces;

    @Before
    public void setUp() {
        this.freeSpaces = new MyList<>();
    }

    @Test
    public void freeSpacesSmall() {
        Object[] all = new Object[] { new FreeSpace(4, 2, 2), new FreeSpace(4, 2, 3), new FreeSpace(4, 2, 8) };
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparerOne());
        assertArrayEquals(new Object[] { new FreeSpace(4, 2, 8), new FreeSpace(4, 2, 3), new FreeSpace(4, 2, 2) },
                freeSpaces.toArray());

    }

}
