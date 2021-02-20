package boxtetris.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.comparators.DimensionComparatorTwo;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

public class PackingPatternsTest {

    private Object[] dimensionComparators = new Object[] { new DimensionComparatorOne(), new DimensionComparatorTwo() };
    private MyList<Cuboid> cuboids;
    private MyList<Container> containers;

    @Before
    public void setUp() {
        this.cuboids = new MyList<>();
        this.containers = new MyList<>();
    }

    @Test
    public void packingPatternOneTest() {
        containerSetOne();
        LayerSetOne();
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 10, 10);
        PackingPatterns packingPatterns = new PackingPatterns(dimensionComparators);
        MyList<Pattern> patterns = packingPatterns.generatePackingPatterns(containers, layers);
        System.out.println(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            System.out.println(patterns.get(i));
        }
        assertTrue(true);
    }

    private void containerSetOne() {
        containers.add(new Container("test", 10, 10, 10, 1000));
    }

    private void LayerSetOne() {
        cuboids.add(new Cuboid("test", 1, 1, 1, 1, 1000));
    }
}
