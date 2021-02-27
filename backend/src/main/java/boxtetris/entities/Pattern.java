package boxtetris.entities;

import boxtetris.datastructures.MyList;

public class Pattern extends Dimensions {

    private Container container;
    private MyList<Layer> layers;
    private MyList<Coordinates> coordinatesList;

    public Pattern(Container container) {
        super(container.getLength(), container.getWidth(), container.getHeight());
        this.layers = new MyList<>();
        this.coordinatesList = new MyList<>();
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    /**
     * @return MyList<Layer>
     */
    public MyList<Layer> getLayers() {
        return layers;
    }

    public Boolean PatternIsEmpty() {
        return layers.size() == 0;
    }

    public void addPatternsDemands() {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).addLayersDemandToCuboid();
        }
    }

    public Integer removePatternsDemands() {
        Integer minDemand = Integer.MAX_VALUE;
        for (int i = 0; i < layers.size(); i++) {
            Layer layer = layers.get(i);
            layer.removeLayersDemandFromCuboid();
            Integer cuboidsDemand = layer.getCuboid().getDemand();
            if (cuboidsDemand < minDemand) {
                minDemand = cuboidsDemand;
            }
        }
        return minDemand;
    }

    /**
     * @return Double
     */
    public Double volumeUtilization() {
        Integer sumLayerVolumes = 0;
        for (int i = 0; i < layers.size(); i++) {
            sumLayerVolumes += layers.get(i).getVolume();
        }
        return (double) sumLayerVolumes / container.getVolume();
    }

    /**
     * @return Double
     */
    public Double weightUtilization() {
        Integer sumLayerWeights = 0;
        for (int i = 0; i < layers.size(); i++) {
            sumLayerWeights += layers.get(i).getWeight();
        }
        return (double) sumLayerWeights / container.getMaxWeight();
    }

    /**
     * @param layer
     */
    public void addLayer(Layer layer, Coordinates coordinates) {
        layers.add(layer);
        coordinatesList.add(coordinates);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String returnString = "Pattern: \n\n";
        returnString += "Container info: \n\n" + container.toString() + "\n";
        returnString += "Number of Layers: " + this.getLayers().size() + "\n\n";
        returnString += "Layer info: \n\n";
        for (int i = 0; i < layers.size(); i++) {
            returnString += layers.get(i).toString() + "\n";
            returnString += coordinatesList.get(i).toString() + "\n";
        }
        returnString += "Volume utilization: " + this.volumeUtilization() * 100 + "%";
        returnString += "Maxweight utlization: " + this.weightUtilization() * 100 + "%";
        return returnString;
    }
}
