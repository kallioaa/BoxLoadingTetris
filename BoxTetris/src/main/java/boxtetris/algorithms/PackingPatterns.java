package boxtetris.algorithms;

import java.util.Comparator;

import boxtetris.collections.MyCollections;
import boxtetris.comparators.LayerComparators;
import boxtetris.datastructures.MyList;
import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Dimensions;
import boxtetris.entities.FreeSpace;
import boxtetris.entities.Layer;
import boxtetris.entities.Pattern;

public class PackingPatterns {
    private final Object[] dimensionComparators;

    public PackingPatterns(Object[] dimensionComprators) {
        this.dimensionComparators = dimensionComprators;
    }

    /**
     * @param containers
     * @param layers
     * @param demandHandler
     * @return MyList<Pattern>
     */
    @SuppressWarnings("unchecked")
    public MyList<Pattern> generatePackingPatterns(MyList<Container> containers, MyList<Layer> layers,
            DemandHandler demandHandler) {
        MyList<Pattern> patterns = new MyList<>();
        while (demandHandler.getMinDemand() > 0) { // While there exists unmet demand for a certain cuboid
            Pattern best = null; // Best packing pattern
            for (int i = 0; i < containers.size(); i++) { // Pick a container
                Container container = containers.get(i);
                for (int j = 0; j < dimensionComparators.length; j++) { // Select a space selection criteria
                    Comparator<Dimensions> dimensionComparator = (Comparator<Dimensions>) dimensionComparators[j];
                    for (int k = 0; k < 9; k++) { // Select a layer selection criteria
                        FreeSpaceHandler freeSpaceHandler = new FreeSpaceHandler(container, dimensionComparator);
                        sortByRule(layers, k); // sort the array by rule k
                        Pattern pattern = generateAPattern(container, layers, freeSpaceHandler, demandHandler);
                        Double patternVolUtil = pattern.volumeUtilization();
                        if (best != null) {
                            if (patternVolUtil > best.volumeUtilization()) {
                                best = pattern;
                            }
                        } else {
                            best = pattern;
                        }
                    }
                }
            }
            patterns.add(best);
            demandHandler.removePatternsDemands(best);
        }
        return patterns;
    }

    /**
     * @param container
     * @param layers
     * @param freeSpaceHandler
     * @return Pattern
     */
    private Pattern generateAPattern(Container container, MyList<Layer> layers, FreeSpaceHandler freeSpaceHandler,
            DemandHandler demandHandler) {
        Pattern pattern = new Pattern(container);
        Integer currentWeight = 0;
        while (true) {
            FreeSpace next = freeSpaceHandler.getFreeSpace();
            if (next == null) { // null indicates there are no more freespaces
                break;
            }
            for (int i = 0; i < layers.size(); i++) { // loop over the layers
                Layer layer = layers.get(i);
                if (layer.getNumberOfCuboid() <= demandHandler.getCuboidsDemand(layer.getCuboid())) {
                    if (currentWeight + layer.getWeight() <= container.getMaxWeight()) { // container weight limit test
                        Coordinates coordinates = freeSpaceHandler.addLayer(layer); // null if freespace is too small
                                                                                    // for //
                                                                                    // the
                        if (coordinates != null) {
                            demandHandler.removeLayersDemand(layer);
                            pattern.addLayer(layer, coordinates); // we add the layer to pattern
                            break;
                        }
                    }
                }
                if (i == layers.size() - 1) { // Will remove the free space from the list if no layer fits
                    freeSpaceHandler.removeFreeSpace();
                }
            }

        }
        demandHandler.addPatternsDemands(pattern);
        return pattern;
    }

    /**
     * @param layers
     * @param ruleNumber
     */
    private void sortByRule(MyList<Layer> layers, int ruleNumber) {
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
}