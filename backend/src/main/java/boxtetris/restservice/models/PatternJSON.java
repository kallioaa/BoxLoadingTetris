package boxtetris.restservice.models;

import java.util.ArrayList;

import boxtetris.entities.Container;
import boxtetris.entities.Layer;

public class PatternJSON {
    public final Container container;
    public final ArrayList<Layer> layers;
    public final Double volumeUtilization;
    public final Double weightUtilization;

    public PatternJSON(Container container, ArrayList<Layer> layers, Double volumeUtilization,
            Double weightUtilization) {
        this.container = container;
        this.layers = layers;
        this.volumeUtilization = volumeUtilization;
        this.weightUtilization = weightUtilization;
    }

    public Double getVolumeUtilization() {
        return volumeUtilization;
    }

    public Double getWeightUtilization() {
        return weightUtilization;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public Container getContainer() {
        return container;
    }

}