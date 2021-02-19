package boxtetris.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

public class DemandHandlerTest {

    private MyList<Cuboid> cuboids;
    private MyList<Integer> demands;
    private Random random;

    @Before
    public void setUp() {
        this.cuboids = new MyList<>();
        this.demands = new MyList<>();
        this.random = new Random();

    }

    @Test
    public void minDemandCorrect() {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            Integer dimensionInt = random.nextInt(100);
            Integer demand = random.nextInt(100);
            if (demand < min) {
                min = demand;
            }
            cuboids.add(new Cuboid(dimensionInt % 4, dimensionInt % 2, dimensionInt % 5, dimensionInt % 3));
            demands.add(demand);
        }
        DemandHandler demandHandler = new DemandHandler(cuboids, demands);
        assertEquals(min, demandHandler.getMinDemand());
    }

    @Test
    public void patternAddWorksOne() {
        Cuboid cuboidOne = new Cuboid(20, 20, 20, 20);
        cuboids.add(cuboidOne);
        cuboids.add(new Cuboid(20, 30, 20, 20));
        cuboids.add(new Cuboid(20, 40, 20, 20));
        demands.add(3);
        demands.add(4);
        demands.add(3);
        DemandHandler demandHandler = new DemandHandler(cuboids, demands);
        Container container = new Container(300, 300, 200, 2000);
        Pattern pattern = new Pattern(container);
        Layer layer = new Layer(cuboidOne, 1, 3);
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        demandHandler.removePatternsDemands(pattern);
        assertEquals((Integer) 0, demandHandler.getMinDemand());

    }

    @Test
    public void patternAddWorksTwo() {
        Cuboid cuboidOne = new Cuboid(20, 20, 20, 20);
        cuboids.add(cuboidOne);
        cuboids.add(new Cuboid(20, 30, 20, 20));
        cuboids.add(new Cuboid(20, 40, 20, 20));
        demands.add(69);
        demands.add(42);
        demands.add(44);
        DemandHandler demandHandler = new DemandHandler(cuboids, demands);
        Container container = new Container(300, 300, 200, 2000);
        Pattern pattern = new Pattern(container);
        Layer layer = new Layer(cuboidOne, 1, 6);
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        pattern.addLayer(layer, new Coordinates(0, 0, 0));
        demandHandler.removePatternsDemands(pattern);
        assertEquals((Integer) 39, demandHandler.getMinDemand());

    }
}
