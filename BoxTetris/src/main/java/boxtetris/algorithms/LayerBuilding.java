package boxtetris.algorithms;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Layer;
import boxtetris.entities.Cuboid;

public class LayerBuilding {

    private final Integer itemsInRow;
    private final Integer rowsInLayer;

    public LayerBuilding(Integer itemsInRow, Integer rowsInLayer) {
        this.itemsInRow = itemsInRow;
        this.rowsInLayer = rowsInLayer;
    }

    /**
     * @param cuboids
     * @param demands
     * @return MyList<Layer>
     */
    public MyList<Layer> createLayerList(MyList<Cuboid> cuboids, MyList<Integer> demands) {
        MyList<Layer> layers = new MyList<>();
        for (int i = 0; i < cuboids.size(); i++) { // Item types
            Cuboid cuboid = cuboids.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    cuboid.rotate();
                }
                for (int k = 1; k <= rowsInLayer; k++) { // Number of items in a row
                    for (int l = 1; l <= itemsInRow; l++) { // Number of rows in a layer
                        if (k * l <= demands.get(i)) { // If the number is under demand
                            Layer layer = createLayer(cuboid, k, l);
                            layers.add(layer);
                        }
                    }
                }
            }
        }
        return layers;
    }

    /**
     * @param cuboid
     * @param k
     * @param lßß
     * @return Layer
     */
    private Layer createLayer(Cuboid cuboid, Integer k, Integer l) {
        Integer length = cuboid.getLength() * l;
        Integer width = cuboid.getWidth() * k;
        Integer weight = cuboid.getWeight() * k * l;
        Layer layer = new Layer(length, width, cuboid.getHeight(), weight);
        return layer;
    }
}