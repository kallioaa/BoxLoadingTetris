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

public class App {

    private final PackingPatterns packingPatterns;
    private final MyList<Cuboid> cuboids;
    private final MyList<Container> containers;
    private final Integer itemsInRow;
    private final Integer rowsInLayer;

    public App(MyList<Cuboid> cuboids, MyList<Container> containers, Integer itemsInRow, Integer rowsInLayer) {
        this.packingPatterns = new PackingPatterns(
                new Object[] { new DimensionComparatorOne(), new DimensionComparatorTwo() });
        this.cuboids = cuboids;
        this.containers = containers;
        this.itemsInRow = itemsInRow;
        this.rowsInLayer = rowsInLayer;
    }

    
    /** 
     * @return MyList<Pattern>
     */
    public MyList<Pattern> getPatterns() {
        MyList<Layer> layers = LayerBuilding.generateLayers(cuboids, itemsInRow, rowsInLayer);
        MyList<Pattern> patterns = packingPatterns.generatePackingPatterns(containers, layers);
        return patterns;
    }

}
