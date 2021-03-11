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

    /**
     * @return Double
     */
    public Double getVolumeUtilization() {
        return volumeUtilization;
    }

    /**
     * @return Double
     */
    public Double getWeightUtilization() {
        return weightUtilization;
    }

    /**
     * @return ArrayList<Layer>
     */
    public ArrayList<Layer> getLayers() {
        return layers;
    }

    /**
     * @return ArrayList<Coordinates>
     */
    public ArrayList<Coordinates> getCoordinates() {
        return coordinates;
    }

    /**
     * @return Container
     */
    public Container getContainer() {
        return container;
    }

}