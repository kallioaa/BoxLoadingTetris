package boxtetris;

import boxtetris.algorithms.LayerBuilding;
import boxtetris.algorithms.PackingPatterns;
import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.comparators.DimensionComparatorTwo;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

/**
 * Class ties together all functionality of this program.
 */
public class App {

    private final Object[] dimensionComparators;
    private final MyList<Cuboid> cuboids;
    private final MyList<Container> containers;
    private final Integer cuboidsInRow;
    private final Integer rowsInLayer;

    public App(MyList<Cuboid> cuboids, MyList<Container> containers, Integer cuboidsInRow, Integer rowsInLayer) {
        this.dimensionComparators = new Object[] { new DimensionComparatorOne(), new DimensionComparatorTwo() };
        this.cuboids = cuboids;
        this.containers = containers;
        this.cuboidsInRow = cuboidsInRow;
        this.rowsInLayer = rowsInLayer;
    }

    /**
     * Generates the "optimal" packing patterns.
     * 
     * @return MyList<Pattern>
     */
    public MyList<Pattern> getPatterns() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, cuboidsInRow, rowsInLayer);
        MyList<Pattern> patterns = PackingPatterns.generatePackingPatterns(containers, layers, dimensionComparators);
        return patterns;
    }

}
