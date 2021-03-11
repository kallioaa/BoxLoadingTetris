package boxtetris.algorithms;

import static org.junit.Assert.assertEquals;

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
        cuboidSetOne();
        MyList<Pattern> patterns = generatePatterns();
        assertEquals((Integer) 1, patterns.size());
    }

    @Test
    public void packingPatterntwoTest() {
        containerSetOne();
        cuboidSetTwo();
        MyList<Pattern> patterns = generatePatterns();
        assertEquals((Integer) 6, patterns.size());
    }

    /**
     * @return MyList<Pattern>
     */
    private MyList<Pattern> generatePatterns() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 10, 10);
        MyList<Pattern> patterns = PackingPatterns.generatePackingPatterns(containers, layers, dimensionComparators);
        return patterns;
    }

    private void containerSetOne() {
        containers.add(new Container("Laatikko A", 200, 200, 200, 200));
    }

    private void cuboidSetTwo() {
        cuboids.add(new Cuboid("tomaatteja", 200, 200, 200, 100, 5));
        cuboids.add(new Cuboid("herneitä", 10, 10, 10, 1, 10));

    }

    private void cuboidSetOne() {
        cuboids.add(new Cuboid("tomaatteja", 20, 20, 20, 20, 5));
        cuboids.add(new Cuboid("Mansikoita", 20, 20, 20, 20, 1));
    }
}