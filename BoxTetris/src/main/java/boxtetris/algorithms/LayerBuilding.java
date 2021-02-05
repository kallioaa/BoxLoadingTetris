package boxtetris.algorithms;

import boxtetris.datastructures.*;
import boxtetris.entities.*;

public class LayerBuilding {

    private Integer itemsInRow;
    private Integer rowsInLayer;

    public LayerBuilding(Integer itemsInRow, Integer rowsInLayer) {
        this.itemsInRow = itemsInRow;
        this.rowsInLayer = rowsInLayer;
    }

    public MyList<Layer> layerBuilding(MyList<Cuboid> cuboids, MyList<Integer> demands) {
        MyList<Layer> layers = new MyList<>();
        for (int i = 0; i < cuboids.size(); i++) { // Item types
            Cuboid cuboid = cuboids.get(i);
            for (int j = 0; i < 2; j++) {
                if (j == 1) {
                    cuboid.rotate();
                }
                for (int k = 0; k < itemsInRow; k++) { // Number of items in a row
                    for (int l = 0; l < rowsInLayer; l++) { // Number of rows in a layer
                        if (k * l <= demands.get(i)) { // If the number is under demand
                            Integer length = cuboid.getLength() * k * l;
                            Integer width = cuboid.getWidth() * k * l;
                            Integer weight = cuboid.getWeight() * k * l;
                            Layer layer = new Layer(length, width, cuboid.getHeight(), weight);
                            layers.add(layer);
                        }
                    }
                }
            }
        }
        return layers;
    }
}