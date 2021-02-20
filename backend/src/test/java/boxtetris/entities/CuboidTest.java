package boxtetris.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CuboidTest {

    @Test
    public void rotateWorks() {
        Cuboid cuboid = new Cuboid("test", 120, 140, 50, 3, 4);
        cuboid.rotate();
        assertEquals((Integer) 140, cuboid.getLength());
        assertEquals((Integer) 120, cuboid.getWidth());
    }

    @Test
    public void rotateWorksTwoTimes() {
        Cuboid cuboid = new Cuboid("test", 120, 140, 50, 3, 4);
        cuboid.rotate();
        cuboid.rotate();
        assertEquals((Integer) 120, cuboid.getLength());
        assertEquals((Integer) 140, cuboid.getWidth());
    }
}