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

    @Test
    public void packingPatternHugeTest() {
        containerSetHuge();
        cuboidSetHuge();
        MyList<Pattern> patterns = generatePatterns();
        assertEquals((Double) 1.0, patterns.get(0).volumeUtilization());
    }

    @Test
    public void largeDemand() {
        containerSetTriple();
        cuboidSetThree();
        MyList<Pattern> patterns = generatePatterns();
        assertEquals((Integer) 250, patterns.get(0).getContainer().getHeight());
    }

    /**
     * @return MyList<Pattern>
     */
    private MyList<Pattern> generatePatterns() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, 10, 10);
        MyList<Pattern> patterns = PackingPatterns.generatePackingPatterns(containers, layers, dimensionComparators);
        return patterns;
    }

    private void containerSetHuge() {
        containers.add(new Container("huge Container", 100000, 100000, 100000, 100000));
    }

    private void containerSetOne() {
        containers.add(new Container("Laatikko A", 200, 200, 200, 200));
    }

    private void containerSetTriple() {
        containers.add(new Container("Correct", 250, 250, 250, 1000));
        containers.add(new Container("Small", 25, 25, 25, 1000));
        containers.add(new Container("Big", 1000, 1000, 1000, 1000));
    }

    private void cuboidSetTwo() {
        cuboids.add(new Cuboid("tomaatteja", 200, 200, 200, 100, 5));
        cuboids.add(new Cuboid("herneitä", 10, 10, 10, 1, 10));
    }

    private void cuboidSetHuge() {
        cuboids.add(new Cuboid("vesimelooneja", 10000, 10000, 10000, 1, 1000));
    }

    private void cuboidSetOne() {
        cuboids.add(new Cuboid("tomaatteja", 20, 20, 20, 20, 5));
        cuboids.add(new Cuboid("Mansikoita", 20, 20, 20, 20, 1));
    }

    private void cuboidSetThree() {
        cuboids.add(new Cuboid("Cucumbers", 25, 25, 25, 1, 1000));
    }
}