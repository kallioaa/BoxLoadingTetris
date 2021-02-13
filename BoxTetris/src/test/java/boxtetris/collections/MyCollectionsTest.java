package boxtetris.collections;

import static org.junit.Assert.assertArrayEquals;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import boxtetris.datastructures.MyList;
import boxtetris.entities.FreeSpace;
import junit.framework.AssertionFailedError;

public class MyCollectionsTest {

    private MyList<FreeSpace> freeSpaces;
    private Random random;

    @Before
    public void setUp() {
        this.random = new Random();
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

    @Test
    public void freeSpacesLarge() {
        FreeSpace[] all = new FreeSpace[100];
        for (int i = 0; i < all.length; i++) {
            all[i] = new FreeSpace(3, 4, random.nextInt(100));
        }
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparerOne());
        Integer prev = Integer.MAX_VALUE;
        for (int i = 0; i < freeSpaces.size(); i++) {
            if (freeSpaces.get(i).getHeight() > prev) {
                throw new AssertionFailedError();
            }
            prev = freeSpaces.get(i).getHeight();
        }
    }

    @Test
    public void freeSpacesAllVariables() {
        FreeSpace[] all = new FreeSpace[100];
        for (int i = 0; i < all.length; i++) {
            all[i] = new FreeSpace(random.nextInt(100), random.nextInt(100), random.nextInt(100));
        }
        freeSpaces.addAll(all);
        MyCollections.sort(freeSpaces, new DimensionComparerOne());
        Integer prevHeight = Integer.MAX_VALUE;
        Integer prevWidth = Integer.MAX_VALUE;
        for (int i = 0; i < freeSpaces.size(); i++) {
            if (freeSpaces.get(i).getHeight() == prevHeight) {
                if (freeSpaces.get(i).getWidth() > prevWidth) {
                    throw new AssertionFailedError();
                }
            }
            prevHeight = freeSpaces.get(i).getHeight();
            prevWidth = freeSpaces.get(i).getWidth();
        }
    }

}
