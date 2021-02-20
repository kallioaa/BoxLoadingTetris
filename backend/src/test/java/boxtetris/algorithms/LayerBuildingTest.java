package boxtetris.algorithms;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;

public class LayerBuildingTest {
    private MyList<Cuboid> cuboids;

    @Before
    public void setUp() {
        this.cuboids = new MyList<>();
    }

    @Test
    public void noCuboidsNoLayers() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        assertTrue(layers.isEmpty());
    }

    @Test
    public void oneCuboidOneDemand() {
        cuboids.add(new Cuboid("test", 20, 20, 20, 2, 1));
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        assertEquals((Integer) 2, layers.size());
    }

    @Test
    public void oneCuboidtwoDemand() {
        cuboids.add(new Cuboid("test", 20, 20, 20, 2, 2));
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        assertEquals((Integer) 6, layers.size());
    }

    @Test
    public void twoCuboidtwoDemand() {
        cuboids.add(new Cuboid("test", 20, 40, 20, 2, 2));
        cuboids.add(new Cuboid("test", 30, 30, 30, 2, 2));
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        assertEquals((Integer) 12, layers.size());
    }

    @Test
    public void correctHeight() {
        cuboids.add(new Cuboid("test", 20, 40, 20, 2, 10));
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 5, 5);
        assertEquals((Integer) 20, layers.get(0).getHeight());
    }
}
