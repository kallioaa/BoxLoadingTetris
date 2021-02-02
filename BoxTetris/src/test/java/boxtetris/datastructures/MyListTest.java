package boxtetris.datastructures;
import static org.junit.Assert.assertEquals;

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
        for (int i=1;i<=15;i++) {
            list.add(i);
        }
        assertEquals((Integer) 10, list.get(9));
    }

    @Test
    public void addItemsSuperLongList() {
        for (int i=1;i<=150;i++) {
            list.add(i);
        }
        assertEquals((Integer) 100, list.get(99));
    }

    @Test
    public void correctLength() {
        for (int i=1;i<=150;i++) {
            System.out.println(i);
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
    public void removeItemlenghDecreases() {
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(2);
        list.remove(2);
        assertEquals((Integer) 3, list.size());
    }

}
