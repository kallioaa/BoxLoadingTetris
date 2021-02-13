package boxtetris.collections;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import boxtetris.entities.FreeSpace;

public class DimensionComparerOneTest {

    private static DimensionComparerOne comparer;

    @BeforeClass
    public static void setUp() {
        comparer = new DimensionComparerOne();
    }

    @Test
    public void firstIsTaller() {
        FreeSpace first = new FreeSpace(5, 3, 3);
        FreeSpace second = new FreeSpace(5, 3, 2);
        assertEquals(1, comparer.compare(first, second));
    }

    @Test
    public void secondIsTaller() {
        FreeSpace first = new FreeSpace(5, 3, 3);
        FreeSpace second = new FreeSpace(5, 3, 4);
        assertEquals(-1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightFirstIsWider() {
        FreeSpace first = new FreeSpace(5, 4, 3);
        FreeSpace second = new FreeSpace(5, 3, 3);
        assertEquals(1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightSameWidthFirstIsShorter() {
        FreeSpace first = new FreeSpace(3, 4, 3);
        FreeSpace second = new FreeSpace(5, 4, 3);
        assertEquals(1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightSameWidthFirstIsLonger() {
        FreeSpace first = new FreeSpace(6, 4, 3);
        FreeSpace second = new FreeSpace(5, 4, 3);
        assertEquals(-1, comparer.compare(first, second));
    }
}
