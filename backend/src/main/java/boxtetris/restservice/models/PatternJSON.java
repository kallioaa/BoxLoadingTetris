package boxtetris.restservice.models;

import java.util.ArrayList;

import boxtetris.entities.Container;
import boxtetris.entities.Coordinates;
import boxtetris.entities.Layer;

public class PatternJSON {
    private final Container container;
    private final ArrayList<Layer> layers;
    private final ArrayList<Coordinates> coordinates;
    private final Double volumeUtilization;
    private final Double weightUtilization;

    public PatternJSON(Container container, ArrayList<Layer> layers, ArrayList<Coordinates> coordinates,
            Double volumeUtilization, Double weightUtilization) {
        this.container = container;
        this.layers = layers;
        this.coordinates = coordinates;
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

    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    public Container getContainer() {
        return container;
    }

}