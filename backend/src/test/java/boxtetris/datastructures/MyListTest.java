package boxtetris.datastructures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class MyListTest {

    private static MyList<Integer> list;

    @Before
    public void setup() {
        list = new MyList<>();
    }

    @Test
    public void addItemsFirstIndex() {
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals((Integer) 2, list.get(0));
    }

    @Test
    public void addItemsMiddleIndex() {
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals((Integer) 3, list.get(2));
    }

    @Test
    public void addItemsLongList() {
        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }
        assertEquals((Integer) 10, list.get(9));
    }

    @Test
    public void addItemsSuperLongList() {
        for (int i = 1; i <= 150; i++) {
            list.add(i);
        }
        assertEquals((Integer) 100, list.get(99));
    }

    @Test
    public void correctLength() {
        for (int i = 1; i <= 150; i++) {
            list.add(i);
        }
        assertEquals((Integer) 150, list.size());
    }

    @Test
    public void removeItemItemsMove() {
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(2);
        list.remove(2);
        assertEquals((Integer) 5, list.get(2));
    }

    @Test
    public void removeItemlenghtDecreases() {
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(2);
        list.remove(2);
        assertEquals((Integer) 3, list.size());
    }

    @Test
    public void toArrayTest() {
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(7);
        Object[] array = list.toArray();
        assertArrayEquals(new Object[] { 2, 1, 4, 4, 5, 7 }, array);
    }

    @Test
    public void addAllStrings() {
        MyList<String> testi = new MyList<>();
        String[] array = new String[] { "tomaatti", "kurkku", "vesimelooni", "kuha" };
        testi.addAll(array);
        assertArrayEquals(new Object[] { "tomaatti", "kurkku", "vesimelooni", "kuha" }, testi.toArray());
    }

    @Test
    public void clearStrings() {
        MyList<String> testi = new MyList<>();
        String[] array = new String[] { "tomaatti", "kurkku", "vesimelooni", "kuha" };
        testi.addAll(array);
        testi.clear();
        assertArrayEquals(new Object[] {}, testi.toArray());
    }

    @Test
    public void removeIndexZeroWorks() {
        MyList<String> testi = new MyList<>();
        testi.add("teistitesti");
        testi.add("teistitesti2");
        testi.remove(0);
        assertEquals("teistitesti2", testi.get(0));
    }

    @Test
    public void removeOutOfBoundsEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);
        });
    }

    @Test
    public void removeOutOfBoundsTooLarge() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2);
            list.add(1);
            list.remove(1);
            list.remove(1);
        });
    }

    @Test
    public void getOutOfBoundsEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @Test
    public void getOutOfBoundsTooLarge() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2);
            list.add(1);
            list.get(2);
        });
    }

}