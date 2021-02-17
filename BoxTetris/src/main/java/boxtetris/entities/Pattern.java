package boxtetris.entities;

import boxtetris.datastructures.MyList;

public class Pattern extends Dimensions {

    private Container container;
    private MyList<Layer> layers;

    public Pattern(Container container) {
        super(container.getLength(), container.getWidth(), container.getHeight());
        this.layers = new MyList<>();
        this.container = container;
    }

    public MyList<Layer> getLayers() {
        return layers;
    }

    public Double volumeUtilization() {
        Integer sumLayerVolumes = 0;
        for (int i = 0; i < layers.size(); i++) {
            sumLayerVolumes += layers.get(i).getVolume();
        }
        return (double) sumLayerVolumes / container.getVolume();
    }

    /**
     * @param layer
     */
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

}
