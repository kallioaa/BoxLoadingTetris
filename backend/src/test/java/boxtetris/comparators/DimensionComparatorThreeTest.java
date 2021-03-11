package boxtetris.comparators;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import boxtetris.entities.Container;

public class DimensionComparatorThreeTest {

    private static DimensionComparatorThree comparer;

    @BeforeClass
    public static void setUp() {
        comparer = new DimensionComparatorThree();
    }

    @Test
    public void firstIsSmaller() {
        Container first = new Container("A", 5, 3, 3, 100);
        Container second = new Container("B", 10, 10, 10, 100);
        assertEquals(-1, comparer.compare(first, second));
    }

    @Test
    public void firstIsLarger() {
        Container first = new Container("A", 5, 3, 300, 100);
        Container second = new Container("B", 10, 10, 10, 100);
        assertEquals(1, comparer.compare(first, second));
    }

}
