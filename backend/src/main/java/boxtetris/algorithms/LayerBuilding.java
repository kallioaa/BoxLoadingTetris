package boxtetris.algorithms;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Layer;
import boxtetris.entities.Cuboid;

public class LayerBuilding {

    private LayerBuilding() {
    }

    /**
     * @param cuboids
     * @param demands
     * @return MyList<Layer>
     */
    public static MyList<Layer> generateLayers(MyList<Cuboid> cuboids, Integer itemsInRow, Integer rowsInLayer) {
        MyList<Layer> layers = new MyList<>();
        for (int i = 0; i < cuboids.size(); i++) { // Item types
            Cuboid cuboid = cuboids.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    cuboid.rotate();
                }
                for (int k = 1; k <= rowsInLayer; k++) { // Number of items in a row
                    for (int l = 1; l <= itemsInRow; l++) { // Number of rows in a layer
                        if (k * l <= cuboid.getDemand()) { // If the number is under demand
                            Layer layer = new Layer(cuboid, k, l);
                            layers.add(layer);
                        }
                    }
                }
            }
        }
        return layers;
    }
}
