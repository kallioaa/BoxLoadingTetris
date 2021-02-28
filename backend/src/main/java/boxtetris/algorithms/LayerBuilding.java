package boxtetris.algorithms;

import boxtetris.datastructures.MyList;
import boxtetris.entities.Layer;
import boxtetris.entities.Cuboid;

public class LayerBuilding {

    private LayerBuilding() {
    }

    /**
     * Creates layers from homogenous cuboids. These layers are used in the
     * PackingPattern algoritm.
     * 
     * @param cuboids         A list of cuboids with demands
     * @param maxCuboidsInRow The maximum amount of cuboids in a row
     * @param maxRowsInLayer  The maximum amount of rows in laeyr§
     * @return MyList<Layer> MyList of layers
     */
    public static MyList<Layer> generateLayers(MyList<Cuboid> cuboids, Integer maxCuboidsInRow,
            Integer maxRowsInLayer) {
        MyList<Layer> layers = new MyList<>();
        for (int i = 0; i < cuboids.size(); i++) { // Item types
            Cuboid cuboid = cuboids.get(i);
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    cuboid.rotate();
                }
                for (int k = 1; k <= maxRowsInLayer; k++) { // Number of items in a row
                    for (int l = 1; l <= maxCuboidsInRow; l++) { // Number of rows in a layer
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
