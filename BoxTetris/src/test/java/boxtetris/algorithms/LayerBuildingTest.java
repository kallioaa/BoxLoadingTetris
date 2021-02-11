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
    private MyList<Integer> demands;

    @Before
    public void setUp() {
        this.cuboids = new MyList<>();
        this.demands = new MyList<>();
    }

    @Test
    public void noCuboidsNoLayers() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, demands, 5, 5);
        assertTrue(layers.isEmpty());
    }

    @Test
    public void oneCuboidOneDemand() {
        cuboids.add(new Cuboid(20, 20, 20, 2));
        demands.add(1);
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, demands, 5, 5);
        assertEquals((Integer) 2, layers.size());
    }

    @Test
    public void oneCuboidtwoDemand() {
        cuboids.add(new Cuboid(20, 20, 20, 2));
        demands.add(2);
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, demands, 5, 5);
        assertEquals((Integer) 6, layers.size());
    }

    @Test
    public void twoCuboidtwoDemand() {
        cuboids.add(new Cuboid(20, 40, 20, 2));
        cuboids.add(new Cuboid(30, 30, 30, 2));
        demands.add(2);
        demands.add(2);
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, demands, 5, 5);
        assertEquals((Integer) 12, layers.size());
    }

    @Test
    public void correctHeight() {
        cuboids.add(new Cuboid(20, 40, 20, 2));
        demands.add(10);
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, demands, 5, 5);
        assertEquals((Integer) 20, layers.get(0).getHeight());
    }
}
