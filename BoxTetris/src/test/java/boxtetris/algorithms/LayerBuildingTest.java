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
}
