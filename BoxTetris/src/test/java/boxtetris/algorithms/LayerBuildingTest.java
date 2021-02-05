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
        LayerBuilding LayerBuilder = new LayerBuilding(5, 5);
        MyList<Layer> layers = LayerBuilder.layerBuilding(cuboids, demands);
        assertTrue(layers.isEmpty());
    }

    @Test
    public void oneCuboidOneDemand() {
        cuboids.add(new Cuboid(20, 20, 20, 2));
        demands.add(1);
        LayerBuilding LayerBuilder = new LayerBuilding(5, 5);
        MyList<Layer> layers = LayerBuilder.layerBuilding(cuboids, demands);
        System.out.println(layers.get(0).getLength());
        assertEquals((Integer) 2, layers.size());
    }

    @Test
    public void oneCuboidtwoDemand() {
        cuboids.add(new Cuboid(20, 20, 20, 2));
        demands.add(2);
        LayerBuilding LayerBuilder = new LayerBuilding(5, 5);
        MyList<Layer> layers = LayerBuilder.layerBuilding(cuboids, demands);
        System.out.println(layers.get(0).getLength());
        assertEquals((Integer) 6, layers.size());
    }

    @Test
    public void twoCuboidtwoDemand() {
        cuboids.add(new Cuboid(20, 20, 20, 2));
        cuboids.add(new Cuboid(30, 30, 30, 2));
        demands.add(2);
        demands.add(2);
        LayerBuilding LayerBuilder = new LayerBuilding(5, 5);
        MyList<Layer> layers = LayerBuilder.layerBuilding(cuboids, demands);
        System.out.println(layers.get(0).getLength());
        assertEquals((Integer) 12, layers.size());
    }

}
