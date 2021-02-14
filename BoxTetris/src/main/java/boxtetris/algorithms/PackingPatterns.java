package boxtetris.algorithms;

import boxtetris.entities.Container;
import boxtetris.entities.Cuboid;
import boxtetris.entities.Dimensions;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Pattern;
import boxtetris.entities.Layer;

import java.util.Comparator;
import java.util.HashMap;

import boxtetris.comparators.DimensionComparatorOne;
import boxtetris.comparators.DimensionComparatorTwo;
import boxtetris.comparators.LayerComparators;
import boxtetris.collections.MyCollections;
import boxtetris.datastructures.MyList;

public class PackingPatterns {

    /**
     * @param containers
     * @param layers
     * @param demands
     * @return MyList<Pattern>
     */
    static MyList<Pattern> generatePatterns(MyList<Container> containers, MyList<Layer> layers,
            HashMap<Cuboid, Integer> demands) {
        Object[] dimensionsComparators = new Object[] { new DimensionComparatorOne(), new DimensionComparatorTwo() };
        Cuboid minDemand = findMin(demands);
        while (demands.get(minDemand) > 0) {
            for (int i = 0; i < containers.size(); i++) {
                Container container = containers.get(i);
                for (int j = 0; i < dimensionsComparators.length; j++) {
                    Comparator<Dimensions> dimensionsComparator = (Comparator<Dimensions>) dimensionsComparators[j];
                    FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(container, dimensionsComparator);
                    for (int k = 0; k < 9; k++) {
                        sortByRule(layers, k);
                        
                        FreeSpace fSpace = freeSpaceHandler.getFreeSpace();

                    }
                }

            }
        }

        return null;
    }

    private static void sortByRule(MyList<Layer> layers, int ruleNumber) {
        switch (ruleNumber) {
            case 0:
                MyCollections.sort(layers, new LayerComparators.WeightAndArea());
            case 1:
                MyCollections.sort(layers, new LayerComparators.WeightAndVolume());
            case 2:
                MyCollections.sort(layers, new LayerComparators.WeightAndHeight());
            case 3:
                MyCollections.sort(layers, new LayerComparators.HeightWeightAndArea());
            case 4:
                MyCollections.sort(layers, new LayerComparators.Area());
            case 5:
                MyCollections.sort(layers, new LayerComparators.Volume());
            case 6:
                MyCollections.sort(layers, new LayerComparators.Weight());
            case 7:
                MyCollections.sort(layers, new LayerComparators.Width());
            case 8:
                MyCollections.sort(layers, new LayerComparators.Length());
        }
    }

    /**
     * @param demands
     * @return Integer
     */
    private static Cuboid findMin(HashMap<Cuboid, Integer> demands) {
        Cuboid minDemand = null;
        for (Cuboid key : demands.keySet()) {
            Integer demand = demands.get(key);
            if (demand < demands.get(minDemand)) {
                minDemand = key;
            }
        }
        return minDemand;
    }
}
