package boxtetris.collections;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import boxtetris.entities.FreeSpace;

public class DimensionComparerTwoTest {

    private static DimensionComparatorTwo comparer;

    @BeforeClass
    public static void setUp() {
        comparer = new DimensionComparatorTwo();
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
    public void sameHeightFirstIsShorter() {
        FreeSpace first = new FreeSpace(3, 3, 3);
        FreeSpace second = new FreeSpace(5, 3, 3);
        assertEquals(1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightFirstIsLonger() {
        FreeSpace first = new FreeSpace(3, 3, 3);
        FreeSpace second = new FreeSpace(5, 3, 3);
        assertEquals(1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightSameLengthFirstIsNarrower() {
        FreeSpace first = new FreeSpace(6, 3, 3);
        FreeSpace second = new FreeSpace(6, 4, 3);
        assertEquals(-1, comparer.compare(first, second));
    }

    @Test
    public void sameHeightSameWidthFirstIsWider() {
        FreeSpace first = new FreeSpace(6, 12, 3);
        FreeSpace second = new FreeSpace(6, 10, 3);
        assertEquals(1, comparer.compare(first, second));
    }
}
